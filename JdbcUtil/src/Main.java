import Utils.Method;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Method method = new Method();
        //增
//        method.add(new Utils.User(null,"李四",30,"北京"));
        //改
//        method.update(new Utils.User("37","王五",30,"南京"));
        //查找所有
//        List<Utils.User> users = method.queryall();
//        System.out.println(users);
        //根据id查找
//        Utils.User user = method.queryById("37");
//        System.out.println(user);
        //删
        method.delete("王五");

    }
}
