
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Configuration {
      private static Connection mySQLClient = null;

    private final static String JDBC_URL = "jdbc:mysql://cloud24db.c7gagicme5q9.ap-southeast-2.rds.amazonaws.com:3306/Cloud24";
    private final static String DB_USER = "cloud24b";
    private final static String DB_PASSWORD = "cloud24";
   

    protected Configuration() {
    };

    public static Connection getDBConnection() throws Exception {
        if (!isConnectionValid(mySQLClient)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            mySQLClient = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        }
        return mySQLClient;
    }

    public static boolean isConnectionValid(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                // Running a simple validation query
                connection.prepareStatement("SELECT 1");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
