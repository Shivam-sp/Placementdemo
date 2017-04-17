/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperations;

import DataObjects.Candidate_Profile_Object;
import DataObjects.Company_Review_Object;
import DataObjects.Placement_Details_Object;
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
public class Company_Review_Operation 
{
   Connection con=null;
    String url="jdbc:mysql://localhost:3306/placementapp";
    String un="root";
    String pass="8128";
    
    ResultSet rs=null;
    
    PreparedStatement pstmt;
    
    Scanner sc = new Scanner(System.in);

    public Company_Review_Operation() 
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
    
    
    public String InsertCompanyReview(Company_Review_Object cro)
    {
        System.out.println(cro);
        String msg="";
        
        String sql="insert into company_review values(?,?,?,?,?)";
        System.out.println(sql);
        System.out.println("---------------------------"+cro.getCid());
        try
        {
            pstmt=con.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println("---"+cro.getCid()+"----"); 
            pstmt.setInt(1,cro.getCid());
            System.out.println(cro.getCid());
            pstmt.setString(2,cro.getCandidate_ID());
           // System.out.println(cro.getCollegename());
            pstmt.setString(3,cro.getEnvironment());
            pstmt.setString(4,cro.getFacility());
            pstmt.setDouble(5,cro.getSalary());
            
            System.out.println("-----------");
            pstmt.executeUpdate();
            System.out.println("-----------");
            
            msg="Succusessfully Inserted";
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Company_Review_Operation.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return msg;
    }
    
    public String DeleteCompanyReview(Company_Review_Object cro)
    {
        String msg="";
        
        String sql="delete from company_review where Cid=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,cro.getCid());
            pstmt.executeUpdate();
            
            System.out.println("Successfully Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Company_Review_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
}
