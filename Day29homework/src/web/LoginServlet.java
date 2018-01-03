package web;

import domain.User;
import net.sf.json.JSONObject;
import userDao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        System.out.println("1");
        String age = request.getParameter("age");
        System.out.println("2");
        String loc = request.getParameter("loc");
        UserDao userDao = new UserDao();
        User user= new User();
        try {
            System.out.println("3");
             user= userDao.queryByName(uname);
            System.out.println(user.toString());
            if(uname.equals(user.getUname())
                    &&age.equals(user.getAge())
                    &&loc.equals(user.getLoc())){
                response.sendRedirect("http://localhost:8080/index.jsp");
                JSONObject jsonObject = JSONObject.fromObject(user);
                response.getWriter().write(jsonObject.toString());
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
                dispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
