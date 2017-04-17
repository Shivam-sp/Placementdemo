/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperations;

import DataObjects.Achivement_details_Object;
import DataObjects.Candidate_Feedback_Object;
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
public class Candidate_Feedback_Operation 
{
     Connection con=null;
    String url="jdbc:mysql://localhost:3306/placementapp";
    String un="root";
    String pass="8128";
    
    ResultSet rs=null;
    
    PreparedStatement pstmt;
    
    Scanner sc = new Scanner(System.in);

    public Candidate_Feedback_Operation() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            con=DriverManager.getConnection(url,un,pass);
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Candidate_Feedback_Operation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Candidate_Feedback_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String InsertCandidateFeedback(Candidate_Feedback_Object cfo)
    {
        System.out.println(cfo);
        String msg="";
        
        String sql="insert into candidate_feedback values(?,?,?)";
        System.out.println(sql);
        System.out.println("---------------------------"+cfo.getCandidate_ID());
        try
        {
            pstmt=con.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println("---"+cfo.getCandidate_ID()+"----"); 
            pstmt.setString(1,cfo.getCandidate_ID());
            System.out.println(cfo.getCandidate_ID());
            pstmt.setInt(2,cfo.getCid());
            pstmt.setString(3,cfo.getPerformance());
      
            System.out.println("-----------");
            pstmt.executeUpdate();
            System.out.println("-----------");
            
            msg="Succusessfully Inserted";
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Candidate_Feedback_Operation.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return msg;
    }      
    
    public String DeleteCandidateFeedBack(Candidate_Feedback_Object cfo)
    {
        String msg="";
        
        String sql="delete from candidate_feedback where Candidate_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,cfo.getCandidate_ID());
            pstmt.executeUpdate();
            
            System.out.println("Successfully Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Candidate_Feedback_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
}
