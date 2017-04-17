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
public class Technologies_Object 
{
 private int Tid;
 private String Techname,Techtype;

    public Technologies_Object() {
    }
     
    public Technologies_Object(int Tid, String Techname, String Techtype) {
        this.Tid = Tid;
        this.Techname = Techname;
        this.Techtype = Techtype;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int Tid) {
        this.Tid = Tid;
    }

    public String getTechname() {
        return Techname;
    }

    public void setTechname(String Techname) {
        this.Techname = Techname;
    }

    public String getTechtype() {
        return Techtype;
    }

    public void setTechtype(String Techtype) {
        this.Techtype = Techtype;
    }

    @Override
    public String toString() {
        return "Technologies_Object{" + "Tid=" + Tid + ", Techname=" + Techname + ", Techtype=" + Techtype + '}';
    }
 
}
