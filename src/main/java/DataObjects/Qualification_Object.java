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
public class Qualification_Object
{
  private String Candidate_ID;
  private String Degree,Collegename;
  private String Yearofpassing;
  private String Grade;
  private float Percentage;

    public Qualification_Object() {
    }

    public String getCandidate_ID() {
        return Candidate_ID;
    }

    public void setCandidate_ID(String Candidate_ID) {
        this.Candidate_ID = Candidate_ID;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String Degree) {
        this.Degree = Degree;
    }

    public String getCollegename() {
        return Collegename;
    }

    public void setCollegename(String Collegename) {
        this.Collegename = Collegename;
    }

    public String getYearofpassing() {
        return Yearofpassing;
    }

    public void setYearofpassing(String Yearofpassing) {
        this.Yearofpassing = Yearofpassing;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public float getPercentage() {
        return Percentage;
    }

    public void setPercentage(float Percentage) {
        this.Percentage = Percentage;
    }

    @Override
    public String toString() {
        return "Qualification_Object{" + "Candidate_ID=" + Candidate_ID + ", Degree=" + Degree + ", Collegename=" + Collegename + ", Yearofpassing=" + Yearofpassing + ", Grade=" + Grade + ", Percentage=" + Percentage + '}';
    }
  
  
}
