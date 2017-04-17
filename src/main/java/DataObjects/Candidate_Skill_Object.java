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
public class Candidate_Skill_Object 
{
  private int Tid;
  private String Candidate_ID;

    public Candidate_Skill_Object() {
    }

    public String getCandidate_ID() {
        return Candidate_ID;
    }

    public void setCandidate_ID(String Candidate_ID) {
        this.Candidate_ID = Candidate_ID;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int Tid) {
        this.Tid = Tid;
    }

    @Override
    public String toString() {
        return "Candidate_Skill{" + "Candidate_ID=" + Candidate_ID + ", Tid=" + Tid + '}';
    }
  
  
}
