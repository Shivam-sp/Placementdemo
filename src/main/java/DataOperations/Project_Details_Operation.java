/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperations;

import DataObjects.Candidate_Profile_Object;
import DataObjects.Project_Details_Object;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shivam Patel
 */
public class Project_Details_Operation 
{
    Connection con=null;
    String url="jdbc:mysql://localhost:3306/placementapp";
    String un="root";
    String pass="8128";
    
    ResultSet rs=null;
    
    PreparedStatement pstmt;
    
    Scanner sc = new Scanner(System.in);

    public Project_Details_Operation() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            con=DriverManager.getConnection(url,un,pass);
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Project_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Project_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Project_Details_Object> allpids() throws SQLException
    {
        ArrayList<Project_Details_Object> pidlist = new ArrayList<Project_Details_Object>();
        String msg="";
        String sql="select * from project_details";
          pstmt=con.prepareStatement(sql);
              rs=pstmt.executeQuery();
             try
             {
              while(rs.next())
              {
                  Project_Details_Object pdo=new Project_Details_Object();
                  
                  int i=rs.getInt("Project_ID");
                  pdo.setProject_ID(i);
                  String s=rs.getString("Candidate_ID");
                  pdo.setCandidate_ID(s);
                  s=rs.getString("Title");
                  pdo.setTitle(s);
                  s=rs.getString("Functionality");
                  pdo.setFunctionality(s);
                  s=rs.getString("Grade");
                  pdo.setGrade(s);
                  s=rs.getString("Year");
                  pdo.setYear(s);
                  
                  pidlist.add(pdo);
              }
              
             }
             catch (SQLException ex) {
            Logger.getLogger(Candidate_Profile_Operation.class.getName()).log(Level.SEVERE, null, ex);
             }
             return pidlist;
    }
    
    public String InsertProjectDetails(Project_Details_Object pdo)
    {
        System.out.println(pdo);
        String msg="";
        
        String sql="insert into project_details values(?,?,?,?,?,?)";
        System.out.println(sql);
        System.out.println("---------------------------"+pdo.getProject_ID());
        try
        {
            pstmt=con.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println("---"+pdo.getProject_ID()+"----"); 
            pstmt.setInt(1,pdo.getProject_ID());
            System.out.println(pdo.getProject_ID());
            pstmt.setString(2,pdo.getCandidate_ID());
           // System.out.println(pdo.getCollegename());
            pstmt.setString(3,pdo.getTitle());
            pstmt.setString(4,pdo.getFunctionality());
            pstmt.setString(5,pdo.getGrade());
            pstmt.setString(6,pdo.getYear());
            
            System.out.println("-----------");
            pstmt.executeUpdate();
            System.out.println("-----------");
            
            msg="Succusessfully Inserted";
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Candidate_Profile_Operation.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return msg;
    }
    
    public String DeleteProjectDetails(Project_Details_Object pdo)
    {
        String msg="";
        
        String sql="delete from project_details where Project_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,pdo.getProject_ID());
            pstmt.executeUpdate();
            
            System.out.println("Successfully Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Project_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
    public ArrayList<Project_Details_Object> allcanids(Project_Details_Object pdob) throws SQLException
    {
      ArrayList<Project_Details_Object> candidlist=new ArrayList<Project_Details_Object>();
      String msg="";
     // Candidate_Profile_Object pdob=new Candidate_Profile_Object();
        String sql="select * from project_profile where Project_ID=? ";
          pstmt=con.prepareStatement(sql);
          pstmt.setInt(1,pdob.getProject_ID());
              rs=pstmt.executeQuery();
        
        try {
            while(rs.next())
            {
             Project_Details_Object pdo=new Project_Details_Object();
            
                int i=rs.getInt("Project_ID");
                pdo.setProject_ID(i);
              
                String s=rs.getString("Candidate_ID");
                pdo.setCandidate_ID(s);
             
                s=rs.getString("Title");
                pdo.setTitle(s);
              
                s=rs.getString("Functionality");
                pdo.setFunctionality(s);
             
                s=rs.getString("Grade");
                pdo.setGrade(s);
             
                s=rs.getString("Year");
                pdo.setYear(s);
                
                
                System.out.println("----dndnd----");        
                candidlist.add(pdo);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Candidate_Profile_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      return candidlist;
    }
}
