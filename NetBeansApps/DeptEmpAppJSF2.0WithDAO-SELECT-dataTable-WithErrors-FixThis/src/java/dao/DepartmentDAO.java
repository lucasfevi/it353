/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Department;

/**
 *
 * @author admin
 */
public interface DepartmentDAO {
    
    public int createDepartment(Department aDepartment);
    public ArrayList findAll();
    public Department findByNo(int deptNo); 
    
}
