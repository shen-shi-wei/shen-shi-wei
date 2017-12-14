import Exception.registerexection.*;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class UserOperate {

    UserData userData = new UserData();
    UserData ud = new UserData();
    public static  final  String REGEX_MOBILE = "[1][38]\\d([-]{0,1})\\d{4}([-]{0,1})\\d{4}";
    public static  final  String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static  final  String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,14}$";
    public static  final  String REGEX_NICKNAME = "^[a-z]\\w{1,}$";
    public void register(String nickname,String username ,String password) throws IOException, RegisterException, DocumentException {
        if (!(Pattern.matches(REGEX_EMAIL,username) || Pattern.matches(REGEX_MOBILE,username))){

            throw new WrongNumberException();
        }
        if (!Pattern.matches(REGEX_PASSWORD,password)){
            throw new WrongPasswordException();
        }
        if (!Pattern.matches(REGEX_NICKNAME,nickname)){
            throw new NicknameException();
        }
        List<Users> users= userData.read();
        for (Users users1 :users) {
            if (users1.getUsername().equals(username)){
                throw new ExistException();
            }
        }
        ud.writeIn(nickname,username,password);
    }

    public Users login(String username ,String password) throws DocumentException {
        List<Users> users = userData.read();
        for (Users user :users) {
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
                System.out.println("登录成功");
                return user;
            }
        }
        return null;
    }
}
