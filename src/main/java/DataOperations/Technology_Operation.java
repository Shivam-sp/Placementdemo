
package DataOperations;

import DataObjects.Project_Details_Object;
import DataObjects.Technologies_Object;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Technology_Operation
{
     Connection con=null;
    String url="jdbc:mysql://localhost:3306/placementapp";
    String un="root";
    String pass="8128";
    
    ResultSet rs=null;
    
    PreparedStatement pstmt;
    
    Scanner sc = new Scanner(System.in);

    public Technology_Operation()
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
    
     public ArrayList<Technologies_Object> alltids() throws SQLException
    {
        ArrayList<Technologies_Object> tidlist = new ArrayList<Technologies_Object>();
        String msg="";
        String sql="select * from technology";
          pstmt=con.prepareStatement(sql);
              rs=pstmt.executeQuery();
             try
             {
              while(rs.next())
              {
                  Technologies_Object tob=new Technologies_Object();
                  
                  int i=rs.getInt("Tid");
                  tob.setTid(i);
                  String s=rs.getString("Techname");
                  tob.setTechname(s);
                  s=rs.getString("Techtype");
                  tob.setTechtype(s);
                  
                  tidlist.add(tob);
              }
              
             }
             catch (SQLException ex) {
            Logger.getLogger(Candidate_Profile_Operation.class.getName()).log(Level.SEVERE, null, ex);
             }
             return tidlist;
    }
    
    public String InsertTechnology(Technologies_Object tob)
    {
        System.out.println(tob);
        String msg="";
        
        String sql="insert into technology values(?,?,?)";
        System.out.println(sql);
        System.out.println("---------------------------"+tob.getTid());
        try
        {
            pstmt=con.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println("---"+tob.getTid()); 
            pstmt.setInt(1,tob.getTid());
            System.out.println(tob.getTid());
            pstmt.setString(2,tob.getTechname());
            pstmt.setString(3,tob.getTechtype());
            
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
    
    public String DeleteTechnologyDetails(Technologies_Object tob)
    {
        String msg="";
        
        String sql="delete from candidate_profile where Candidate_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,tob.getTid());
            pstmt.executeUpdate();
            
            System.out.println("Successfully Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Candidate_Profile_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
//    public String UpdateCandidateDetails(Candidate_Profile_Object tob)
//    {
//        
//    }
    
    public String RetriveTechnologyDetails(int id)
    {
        String msg="";
        Technologies_Object tob=new Technologies_Object();
        tob.setTid(id);
        String sql="select * from candidate_profile where Candidate_ID=?";
        
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,tob.getTid());
            
            ArrayList<Technologies_Object> data=new ArrayList<Technologies_Object>();
            
            rs=pstmt.executeQuery();
            
            while(rs.next())
            {
                int i=rs.getInt("Tid");
                tob.setTid(i);
                System.out.println(i);
               String s=rs.getString("Techname");
                tob.setTechname(s);
                System.out.println(s);
                s=rs.getString("Techtype");
                tob.setTechtype(s);
                System.out.println(s);
                System.out.println("----dndnd----");
                 
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return msg;
    }
}
