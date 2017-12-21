package utils;

import Exception.registerexection.*;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class UserOperate {

    Method method= new Method();

    public static  final  String REGEX_MOBILE = "[1][38]\\d([-]{0,1})\\d{4}([-]{0,1})\\d{4}";
    public static  final  String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static  final  String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,14}$";
    public static  final  String REGEX_NICKNAME = "^[a-z]\\w{1,}$";
    public void register(String nickname,String username ,String password) throws IOException, RegisterException, DocumentException, SQLException {
        if (!(Pattern.matches(REGEX_EMAIL,username) || Pattern.matches(REGEX_MOBILE,username))){

            throw new WrongNumberException();
        }
        if (!Pattern.matches(REGEX_PASSWORD,password)){
            throw new WrongPasswordException();
        }
        if (!Pattern.matches(REGEX_NICKNAME,nickname)){
            throw new NicknameException();
        }
        List<User> users = method.queryall();
        for (User user : users) {
            if (user.getUname().equals(username)){
                throw new ExistException();
            }
        }
        method.add(nickname,username,password);
        System.out.println("注册成功");
    }

    public ResultSet login(String username ,String password) throws DocumentException, SQLException {
        ResultSet select = ud.select();
        while (select.next()){
            if (select.getString(3).equals(username)&&select.getString(4).equals(password)){
                System.out.println("登录成功");
                return select;
            }
        }
        return null;
    }
}
