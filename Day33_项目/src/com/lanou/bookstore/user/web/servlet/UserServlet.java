package com.lanou.bookstore.user.web.servlet;

import com.lanou.bookstore.cart.domain.Cartltem;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.service.UserService;
import com.lanou.bookstore.user.service.exception.*;
import com.lanou.bookstore.user.util.BaseServlet;


import javax.mail.MessagingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "UserServlet",urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet {
    UserService userService = new UserService();

    public String regist(HttpServletRequest request, HttpServletResponse response) {
        Boolean result = false;
        String code = UUID.randomUUID().toString().replace("-", "");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User(username, password, email);
        user.setCode(code);
        String error = null;

        try {
            String register = userService.register(user);
            System.out.println("1111");
//            MimeMessage msg =
            userService.sendMail(email, code);
            if (user.getState() != 1) {
                request.setAttribute("msg", "未激活");

            } else {
                request.setAttribute("msg", "已激活");

            }

            return "r:/jsps/msg.jsp";

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (EmailExitException e) {
            error = e.getMessage();
        } catch (UserExitException e) {
            error = e.getMessage();
        } catch (IsNotEmailException e) {
            error = e.getMessage();
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
            request.setAttribute("error", error);
        }
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        return "r:/jsps/user/regist.jsp";
    }


    public String active(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        String code = request.getParameter("code");
        int active = 0;
        try {
            active = userService.active(code);
        } catch (UserActivatedException e) {
            request.setAttribute("error", e.getMessage());
        } catch (NotActiveException e) {
            request.setAttribute("error", e.getMessage());
        }
        if (active != 1) {
            request.setAttribute("msg", "未激活");

        } else {
            request.setAttribute("msg", "已激活");

        }
        return "r:/jsps/msg.jsp";

    }


    public String login(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        try {
            User fromDb = userService.login(user);
            HttpSession session = request.getSession();
            session.setAttribute("user",fromDb);
            //定义了一个cart购物车里面放的都是Cartltem对象
            //也就是说Cartltem对象的集合看成了一个购物车
            List<Cartltem> cart = new ArrayList<>();
            session.setAttribute("cart",cart);
            return "f:/index.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidUsernameException e) {
           request.setAttribute("msg",e.getMessage());
        } catch (PasswordNotMatchException e) {
            request.setAttribute("msg",e.getMessage());
        } catch (NotActiveException e) {
            request.setAttribute("msg",e.getMessage());
        }
        return "r:/jsps/user/login.jsp";
    }

    public  String quit(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "f:/jsps/user/login.jsp";

    }



}