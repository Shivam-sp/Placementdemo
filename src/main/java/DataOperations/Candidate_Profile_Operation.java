/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperations;

import DataObjects.Candidate_Profile_Object;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shivam Patel
 */
public class Candidate_Profile_Operation 
{
    Connection con=null;
    String url="jdbc:mysql://localhost:3306/placementapp";
    String un="root";
    String pass="8128";
    ResultSet rs=null;
    
    PreparedStatement pstmt;
    Statement stmt;
    Scanner sc = new Scanner(System.in);

    public Candidate_Profile_Operation()
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
    
    public ArrayList<Candidate_Profile_Object> allids() throws SQLException
    {
      ArrayList<Candidate_Profile_Object> idlist=new ArrayList<Candidate_Profile_Object>();
      String msg="";
     // Candidate_Profile_Object cpob=new Candidate_Profile_Object();
        String sql="select * from candidate_profile";
          stmt=con.createStatement();
              rs=stmt.executeQuery(sql);
        
        try {
            while(rs.next())
            {
              Candidate_Profile_Object cpo=new Candidate_Profile_Object();
            
              
                String s=rs.getString("Candidate_ID");
                cpo.setCandidate_ID(s);
             
                s=rs.getString("Firstname");
                cpo.setFirstname(s);
                
                s=rs.getString("Middlename");
                cpo.setMiddlename(s);
              
                s=rs.getString("Lastname");
                cpo.setLastname(s);
                
                s=rs.getString("Gender");
                cpo.setGender(s);
             
                Date d=rs.getDate("DOB");
                cpo.setDOB(d);
              
                double db=rs.getDouble("Contact_No");
                cpo.setContact_No(db);
            
                db=rs.getDouble("Alternative_No");
                cpo.setAlternative_No(db);
    
                s=rs.getString("Email");
                cpo.setEmail(s);
      
                s=rs.getString("Address");
                cpo.setAddress(s);
              
                db=rs.getDouble("Pincode");
                cpo.setPincode(db);
           
                s=rs.getString("City");
     
                cpo.setCity(s);
         
                s=rs.getString("Image");
                cpo.setImage(s);
      
                s=rs.getString("Password");
                cpo.setPassword(s);
                
                
                System.out.println("----dndnd----");        
                idlist.add(cpo);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Candidate_Profile_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      return idlist;
    }
    
    
    public String InsertCandidateDetails(Candidate_Profile_Object cpo)
    {
        System.out.println(cpo);
        String msg="";
        
        String sql="insert into candidate_profile values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println(sql);
        System.out.println("---------------------------"+cpo.getCandidate_ID());
        try
        {
            pstmt=con.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println("---"+cpo.getCandidate_ID()); 
            pstmt.setString(1,cpo.getCandidate_ID());
            System.out.println(cpo.getCandidate_ID());
            pstmt.setString(2,cpo.getFirstname());
            System.out.println(cpo.getFirstname());
            pstmt.setString(3,cpo.getMiddlename());
            pstmt.setString(4,cpo.getLastname());
            pstmt.setString(5,cpo.getGender());
            java.util.Date jud=cpo.getDOB();
            java.sql.Date jsd=new java.sql.Date(jud.getTime());
            pstmt.setDate(6,jsd);
            pstmt.setDouble(7,cpo.getContact_No());
            pstmt.setDouble(8,cpo.getAlternative_No());
            pstmt.setString(9,cpo.getEmail());
            pstmt.setString(10,cpo.getAddress());
            pstmt.setDouble(11,cpo.getPincode());
            pstmt.setString(12,cpo.getCity());
            pstmt.setString(13,cpo.getImage());
            pstmt.setString(14,cpo.getPassword());
            
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
    
    public String DeleteCandidateDetails(Candidate_Profile_Object cpo)
    {
        String msg="";
        
        String sql="delete from candidate_profile where Candidate_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,cpo.getCandidate_ID());
            pstmt.executeUpdate();
            
            System.out.println("Successfully Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Candidate_Profile_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
//    public String UpdateCandidateDetails(Candidate_Profile_Object cpo)
//    {
//        
//    }
    
    public ArrayList<Candidate_Profile_Object> RetriveCandidateDetails(Candidate_Profile_Object cpo)
    {
        String msg="";
        cpo=new Candidate_Profile_Object();
        cpo.setCandidate_ID(cpo.getCandidate_ID());
        String sql="select * from candidate_profile where Candidate_ID=?";
        ArrayList<Candidate_Profile_Object> data=new ArrayList<Candidate_Profile_Object>();
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,cpo.getCandidate_ID());
            rs=pstmt.executeQuery();
            
            while(rs.next())
            {
                Candidate_Profile_Object cpob=new Candidate_Profile_Object();
            
              
                String s=rs.getString("Candidate_ID");
                cpob.setCandidate_ID(s);
             
                s=rs.getString("Firstname");
                cpob.setFirstname(s);
        
                s=rs.getString("Middlename");
                cpob.setMiddlename(s);
              
                s=rs.getString("Lastname");
                cpob.setFirstname(s);
             
                s=rs.getString("Gender");
                cpob.setGender(s);
             
                Date d=rs.getDate("DOB");
                cpob.setDOB(d);
              
                double db=rs.getDouble("Contact_No");
                cpob.setContact_No(db);
            
                db=rs.getDouble("Alternative_No");
                cpob.setAlternative_No(db);
    
                s=rs.getString("Email");
                cpob.setEmail(s);
      
                s=rs.getString("Address");
                cpob.setAddress(s);
              
                db=rs.getDouble("Pincode");
                cpob.setPincode(db);
           
                s=rs.getString("City");
     
                cpob.setCity(s);
         
                s=rs.getString("Image");
                cpob.setImage(s);
      
                s=rs.getString("Password");
                cpob.setPassword(s);
                
                
                System.out.println("----dndnd----");        
                data.add(cpob);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Candidate_Profile_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      return data;
    }
}