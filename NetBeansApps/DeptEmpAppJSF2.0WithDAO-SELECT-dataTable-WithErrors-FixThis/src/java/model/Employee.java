/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;

/**
 *
 * @author BillyLim
 */
public class Employee {
    private int empNo;
    private String lastName;
    private String firstName;
    private double salary;
    private int signingBonus;
    private String gender;
    private Date hireDate;

    public Employee() {
    }

    public Employee(int empNo, String lastName, String firstName, double salary, int signingBonus, String gender, Date hireDate) {
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.signingBonus = signingBonus;
        this.gender = gender;
        this.hireDate = hireDate;
    }

//    public int getEmpNo() {
//        return empNo;
//    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSigningBonus() {
        return signingBonus;
    }

    public void setSigningBonus(int signingBonus) {
        this.signingBonus = signingBonus;
    }


}
