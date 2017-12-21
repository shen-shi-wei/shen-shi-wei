package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

    private static String url;
    private static String database;
    private static String user;
    private static String password;

    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src/db.properties"));
            String driverName = prop.getProperty("driverName");
            url = prop.getProperty("url");
            database = prop.getProperty("database");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(
                    e.getMessage()
                            +"\n\t\t"
                            +"请将配置文件jdbc.properties放置src目录下"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn= null;
        try {
            conn = DriverManager.getConnection(url + database, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
        return conn;
    }
}
