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
public class Company_Details_Object 
{
  private int Cid;
  private String Cname,Address,City,Email,Url,Briefprofile,Password,Verify;
  private double pincode,Contact_No,Alternative_No;

    public double getAlternative_No() {
        return Alternative_No;
    }

    public void setAlternative_No(double Alternative_No) {
        this.Alternative_No = Alternative_No;
    }
  private boolean verify;

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public Company_Details_Object() {
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int Cid) {
        this.Cid = Cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String Cname) {
        this.Cname = Cname;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getBriefprofile() {
        return Briefprofile;
    }

    public void setBriefprofile(String Briefprofile) {
        this.Briefprofile = Briefprofile;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getVerify() {
        return Verify;
    }

    public void setVerify(String Verify) {
        this.Verify = Verify;
    }

    public double getPincode() {
        return pincode;
    }

    public void setPincode(double pincode) {
        this.pincode = pincode;
    }

    public double getContact_No() {
        return Contact_No;
    }

    public void setContact_No(double Contact_No) {
        this.Contact_No = Contact_No;
    }

    @Override
    public String toString() {
        return "Company_Details_Object{" + "Cid=" + Cid + ", Cname=" + Cname + ", Address=" + Address + ", City=" + City + ", Email=" + Email + ", Url=" + Url + ", Briefprofile=" + Briefprofile + ", Password=" + Password + ", Verify=" + Verify + ", pincode=" + pincode + ", Contact_No=" + Contact_No + ", Alternative_No=" + Alternative_No + ", verify=" + verify + '}';
    }

    
  
}
