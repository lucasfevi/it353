/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dao.DepartmentDAOImpl;

/**
 *
 * @author BillyLim
 */
@ManagedBean(name = "Department")
@SessionScoped
public class Department {

    /** Creates a new instance of Department */
    private int deptNo;
    private String name;
    private ArrayList employees;
    private long maximum = 9999; // for validation
    private long minimum = 1000;  // for validation

    public Department() {
    }

    public Department(int deptNo, String name, ArrayList employees) {
        this.deptNo = deptNo;
        this.name = name;
        this.employees = employees;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getEmployees() {
        if (employees == null) {
            Department aDept = (new DepartmentDAOImpl()).findByNo(deptNo);
            this.name = aDept.name;
            this.employees = aDept.employees;
        }
        return employees;
    }

    public void setEmployees(ArrayList employees) {
        this.employees = employees;
    }

    public long getMaximum() {
        return maximum;
    }

    public void setMaximum(long maximum) {
        this.maximum = maximum;
    }

    public long getMinimum() {
        return minimum;
    }

    public void setMinimum(long minimum) {
        this.minimum = minimum;
    }
}
