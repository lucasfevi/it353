package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ldacru
 */
public class DBHelper {
    public DBHelper() {}
    
    public static void loadDriver(String driverStr) {
        try {
            Class.forName(driverStr);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static Connection connect2DB(String connectStr, String userName, String password) {
        Connection DBConn = null;
        
        try {
            DBConn = DriverManager.getConnection(connectStr, userName, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return DBConn;
    }
}
