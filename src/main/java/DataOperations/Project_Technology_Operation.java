/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperations;

import DataObjects.Candidate_Profile_Object;
import DataObjects.Project_Details_Object;
import DataObjects.Project_Technology_Object;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shivam Patel
 */
public class Project_Technology_Operation 
{
    Connection con=null;
    String url="jdbc:mysql://localhost:3306/placementapp";
    String un="root";
    String pass="8128";
    
    ResultSet rs=null;
    
    PreparedStatement pstmt;
    
    Scanner sc = new Scanner(System.in);

    public Project_Technology_Operation() 
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
    
    public String InsertProjectDetails(Project_Technology_Object pto)
    {
        System.out.println(pto);
        String msg="";
        
        String sql="insert into projecttechnology values(?,?)";
        System.out.println(sql);
        System.out.println("---------------------------"+pto.getProject_ID());
        try
        {
            pstmt=con.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println("---"+pto.getProject_ID()+"----"); 
            pstmt.setInt(1,pto.getProject_ID());
            System.out.println(pto.getProject_ID());
            pstmt.setInt(2,pto.getTid());
           // System.out.println(pto.getCollegename());
            
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

   public String DeleteProjectTechnology(Project_Technology_Object pto)
    {
        String msg="";
        
        String sql="delete from projecttechnology where Candidate_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,pto.getProject_ID());
            pstmt.executeUpdate();
            
            System.out.println("Successfully Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Project_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }    
}
