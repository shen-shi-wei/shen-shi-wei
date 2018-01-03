import userDao.UserDao;
import domain.User;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        UserDao user  = new UserDao();
        List<User> users = user.queryAll();
        System.out.println(users);
    }
}
