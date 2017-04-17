package com.mykarsol.appconnectivity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataObjects.Project_Details_Object;
import DataObjects.Technologies_Object;
import DataOperations.Project_Details_Operation;
import DataOperations.Technology_Operation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shivam Patel
 */
public class Candidate_Project_Details extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Candidate_Educational_Details</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Candidate_Educational_Details at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String Candidate_ID,Title,Functionality,Grade,Year;
           int Project_ID;
      String message="";
      //Date Dt=new Date();
      //Variable Initilization
      Project_ID = Integer.parseInt(request.getParameter("project_id"));
      Candidate_ID =request.getParameter("candidate_id");
      Title = request.getParameter("title");
      Functionality = request.getParameter("functionality");
      Grade = request.getParameter("grade");
      Year = request.getParameter("year");

       Project_Details_Object pdo=new Project_Details_Object();
       pdo.setProject_ID(Project_ID);
       pdo.setCandidate_ID(Candidate_ID);
       pdo.setTitle(Title);
       pdo.setFunctionality(Functionality);
       pdo.setGrade(Grade);
       pdo.setYear(Year);
      
      
      //out.println("<h1>" + message + "</h1>");
             Project_Details_Operation pdop=new Project_Details_Operation();
      
      message = pdop.InsertProjectDetails(pdo);
       out.println(message);
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
