package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/querymany?user=root&password=123");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
