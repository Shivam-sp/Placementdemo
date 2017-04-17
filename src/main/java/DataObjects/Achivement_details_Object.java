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
public class Achivement_details_Object 
{
  private String Candidate_ID;
  private String Achivementdetails;
  private String MonthYear;

    public Achivement_details_Object() {
    }

    public String getCandidate_ID() {
        return Candidate_ID;
    }

    public void setCandidate_ID(String Candidate_ID) {
        this.Candidate_ID = Candidate_ID;
    }

    public String getAchivementdetails() {
        return Achivementdetails;
    }

    public void setAchivementdetails(String Achivementdetails) {
        this.Achivementdetails = Achivementdetails;
    }

    public String getMonthYear() {
        return MonthYear;
    }

    public void setMonthYear(String MonthYear) {
        this.MonthYear = MonthYear;
    }

    @Override
    public String toString() {
        return "Achivement_details_Object{" + "Candidate_ID=" + Candidate_ID + ", Achivementdetails=" + Achivementdetails + ", MonthYear=" + MonthYear + '}';
    }
  
  
}
