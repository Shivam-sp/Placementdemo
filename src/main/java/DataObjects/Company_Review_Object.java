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
public class Company_Review_Object
{
  private int Cid;
  private String Environment,Facility,Candidate_ID;
  private float Salary;

    public Company_Review_Object() {
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int Cid) {
        this.Cid = Cid;
    }

    public String getCandidate_ID() {
        return Candidate_ID;
    }

    public void setCandidate_ID(String Candidate_ID) {
        this.Candidate_ID = Candidate_ID;
    }

    public String getEnvironment() {
        return Environment;
    }

    public void setEnvironment(String Environment) {
        this.Environment = Environment;
    }

    public String getFacility() {
        return Facility;
    }

    public void setFacility(String Facility) {
        this.Facility = Facility;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return "Company_Review_Object{" + "Cid=" + Cid + ", Candidate_ID=" + Candidate_ID + ", Environment=" + Environment + ", Facility=" + Facility + ", Salary=" + Salary + '}';
    }
  
  
}
