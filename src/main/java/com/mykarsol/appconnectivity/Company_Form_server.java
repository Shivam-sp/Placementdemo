package com.mykarsol.appconnectivity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataObjects.Candidate_Profile_Object;
import DataObjects.Company_Details_Object;
import DataOperations.Candidate_Profile_Operation;
import DataOperations.Company_Details_Operation;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shivam Patel
 */
public class Company_Form_server extends HttpServlet {

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
        processRequest(request, response);
         try (PrintWriter out = response.getWriter()) {
         String Companyname,Address,City,Emailid,Url,Briefprofile,Password;
      double Contactno,Pincode;
      int Cid;
      String message="";
      //Date Dt=new Date();
      //Variable Initilization
      Cid = Integer.parseInt(request.getParameter("cid"));
      Companyname = request.getParameter("companyname");
        Address = request.getParameter("address");
          Pincode = Double.parseDouble(request.getParameter("pincode"));
           City = request.getParameter("city");
           Contactno = Double.parseDouble(request.getParameter("contactno"));
      Emailid = request.getParameter("email");
      Url=request.getParameter("cmpurl");
      Briefprofile=request.getParameter("briefprofile");
      Password = request.getParameter("password");
    

      Company_Details_Object cdo = new Company_Details_Object();
      cdo.setCid(Cid);
      cdo.setCname(Companyname);
      cdo.setAddress(Address);
      cdo.setPincode(Pincode);
      cdo.setCity(City);
      cdo.setContact_No(Contactno);
      cdo.setEmail(Emailid);
      cdo.setUrl(Url);
      cdo.setBriefprofile(Briefprofile);
      cdo.setPassword(Password);
      
      
      //out.println("<h1>" + message + "</h1>");
       Company_Details_Operation cdop= new Company_Details_Operation();
      
      message = cdop.InsertCompanyDetails(cdo);
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
