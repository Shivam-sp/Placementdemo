package com.mykarsol.appconnectivity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Shivam Patel
 */
public class Admin_Get_Technology extends HttpServlet {

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
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         // Register JDBC driver
         Class.forName(JDBC_DRIVER);

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
         ///String year=request.getParameter("year");
         // Execute SQL query
         Statement stmt = conn.createStatement();
         PreparedStatement pstmt=null;
         String sql;
         sql = "select * from technology";
             //Project_Details_Object pdo=new Project_Details_Object();
             //pdo.setYear(year);
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         JSONArray jArray = new JSONArray();
            // ArrayList<JSONObject>al=new ArrayList<JSONObject>();
         int i=0;
         while(rs.next()){
            //Retrieve by column name
            int Tid = rs.getInt("Tid");
            String Techname =rs.getString("Techname");
            String Ttype = rs.getString("Techtype");
             JSONObject json=new JSONObject();
             
             json.put("Tid",Tid);
             json.put("Tname", Techname);
             json.put("Ttype", Ttype);
             jArray.put(i,json);
             i++;
            // al.add(json);
             //out.println(al);
            // String output=jArray.toString();
           
            //Display values
           // System.out.println("ID: " + id + "<br>");
            //System.out.println(", Age: " + age + "<br>");
            //System.out.println(", First: " + first + "<br>");
            //System.out.println(", Last: " + last + "<br>");
         }
         out.println(jArray.toString());
        // out.println("</body></html>");

          String p=getServletContext().getRealPath("\\images");
          File f=new File(p);
          if(!f.exists())
          {
              f.mkdir();
          }
          
             System.out.println("---------"+p);
         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_Get_Technology.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Get_Technology.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Admin_Get_Technology.class.getName()).log(Level.SEVERE, null, ex);
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
