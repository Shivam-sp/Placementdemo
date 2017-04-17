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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Shivam Patel
 */
public class Admin_Candidate_Verification extends HttpServlet {

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
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://localhost/placementapp";
      //  Database credentials
      static final String USER = "root";
      static final String PASS = "8128";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
         try
         {
            /* TODO output your page here. You may use following sample code. */
               Class.forName(JDBC_DRIVER);
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute SQL query
           // Statement stmt = conn.createStatement();
            //PreparedStatement pstmt=null;
            //String sql;
           // String candidate_id=request.getParameter("candidate_id");
           // System.out.println("----"+candidate_id);
            //sql = "select * from  candidate_profile  where candidate_profile.candidate_id=?";
            //Candidate_Profile_Object cpo=new Candidate_Profile_Object();
            //cpo.setCandidate_ID(candidate_id);
           // pstmt=conn.prepareStatement(sql);
           // pstmt.setString(1,candidate_id);
           // ResultSet rs = pstmt.executeQuery();
            //rs=pstmt.executeQuery();
             JSONArray jArray = new JSONArray();
            String firstname,middlename,candidateid;
           Candidate_Profile_Operation cpop = new Candidate_Profile_Operation();
           ArrayList<Candidate_Profile_Object> userlist=(new Candidate_Profile_Operation()).allids();
            for( int x = 0 ; x < userlist.size() ; x++ ) {
                Candidate_Profile_Object cpb=(Candidate_Profile_Object)userlist.get(x);
               candidateid=cpb.getCandidate_ID();
               firstname=cpb.getFirstname();
               middlename=cpb.getMiddlename();
               
                System.out.println(firstname);
             JSONObject json=new JSONObject();
             json.put("candidateid",candidateid);
             json.put("firstname",firstname);
             json.put("middlename",middlename);
             
             //out.println(json.toString());
             jArray.put(x,json);
            }
            out.println(jArray.toString());
          
    
         //while(rs.next()){
            //Retrieve by column name
           
           
        } catch (ClassNotFoundException ex) {
           System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (JSONException ex) {
            Logger.getLogger(Admin_Candidate_Verification.class.getName()).log(Level.SEVERE, null, ex);
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
