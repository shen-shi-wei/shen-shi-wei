package com.lanou.bookstore.category.web;

import com.lanou.bookstore.category.dao.CategoryDao;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.user.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {
    private CategoryDao categoryDao = new CategoryDao();
    //main.jap页面中调用这个方法，可以找到所有的种类
    //然后重定向到/jsps/left.jsp页面
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Category> categories = categoryDao.queryAll();
        HttpSession session = request.getSession();
        session.setAttribute("category",categories);
        return "f:/jsps/left.jsp";

    }


}
