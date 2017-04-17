
package DataObjects;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shivam Patel
 */
public class Candidate_Profile_Object 
{
 private String Candidate_ID;
 private String Firstname,Middlename,Lastname;
 private String Gender;
 //@Format(formats = "dd-MM-yyyy") //notice that multiple formats are supported
 public Date DOB;
 private double Contact_No,Alternative_No;
 private String Email,Address,City;
 private double Pincode;
 private String Image,Password;

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Candidate_Profile_Object() {
    }

    public String getCandidate_ID() {
        return Candidate_ID;
    }

    public void setCandidate_ID(String Candidate_ID) {
        this.Candidate_ID = Candidate_ID;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getMiddlename() {
        return Middlename;
    }

    public void setMiddlename(String Middlename) {
        this.Middlename = Middlename;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }


   

    public double getContact_No() {
        return Contact_No;
    }

    public void setContact_No(double Contact_No) {
        this.Contact_No = Contact_No;
    }

    public double getAlternative_No() {
        return Alternative_No;
    }

    public void setAlternative_No(double Alternative_No) {
        this.Alternative_No = Alternative_No;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public double getPincode() {
        return Pincode;
    }

    public void setPincode(double Pincode) {
        this.Pincode = Pincode;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Candidate_Profile_Object{" + "Candidate_ID=" + Candidate_ID + ", Firstname=" + Firstname + ", Middlename=" + Middlename + ", Lastname=" + Lastname + ", Gender=" + Gender + ", DOB=" + DOB + ", Contact_No=" + Contact_No + ", Alternative_No=" + Alternative_No + ", Email=" + Email + ", Address=" + Address + ", City=" + City + ", Pincode=" + Pincode + ", Image=" + Image + ", Password=" + Password + '}';
    }
 
    
 
}
