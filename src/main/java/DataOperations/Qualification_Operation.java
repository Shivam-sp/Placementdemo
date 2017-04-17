/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperations;

import DataObjects.Candidate_Profile_Object;
import DataObjects.Qualification_Object;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shivam Patel
 */
public class Qualification_Operation 
{
    Connection con=null;
    String url="jdbc:mysql://localhost:3306/placementapp";
    String un="root";
    String pass="8128";
    
    ResultSet rs=null;
    
    PreparedStatement pstmt;
    Statement stmt;
    
    Scanner sc = new Scanner(System.in);

    public Qualification_Operation() {
        try {
            //jdbc two lines load driver and connetion
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            con=DriverManager.getConnection(url,un,pass);
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Qualification_Operation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Qualification_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String InsertQualificationDetails(Qualification_Object qob)
    {
        System.out.println(qob);
        String msg="";
        
        String sql="insert into qualification values(?,?,?,?,?,?)";
        System.out.println(sql);
        System.out.println("---------------------------"+qob.getCandidate_ID());
        try
        {
            pstmt=con.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println("---"+qob.getCandidate_ID()+"----"); 
            pstmt.setString(1,qob.getCandidate_ID());
            System.out.println(qob.getCandidate_ID());
            pstmt.setString(2,qob.getDegree());
           // System.out.println(qob.getCollegename());
            pstmt.setString(3,qob.getCollegename());
            pstmt.setString(4,qob.getYearofpassing());
            pstmt.setString(5,qob.getGrade());
            pstmt.setFloat(6,qob.getPercentage());
            
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
    
    public String DeleteQualificationDetails(Qualification_Object qob)
    {
        String msg="";
        
        String sql="delete from qualification where Candidate_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,qob.getCandidate_ID());
            pstmt.executeUpdate();
            
            System.out.println("Successfully Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Candidate_Profile_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
     public ArrayList<Qualification_Object> allqua() throws SQLException
    {
      ArrayList<Qualification_Object> qualist=new ArrayList<Qualification_Object>();
      String msg="";
     // Candidate_Profile_Object cpob=new Candidate_Profile_Object();
        String sql="select * from qualification";
          stmt=con.createStatement();
              rs=stmt.executeQuery(sql);
        
        try {
            while(rs.next())
            {
              Qualification_Object qo=new Qualification_Object();
            
              
                String s=rs.getString("Candidate_ID");
                qo.setCandidate_ID(s);
             
                s=rs.getString("Degree");
                qo.setDegree(s);
                
                s=rs.getString("Collagename");
                qo.setCollegename(s);
              
                s=rs.getString("Yearofpassing");
                qo.setYearofpassing(s);
                
                Float d=rs.getFloat("Percent");
                qo.setPercentage(d);
     
                
                
                System.out.println("----dndnd----");        
                qualist.add(qo);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Qualification_Object.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      return qualist;
    }
    
}
