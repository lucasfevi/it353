/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDAOImpl;
import dao.DepartmentDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Department;

/**
 *
 * @author admin
 */
@ManagedBean
@SessionScoped
public class DeptEmpController {

    // This corresponds to the response to be sent back to the client
    private String response;
    private Department department;

    /**
     * Creates a new instance of DeptEmpController
     */
    public DeptEmpController() {
        department = new Department();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

//    public String createProfile() {
//        DepartmentDAO aProfileDAO = new DepartmentDAOImpl();    // Creating a new object each time.
//        int rowCount = aProfileDAO.createProfile(theModel); // Doing anything with the object after this?
//        if (rowCount == 1)
//            return "response.xhtml"; // navigate to "response.xhtml"
//        else
//            return "error.xhml"; 
//    }
}
