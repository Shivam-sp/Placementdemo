/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperations;

import DataObjects.Candidate_Profile_Object;
import DataObjects.Placement_Details_Object;
import DataObjects.Project_Details_Object;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shivam Patel
 */
public class Placement_Details_Operation 
{
    Connection con=null;
    String url="jdbc:mysql://localhost:3306/placementapp";
    String un="root";
    String pass="8128";
    
    ResultSet rs=null;
    
    PreparedStatement pstmt;
    
    Scanner sc = new Scanner(System.in);

    public Placement_Details_Operation() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            con=DriverManager.getConnection(url,un,pass);
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Placement_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Placement_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String InsertPlacementetails(Placement_Details_Object pdo)
    {
        System.out.println(pdo);
        String msg="";
        
        String sql="insert into placement_details values(?,?,?,?,?,?)";
        System.out.println(sql);
        System.out.println("---------------------------"+pdo.getCandidate_ID());
        try
        {
            pstmt=con.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println("---"+pdo.getCandidate_ID()+"----"); 
            pstmt.setString(1,pdo.getCandidate_ID());
            System.out.println(pdo.getCandidate_ID());
            pstmt.setInt(2,pdo.getCid());
           // System.out.println(pdo.getCollegename());
            pstmt.setString(3,pdo.getDesignation());
            pstmt.setString(4,pdo.getSalarydetails());
            pstmt.setString(5,pdo.getWorkprofile());
            pstmt.setString(6,pdo.getDoj());
            
            System.out.println("-----------");
            pstmt.executeUpdate();
            System.out.println("-----------");
            
            msg="Succusessfully Inserted";
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Placement_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return msg;
    }
    
    public String DeletePlacementDetails(Placement_Details_Object pcdo)
    {
        String msg="";
        
        String sql="delete from placement_details where Candidate_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,pcdo.getCandidate_ID());
            pstmt.executeUpdate();
            
            System.out.println("Successfully Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Placement_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
}
