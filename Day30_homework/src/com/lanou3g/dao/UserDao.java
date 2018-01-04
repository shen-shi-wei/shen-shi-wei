package com.lanou3g.dao;

import com.lanou3g.domain.User;
import com.lanou3g.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private QueryRunner qr = new QueryRunner();
   public List<User> find() throws SQLException {
       String sql = "select * from user";
       Connection conn = null;
       conn = JdbcUtil.getConnection();
       try {
           List<User> users = qr.query(conn, sql, new BeanListHandler<User>(User.class));
           return users;
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           conn.close();
       }
       return null;
   }

   public int inserts(User user) throws SQLException {
       String sql = "insert into user values(null,?,?)";
       Connection conn = JdbcUtil.getConnection();
       try {
           int i = qr.update(conn, sql, user.getUsername(), user.getPassword());
           return i;
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           conn.close();
       }
       return 0;
   }
    public User findByName(String username) throws SQLException {
        String sql = "select * from user where username=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            User user = qr.query(conn, sql, new BeanHandler<User>(User.class),username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }
}
