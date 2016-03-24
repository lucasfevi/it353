package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import model.UserBean;

/**
 * @author ldacruz
 */
public class UserDAO {

    public boolean createUser(UserBean theModel) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/Project353";
            try (Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student")) {
                Statement stmt = DBConn.createStatement();
                String insertString;
                insertString = "INSERT INTO Project353.Users (first_name,"
                    + "last_name, email, password, sec_question, sec_answer)"
                    + " VALUES ('"
                    + theModel.getFirstName() + "','"
                    + theModel.getLastName() + "','"
                    + theModel.getEmail() + "','"
                    + theModel.getPassword() + "','"
                    + theModel.getSecQuestion() + "','"
                    + theModel.getSecAnswer() + "')";
                
                rowCount = stmt.executeUpdate(insertString);
                System.out.println("SQL INSERT = " + insertString);            
                DBConn.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return rowCount == 1;
    }
}
