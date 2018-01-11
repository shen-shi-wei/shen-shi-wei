package com.lanou.bookstore.user.service;

import com.lanou.bookstore.user.dao.UserDao;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.service.exception.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Pattern;

public class UserService {
    UserDao userDao = new UserDao();
    public String register(User formU) throws SQLException, EmailExitException, UserExitException, IsNotEmailException {

        if (userDao.queryByEmail(formU.getEmail()) !=null){
            throw new EmailExitException();
        }
        if (userDao.queryByUsername(formU.getUsername())!=null){
            throw new UserExitException();
        }
        boolean isEmail;
        if (!(isEmail= Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",formU.getEmail()))){

            throw new IsNotEmailException();
        }
        userDao.insert(formU);
        return "success";
    }


    public User login(User fromU) throws SQLException, InvalidUsernameException, PasswordNotMatchException, NotActiveException {

        User fromDb = userDao.queryByUsername(fromU.getUsername());

        if (fromDb !=null){
            if (fromDb.getState() !=1){
                throw new NotActiveException();
            }else {
                if (fromDb.getPassword().equals(fromU.getPassword())) {
                    return fromDb;
                } else {
                    throw new PasswordNotMatchException();

                }
            }

        }

            throw new InvalidUsernameException();
    }



    public MimeMessage sendMail(String to, String code) throws MessagingException {
        String sendAddr = "1342359901@qq.com";//这是发送方的邮箱
        String pass = "llqgbqgpyfnvidab";

        Properties prop = new Properties();
        //设置服务器主机名
        prop.setProperty("mail.smtp.host", "smtp.qq.com");
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.port", "465");
        prop.setProperty("mail.smtp.ssl.enable", "true");
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendAddr, pass);
            }
        };

        Session session = Session.getInstance(prop, auth);

        MimeMessage msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(sendAddr));

        msg.setRecipients(Message.RecipientType.TO, to);


        msg.setSubject("激活邮件");

        String url="http://localhost:8080/userServlet?code=" + code + "&method=active";
        System.out.println(url);



        msg.setContent("<h1>此邮件为官方激活邮件！请点击下面链接完成激活操作！</h1><h3><a href='http://localhost:8080/userServlet?method=active&code=" + code + "'>点此激活</a>" +
                "或者访问:</h3>"+url+" ", "text/html;charset=UTF-8");

        Transport.send(msg);

        return msg;

}


    /**
     * 激活用户
     * @param code 用户激活码
     * @return 是否激活成功
//     */
    public int active(String code) throws SQLException, UserActivatedException, NotActiveException {
        System.out.println("进入act");
        UserDao userDao=new UserDao();
        User userByCode = userDao.findUserByCode(code);
        String username=userByCode.getUsername();
        int state = userByCode.getState();

        if (state == 1){
            throw new UserActivatedException();
        }

        if(username!=null && username!=""){
            //如果存在用户，将此用户状态设为可用
            userDao.setState(username);

            return 1;
        }else{
            throw new NotActiveException();

        }
    }


}
