/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperations;

import DataObjects.Achivement_details_Object;
import DataObjects.Candidate_Profile_Object;
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
public class Achievement_Operation 
{
    Connection con=null;
    String url="jdbc:mysql://localhost:3306/placementapp";
    String un="root";
    String pass="8128";
    
    ResultSet rs=null;
    
    PreparedStatement pstmt;
    
    Scanner sc = new Scanner(System.in);

    public Achievement_Operation() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            con=DriverManager.getConnection(url,un,pass);
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public String InsertAchievement(Achivement_details_Object ado)
    {
        System.out.println(ado);
        String msg="";
        
        String sql="insert into achievement values(?,?,?)";
        System.out.println(sql);
        System.out.println("---------------------------"+ado.getCandidate_ID());
        try
        {
            pstmt=con.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println("---"+ado.getCandidate_ID()+"----"); 
            pstmt.setString(1,ado.getCandidate_ID());
            System.out.println(ado.getCandidate_ID());
            pstmt.setString(2,ado.getAchivementdetails());
            pstmt.setString(3,ado.getMonthYear());
      
            System.out.println("-----------");
            pstmt.executeUpdate();
            System.out.println("-----------");
            
            msg="Succusessfully Inserted";
            pstmt.close();
            
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
        
        }
        return msg;
    }        
    
    public String DeleteAchievementDetails(Achivement_details_Object ado)
    {
        String msg="";
        
        String sql="delete from achievement where Candidate_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,ado.getCandidate_ID());
            pstmt.executeUpdate();
            
            System.out.println("Successfully Deleted");
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        return msg;
    }
}
