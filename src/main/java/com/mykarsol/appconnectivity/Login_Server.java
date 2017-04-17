package com.mykarsol.appconnectivity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataObjects.Candidate_Profile_Object;
import DataOperations.Candidate_Profile_Operation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shivam Patel
 */
public class Login_Server extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            String Username,Password;
            String message="";
            Username = request.getParameter("username");
            Password = request.getParameter("password");
            Candidate_Profile_Object cpo = new Candidate_Profile_Object();
            cpo.setCandidate_ID(Username);
            cpo.setPassword(Password);
            //out.println(Username);
            //out.println(Password);
            Candidate_Profile_Operation cpop = new Candidate_Profile_Operation();
            //cpop.RetriveCandidateDetails(cpo);
            // out.println(cpop);
            String usn,usp,name,uimg;
            ArrayList<Candidate_Profile_Object> userlist=(new Candidate_Profile_Operation()).allids();
            for( int x = 0 ; x < userlist.size() ; x++ ) {
                Candidate_Profile_Object cpb=(Candidate_Profile_Object)userlist.get(x);
                usn=cpb.getCandidate_ID();
                usp=cpb.getPassword();
                uimg=cpb.getImage();
                
                if(usn.equals(Username) && usp.equals(Password))
                {
                    name=cpb.getFirstname();
                    System.err.println(name);
                    if(name.equals("admin"))
                    {
                        out.println("admatch");
                    }
                    else
                    {
                    out.println("UPMatched"+"-"+name+"-"+uimg);
                    break;
                    }
                }
                else
                {
                    out.println("NotMatched"+usn+usp);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
