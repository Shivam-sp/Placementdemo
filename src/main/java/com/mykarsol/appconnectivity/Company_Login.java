package com.mykarsol.appconnectivity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataObjects.Company_Details_Object;
import DataOperations.Company_Details_Operation;
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
public class Company_Login extends HttpServlet {

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
            int Username;
            String Password;
        String message="";
            Username = Integer.parseInt(request.getParameter("username"));
            Password = request.getParameter("password");
            Company_Details_Object cpo = new Company_Details_Object();
            cpo.setCid(Username);
            cpo.setPassword(Password);
            //out.println(Username);
            //out.println(Password);
            Company_Details_Operation cdop = new Company_Details_Operation();
            //cpop.RetriveCandidateDetails(cpo);
            // out.println(cpop);
            int usn;
            String usp;
            ArrayList<Company_Details_Object> userlist=(new Company_Details_Operation()).allcids();
            for( int x = 0 ; x < userlist.size() ; x++ ) {
                Company_Details_Object cpb=(Company_Details_Object)userlist.get(x);
                usn=cpb.getCid();
                usp=cpb.getPassword();
                if((usn == Username) && usp.equals(Password))
                {
                    String cname=cpb.getCname();
                    out.println("UPMatched"+"-"+cname);
                    break;
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
