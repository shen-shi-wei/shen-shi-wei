package com.lanou.bookstore.cart.web;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.domain.Cartltem;
import com.lanou.bookstore.user.util.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet",urlPatterns = "/car")
public class CartServlet extends BaseServlet{

    //先获得登录时创建的购物车也就是List<Cartltem>
    public String addCartltem(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, SQLException {
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        int bid = Integer.parseInt(request.getParameter("bid"));
        BookDao bookDao = new BookDao();
        Book book1 = bookDao.findByBid(bid);
        int count = Integer.parseInt(request.getParameter("count"));
        Cartltem cartltem = new Cartltem(book1,count);
        cart.add(cartltem);
        session.setAttribute("cart", cart);

        return "f:jsps/cart/list.jsp";

    }

    //先获得登录时创建的购物车也就是List<Cartltem>
    //当点击清空购物车时，用clear方法清空购物车
    //然后重定向到jsps/cart/list.jsp
    public String clear(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        cart.clear();
        return "f:jsps/cart/list.jsp";
    }

    public String delete(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        int bid = Integer.parseInt(request.getParameter("bid"));
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        List<Cartltem> a = new ArrayList<>();
        for (Cartltem cartltem : cart) {
            if (cartltem.getBook().getBid()==bid){
                a.add(cartltem);
            }
        }
        cart.removeAll(a);
//        for (int i = 0; i < cart.size(); i++) {
//            if (cart.get(i).getBook().getBid()==bid){
//                cart.remove(cart.get(i));
//            }
//        }
        session.setAttribute("cart",cart);
        return "f:/jsps/cart/list.jsp";
    }



}
