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
            String myDB = "jdbc:derby://localhost:1527/Profile";
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
                    + aProfile.getClientName().replace("'", "&sbquo;")
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
    public ArrayList findAll() {

        String query = "SELECT * FROM Profile.Users";
        ArrayList aProfileCollection = selectProfilesFromDB(query);
        return aProfileCollection;

    }

    private ArrayList selectProfilesFromDB(String query) {
        ArrayList aProfileBeanCollection = new ArrayList();
        Connection DBConn = null;
        try {
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            // if doing the above in Oracle: DBHelper.loadDriver("oracle.jdbc.driver.OracleDriver");
            String myDB = "jdbc:derby://localhost:1527/Profile";
            // if doing the above in Oracle:  String myDB = "jdbc:oracle:thin:@oracle.itk.ilstu.edu:1521:ora478";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to query, retrieve the rows one by one (by going to the
            // columns), and formulate the result string to send back to the client.
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String name, gender, pos, industries, interests;
            ProfileBean aProfileBean;
            while (rs.next()) {
                // 1. if a float (say PRICE) is to be retrieved, use rs.getFloat("PRICE");
                // 2. Instead of using column name, can alternatively use: rs.getString(1); // not 0
                name = rs.getString("ClientName");
                gender = rs.getString("Gender");
                pos = rs.getString("Position");
                industries = rs.getString("Industries");
                interests = rs.getString("Interests");

                String tempInd[] = {industries}; // <-- what's wrong with this?
                String tempInt[] = {interests}; // <-- what's wrong with this?

                // make a ProfileBean object out of the values
                aProfileBean = new ProfileBean(name, gender, pos, tempInd, tempInt);
                // add the newly created object to the collection
                aProfileBeanCollection.add(aProfileBean);
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
        return aProfileBeanCollection;
    }

    @Override
    public ArrayList findByName(String aName) {
        // if interested in matching wild cards, use: LIKE and '%" + aName + "%'";
        String query = "SELECT * FROM Profile.Users ";
        query += "WHERE clientName = '" + aName + "'";

        ArrayList aProfileCollection = selectProfilesFromDB(query);
        return aProfileCollection;
    }
}
