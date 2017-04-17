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
public class Project_Technology_Object 
{
    private int Project_ID,Tid;

    public Project_Technology_Object() {
    }

    public int getProject_ID() {
        return Project_ID;
    }

    public void setProject_ID(int Project_ID) {
        this.Project_ID = Project_ID;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int Tid) {
        this.Tid = Tid;
    }

    @Override
    public String toString() {
        return "Project_Technology_Object{" + "Project_ID=" + Project_ID + ", Tid=" + Tid + '}';
    }
    
    
}
