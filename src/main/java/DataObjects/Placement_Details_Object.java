/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObjects;

import java.util.Date;

/**
 *
 * @author Shivam Patel
 */
public class Placement_Details_Object 
{
  private int Cid;
  private String Designation,Salarydetails,Workprofile,Doj,Candidate_ID;

    public Placement_Details_Object() {
    }

    public String getCandidate_ID() {
        return Candidate_ID;
    }

    public void setCandidate_ID(String Candidate_ID) {
        this.Candidate_ID = Candidate_ID;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int Cid) {
        this.Cid = Cid;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public String getSalarydetails() {
        return Salarydetails;
    }

    public void setSalarydetails(String Salarydetails) {
        this.Salarydetails = Salarydetails;
    }

    public String getWorkprofile() {
        return Workprofile;
    }

    public void setWorkprofile(String Workprofile) {
        this.Workprofile = Workprofile;
    }

    public String getDoj() {
        return Doj;
    }

    public void setDoj(String Doj) {
        this.Doj = Doj;
    }

    @Override
    public String toString() {
        return "Placement_Details_Object{" + "Candidate_ID=" + Candidate_ID + ", Cid=" + Cid + ", Designation=" + Designation + ", Salarydetails=" + Salarydetails + ", Workprofile=" + Workprofile + ", Doj=" + Doj + '}';
    }
  
  
}
