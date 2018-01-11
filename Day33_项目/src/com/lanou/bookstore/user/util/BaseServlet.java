package com.lanou.bookstore.user.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");
        Class<? extends BaseServlet> aClass = this.getClass();
        Method method1=null;
        try {
             method1 = aClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
           throw new RuntimeException("没找到"+method+"方法");
        }

        try {

            String path = (String) method1.invoke(this, req, resp);

            String[] split = path.split(":");
            if(split[0].equals("f")){
                resp.sendRedirect(req.getContextPath()+split[1]);
            }
            if (split[0].equals("r")){
                req.getRequestDispatcher(split[1]).forward(req,resp);
            }


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
