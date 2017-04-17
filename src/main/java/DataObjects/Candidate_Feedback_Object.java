/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObjects;

/**
 *
 * @author Shivam Patel
 */
public class Candidate_Feedback_Object 
{
  private int Cid;
  private String Candidate_ID,Performance;

    public Candidate_Feedback_Object() {
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

    public String getPerformance() {
        return Performance;
    }

    public void setPerformance(String Performance) {
        this.Performance = Performance;
    }

    @Override
    public String toString() {
        return "Candidate_Feedback_Object{" + "Candidate_ID=" + Candidate_ID + ", Cid=" + Cid + ", Performance=" + Performance + '}';
    }
  
  
}
