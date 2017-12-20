package bean;

import bean.ExecuteInter;
import org.junit.Test;
import utils.JdbcUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class userDataMysql {

    //增
    public void add(String nickname,String username,String password) throws SQLException {

        JdbcUtil.execute(conn -> {
                PreparedStatement pstate = conn.prepareStatement(
                        "INSERT INTO user VALUES (NULL ,"+nickname+","+username+","+password+")");
             pstate.execute();
            return pstate;

        });
    }

    //删
    public void delete(String username) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasehomework"
                , "root"
                , "123"
        );
        String sql = "DELETE FROM user WHERE username = ?";
        connection.setAutoCommit(false);
        PreparedStatement pstate = connection.prepareStatement(
                "DELETE FROM user WHERE username =?"
        );
        pstate.setString(1,username);
        pstate.execute();

        pstate.close();
        connection.close();
    }



    //改
    public void update(String nickname,String username,String password) throws ClassNotFoundException, IOException, SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasehomework"
                , "root"
                , "123"
        );
        String sql = "DELETE FROM user WHERE username = ?";
        connection.setAutoCommit(false);
        PreparedStatement pstate = connection.prepareStatement(
                "UPDATE user SET nickname = ? AND username = ?AND password = ?"
        );
        pstate.setString(1,nickname);
        pstate.setString(2,username);
        pstate.setString(3,password);
        pstate.execute();

        pstate.close();
        connection.close();
    }


    //查
    public ResultSet select() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasehomework"
                , "root"
                , "123"
        );
        String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        statement.close();
        connection.close();

        return resultSet;
    }
}
