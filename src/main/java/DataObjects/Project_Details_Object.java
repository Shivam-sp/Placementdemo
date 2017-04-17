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
public class Project_Details_Object 
{
  private int Project_ID;
  private String Title,Functionality,Grade,Candidate_ID,year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Project_Details_Object() {
    }

    public int getProject_ID() {
        return Project_ID;
    }

    public void setProject_ID(int Project_ID) {
        this.Project_ID = Project_ID;
    }

    public String getCandidate_ID() {
        return Candidate_ID;
    }

    public void setCandidate_ID(String Candidate_ID) {
        this.Candidate_ID = Candidate_ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getFunctionality() {
        return Functionality;
    }

    public void setFunctionality(String Functionality) {
        this.Functionality = Functionality;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    @Override
    public String toString() {
        return "Project_Details_Object{" + "Project_ID=" + Project_ID + ", Title=" + Title + ", Functionality=" + Functionality + ", Grade=" + Grade + ", Candidate_ID=" + Candidate_ID + ", year=" + year + '}';
    }
  
  
}
