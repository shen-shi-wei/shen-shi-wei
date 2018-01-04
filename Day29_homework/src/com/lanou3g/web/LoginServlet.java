package com.lanou3g.web;

import com.lanou3g.dao.UserDao;
import com.lanou3g.daomain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userDao.findByName(username);
//            System.out.println(user);
            if(user!=null&&user.getPassword().equals(password)){
                getServletContext().setAttribute("user",user);
                response.sendRedirect("http://localhost:8080/index.jsp");
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.html");
                dispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
