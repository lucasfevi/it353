/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import model.ProfileBean;

/**
 *
 * @author admin
 */
public class ProfileDAOImpl implements ProfileDAO {

    @Override
    public int createProfile(ProfileBean aProfile) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/profile";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String temp = "";
            String[] industries = aProfile.getIndustries();

            for (int i = 0; i < industries.length; i++) {
                temp += industries[i] + ";";
            }

            String temp2 = "";
            String[] interests = aProfile.getInterests();
            for (int i = 0; i < interests.length; i++) {
                temp2 += interests[i] + ";";
            }

            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO Profile.Users VALUES ('"
                    + aProfile.getClientName()
                    + "','" + aProfile.getGender()
                    + "','" + aProfile.getPosition()
                    + "','" + temp
                    + "','" + temp2
                    + "')";

            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

    @Override
    public ProfileBean[] findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProfileBean findByName(String aName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
