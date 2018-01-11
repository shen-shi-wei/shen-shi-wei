package com.lanou.bookstore.book.web.servlet;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.user.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet" ,urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private BookDao bookDao = new BookDao();
    //找到所有的书后请求转发到/jsps/book/list.jsp
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Book> books = bookDao.finAll();
        request.setAttribute("bookList",books);
        return "r:/jsps/book/list.jsp";
    }

    //根据种类编号在book表中可以获得该编号的所有书
    //请求转发到/jsps/book/list.jsp
    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Book> books = bookDao.findByCategory(cid);
        request.setAttribute("bookList",books);
        return "r:/jsps/book/list.jsp";
    }

    //根据传过来的bid（图书编号）找到这本书，并把这本书请求转发到/jsps/book/desc.jsp
    public String load(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int bid = Integer.parseInt(request.getParameter("bid"));
        Book book = bookDao.findByBid(bid);
        request.setAttribute("book",book);
        return "r:/jsps/book/desc.jsp";
    }
}
