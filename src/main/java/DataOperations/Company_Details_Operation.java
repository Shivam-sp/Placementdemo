/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperations;

import DataObjects.Candidate_Profile_Object;
import DataObjects.Company_Details_Object;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.sql.DriverManager.getConnection;

/**
 *
 * @author Shivam Patel
 */
public class Company_Details_Operation 
{
    Connection con=null;
    String url="jdbc:mysql://localhost:3306/placementapp";
    String un="root";
    String pass="8128";
    
    ResultSet rs=null;
    
    PreparedStatement pstmt;
    
    Scanner sc = new Scanner(System.in);

    double db;
    public Company_Details_Operation()
    {
        try
        {
         //jdbc two lines load driver and connetion
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
    
    public ArrayList<Company_Details_Object> allcids() throws SQLException
    {
      ArrayList<Company_Details_Object> cidlist=new ArrayList<Company_Details_Object>();
      String msg="";
     // Candidate_Profile_Object cdob=new Candidate_Profile_Object();
        String sql="select * from company_details";
          pstmt=con.prepareStatement(sql);
              rs=pstmt.executeQuery();
        
        try {
            while(rs.next())
            {
              Company_Details_Object cdo=new Company_Details_Object();
            
              
                int i=rs.getInt("Cid");
                cdo.setCid(i);
             
                String s=rs.getString("Cname");
                cdo.setCname(s);
                
                s=rs.getString("Address");
                cdo.setAddress(s);
                
                double db=rs.getDouble("Pincode");
                cdo.setPincode(db);
             
                s=rs.getString("City");
                cdo.setCity(s);
              
                db=rs.getDouble("Contact_No");
                cdo.setContact_No(db);
                
                s=rs.getString("Email");
                cdo.setEmail(s);
     
         
                s=rs.getString("Url");
                cdo.setUrl(s);
      
                s=rs.getString("Briefprofile");
                cdo.setUrl(s);
                
                s=rs.getString("Password");
                cdo.setPassword(s);
                
                System.out.println("----dndnd----");        
                cidlist.add(cdo);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Company_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      return cidlist;
    }
    
    public String InsertCompanyDetails(Company_Details_Object cdo)
    {
        System.out.println(cdo);
        String msg="";
        
        String sql="insert into company_details values(?,?,?,?,?,?,?,?,?,?)";
        System.out.println(sql);
        System.out.println("---------------------------"+cdo.getCid());
        try
        {
            pstmt=con.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println("---"+cdo.getCid()); 
            pstmt.setInt(1,cdo.getCid());
            System.out.println(cdo.getCid());
            pstmt.setString(2,cdo.getCname());
            System.out.println(cdo.getCname());
            pstmt.setString(3,cdo.getAddress());
            pstmt.setDouble(4,cdo.getPincode());
            pstmt.setString(5,cdo.getCity());
            pstmt.setDouble(6,cdo.getContact_No());
            pstmt.setString(7,cdo.getEmail());
            pstmt.setString(8,cdo.getUrl());
            pstmt.setString(9,cdo.getBriefprofile());
            pstmt.setString(10,cdo.getPassword());
            
            System.out.println("-----------");
            pstmt.executeUpdate();
            System.out.println("-----------");
            
            msg="Succusessfully Inserted";
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Company_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return msg;
    }
    
    public String DeleteCompanyDetails(Company_Details_Object cdo)
    {
        String msg="";
        
        String sql="delete from candidate_profile where Candidate_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,cdo.getCid());
            pstmt.executeUpdate();
            
            System.out.println("Successfully Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Company_Details_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
//    public String UpdateCandidateDetails(Candidate_Profile_Object cdo)
//    {
//        
//    }
    
    public String RetriveCompanyDetails(int id)
    {
        String msg="";
        Company_Details_Object cdo=new Company_Details_Object();
        cdo.setCid(id);
        String sql="select * from candidate_profile where Candidate_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,cdo.getCid());
            
            ArrayList<Company_Details_Object> data=new ArrayList<Company_Details_Object>();
            
            rs=pstmt.executeQuery();
            
            while(rs.next())
            {
                int i=rs.getInt("Cid");
                cdo.setCid(i);
                String s=rs.getString("Cname");
                cdo.setCname(s);
                s=rs.getString("Address");
                db=rs.getDouble("Pincode");
                cdo.setPincode(db);
                cdo.setAddress(s);
                s=rs.getString("City");
                cdo.setCity(s);
                db=rs.getDouble("Contact_No");
                cdo.setContact_No(db);
                s=rs.getString("Email");
                cdo.setEmail(s);
                s=rs.getString("Url");
                cdo.setUrl(s);
                s=rs.getString("Briefprofile");
                s=rs.getString("Password");
                cdo.setPassword(s);
                
                 data.add(cdo);
                 System.out.println(data.toString());
                 
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return msg;
    }
}