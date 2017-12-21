package utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Method {
    private QueryRunner runner = null;

    public Method() {
        runner = new methodQueryRunner();
    }

    //增
    public void add(User user) throws SQLException{

        String sql = "insert into hw_user(uname,age,loc) values(?,?,?)";
        runner.update(
                JdbcUtil.getConnection()
                ,sql
                ,user.getUname()
                ,user.getAge()
                ,user.getLoc()
        );
    }

    //删
    public void delete(String uname) throws SQLException{
        String sql = "delete from hw_user where uname = ? ";
        runner.update(
                JdbcUtil.getConnection()
                ,sql
                ,uname
        );
    }

    //该
    public void update(User user) throws SQLException {
        String sql ="update hw_user set uname=?,age=?,loc=? where uid=?";
        runner.update(
                JdbcUtil.getConnection()
                ,sql
                ,user.getUname()
                ,user.getAge()
                ,user.getLoc()
                ,user.getUid()
        );
    }

    //查询一个对象
    public User queryById(String id) throws SQLException {
        String sql = "select * from hw_user where uid=?";
        User user = runner.query(
                JdbcUtil.getConnection()
                , sql
                , new BeanHandler<User>(User.class)
                , id
        );
        return user;
    }

    //查询所有对象
    public List<User> queryall() throws SQLException {
        String sql = "select * from hw_user";
        List<User> users = runner.query(
                JdbcUtil.getConnection()
                , sql
                , new BeanListHandler<User>(User.class)
        );
        return users;
    }

}
