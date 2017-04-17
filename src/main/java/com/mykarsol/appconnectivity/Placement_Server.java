package com.mykarsol.appconnectivity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataObjects.Candidate_Profile_Object;
import DataObjects.Placement_Details_Object;
import DataOperations.Candidate_Profile_Operation;
import DataOperations.Placement_Details_Operation;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shivam Patel
 */
public class Placement_Server extends HttpServlet {

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
           String batchyear,candidate_id,designation,salarydetails,workprofile,doj;
           int companyid;
      String message="";
      
      PrintWriter out = response.getWriter();
      batchyear=request.getParameter("batchyear");
      candidate_id = request.getParameter("candidate_id");
      companyid = Integer.parseInt(request.getParameter("companyname"));
      designation = request.getParameter("designation");
      salarydetails = request.getParameter("salarydetails");
      workprofile = request.getParameter("workprofile");
      doj = request.getParameter("doj"); 
      
      Placement_Details_Object pdo=new Placement_Details_Object();
      pdo.setCandidate_ID(candidate_id);
      pdo.setCid(companyid);
      pdo.setDesignation(designation);
      pdo.setSalarydetails(salarydetails);
      pdo.setWorkprofile(workprofile);
      pdo.setDoj(doj);
     
      
      
      //out.println("<h1>" + message + "</h1>");
      Placement_Details_Operation pdop= new Placement_Details_Operation();
      
      message = pdop.InsertPlacementetails(pdo);
       out.println(message);
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
