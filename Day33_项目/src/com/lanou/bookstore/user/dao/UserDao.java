package com.lanou.bookstore.user.dao;

import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private QueryRunner queryRunner = new QueryRunner();


    // 查找全部
    public List<User> queryBeanList() throws SQLException {
        Connection connection= C3P0Util.getConnection();
        String sql = "select * from user";
        List<User> users = queryRunner.query(connection, sql, new BeanListHandler<User>(User.class));
        C3P0Util.release(null,null,connection);
        return users;
    }

    // 通过名字查找
    public User queryByUsername(String username) throws SQLException {
        Connection connection= C3P0Util.getConnection();
        String sql = "select * from user where username = ?";
        User user = queryRunner.query(connection, sql, new BeanHandler<User>(User.class), username);
        C3P0Util.release(null,null,connection);
        return user;
    }

    // 通过邮箱查找
    public User queryByEmail(String email) throws SQLException {
        Connection connection= C3P0Util.getConnection();
        String sql = "select * from user where email = ?";
        User user = queryRunner.query(connection, sql, new BeanHandler<User>(User.class), email);
        C3P0Util.release(null,null,connection);
        return user;
    }

    // 添加
    public void insert(User user) throws SQLException {
        Connection connection= C3P0Util.getConnection();
       String sql = "insert into user values(?,?,?,?,?,?)";
        queryRunner.update(connection, sql, user.getCode(),user.getUsername(), user.getPassword(), user.getEmail(), user.getCode(), user.getState());
        C3P0Util.release(null,null,connection);

    }


    public User findUserByCode(String code) throws SQLException {

        Connection connection= C3P0Util.getConnection();
        String sql = "select * from user where code = ?";
        User user = queryRunner.query(connection, sql, new BeanHandler<User>(User.class), code);
        C3P0Util.release(null,null,connection);
        return user;

    }

    public void setState(String username) throws SQLException {

        Connection connection= C3P0Util.getConnection();
        String sql = "update user set state =1 where username=?";
        queryRunner.update(connection, sql,username);
        C3P0Util.release(null,null,connection);
    }



}
