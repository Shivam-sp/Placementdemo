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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
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
public class AppConnectivity extends HttpServlet {

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
           String candidate_id,Firstname,Middlename,Lastname,Gender,Email,Address,City,Image,Password;
      double Contactno,Alternativeno,Pincode;
      String message="";
      //Date Dt=new Date();
      //Variable Initilization
      candidate_id = request.getParameter("candidate_id");
      Firstname = request.getParameter("firstname");
      Middlename = request.getParameter("middlename");
      Lastname = request.getParameter("lastname");
      Gender = request.getParameter("gender");
      Email = request.getParameter("email");
      Address = request.getParameter("address");
      City = request.getParameter("city");
      Image = request.getParameter("imagepath");
      Password = request.getParameter("password");
      String D=request.getParameter("dob");
      SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
      Date Dob=sdf.parse(D);
      Contactno = Double.parseDouble(request.getParameter("contactno"));
      Alternativeno = Double.parseDouble(request.getParameter("alternativeno"));
      Pincode = Double.parseDouble(request.getParameter("pincode"));

      Candidate_Profile_Object cpo = new Candidate_Profile_Object();
      cpo.setCandidate_ID(candidate_id);
      cpo.setFirstname(Firstname);
      cpo.setMiddlename(Middlename);
      cpo.setLastname(Lastname);
      cpo.setGender(Gender);
      cpo.setDOB(Dob);
      cpo.setContact_No(Contactno);
      cpo.setAlternative_No(Alternativeno);
      cpo.setEmail(Email);
      cpo.setAddress(Address);
      cpo.setPincode(Pincode);
      cpo.setCity(City);
      cpo.setImage(Image);
      cpo.setPassword(Password);
      
      
      //out.println("<h1>" + message + "</h1>");
      Candidate_Profile_Operation cpop = new Candidate_Profile_Operation();
      
      message = cpop.InsertCandidateDetails(cpo);
       out.println(message);
        } catch (ParseException ex) {
           System.out.println(ex.getMessage());
        }
        // processRequest(request, response);
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
        doGet(request, response);
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
