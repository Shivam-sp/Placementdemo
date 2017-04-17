package com.mykarsol.appconnectivity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataObjects.Candidate_Profile_Object;
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
public class Candidate_Data_Server extends HttpServlet {

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
        try {
             
            //JSONObject json=new JSONObject();
            Class.forName(JDBC_DRIVER);
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute SQL query
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt=null;
            String sql;
            String candidate_id=request.getParameter("candidate_id");
            System.out.println("----"+candidate_id);
            sql = "select Firstname,Image,Degree from  candidate_profile ,qualification where candidate_profile.candidate_id=?";
            //Candidate_Profile_Object cpo=new Candidate_Profile_Object();
            //cpo.setCandidate_ID(candidate_id);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,candidate_id);
            ResultSet rs = pstmt.executeQuery();
            //rs=pstmt.executeQuery();
           
           JSONArray jArray = new JSONArray();
             ArrayList<JSONObject>al=new ArrayList<JSONObject>();
         int i=0;
         String age = "21";
         //while(rs.next()){
            //Retrieve by column name
            rs.next();
            String first = rs.getString("Firstname"); 
            String image = rs.getString("Image");
            String degree = rs.getString("Degree");
          
             JSONObject json=new JSONObject();
             json.put("first",first);
             json.put("age", age);
             json.put("image",image);
             json.put("degree",degree);
             
             //out.println(json.toString());
             jArray.put(i,json);
             out.println(jArray.toString());
             //i++;
         //}
        } catch (SQLException ex) { 
           System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
          System.out.println(ex.getMessage());
        } catch (JSONException ex) {
            Logger.getLogger(Candidate_Data_Server.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
