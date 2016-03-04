/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Department;
import model.Employee;

/**
 *
 * @author admin
 */
public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public int createDepartment(Department aDepartment) {
        return 0;
    }

    @Override
    public ArrayList findAll() {

        ArrayList aProfileCollection = null;
        return aProfileCollection;

    }

    private static Department loadDeptEmployeesFromDB(String query) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/DeptEmp";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        ArrayList anEmployeeCollection = new ArrayList();
        Department aDepartment = null;
        Employee anEmployee = null;
        try {

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to query, retrieve the rows one by one (by going to the
            // columns), and formulate the result string to send back to the client.
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String name, lastName, firstName, gender;
            Date hireDate;
            int deptNo, signingBonus, empNo;
            double salary;
            while (rs.next()) {
                deptNo = rs.getInt("dept_no");
                name = rs.getString("name");
                lastName = rs.getString("last_name");
                firstName = rs.getString("first_name");
                gender = rs.getString("gender");
                empNo = rs.getInt("emp_no");
                signingBonus = rs.getInt("signing_bonus");
                salary = rs.getDouble("salary");
                hireDate = rs.getDate("hire_date");

                // make a DepartmentOld object out of the values
                aDepartment = new Department(deptNo, name, null);
                // make a DepartmentOld object out of the values
                anEmployee = new Employee(empNo, lastName, firstName, salary, signingBonus, gender, hireDate);
                // add the newly created object to the collection
                anEmployeeCollection.add(anEmployee);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        aDepartment.setEmployees(anEmployeeCollection);
        return aDepartment;
    }

    @Override
    public Department findByNo(int deptNo) {

        // if interested in matching wild cards, use: LIKE and '%" + deptNo + "%'";
        String query = "SELECT * FROM DeptEmp.Department d, DeptEmp.Employee e "
                + "WHERE d.dept_no = e.dept_no and d.dept_no = " + deptNo;

        Department aDepartment = loadDeptEmployeesFromDB(query);


        return aDepartment;
    }
}
