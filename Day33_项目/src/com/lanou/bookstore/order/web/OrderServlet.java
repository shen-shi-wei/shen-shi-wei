package com.lanou.bookstore.order.web;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.domain.Cartltem;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderBook;
import com.lanou.bookstore.order.domain.Orderltem;
import com.lanou.bookstore.order.service.OrderService;
import com.lanou.bookstore.order.service.exception.OrderException;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderService();
    private Orderltem orderltem = new Orderltem();
    private BookDao bookDao = new BookDao();
    private Order order = new Order();
    public String add(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        HttpSession session = request.getSession();
        String oid = UUID.randomUUID().toString().replace("-", "");
        order.setOid(oid);//oid
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = sdf.format(new Date());
        order.setOrdertime(format);//ordertime
        double money = (double) session.getAttribute("money");
        order.setPrice(money);//price
        User user = (User) session.getAttribute("user");
        order.setUid(user.getUid());//uid
        orderService.add(order);//把订单插入到orders
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        orderltem.setOid(order.getOid());
        List<Cartltem> cartltemList = new ArrayList<>();
        for (int i = 0; i < cart.size() ; i++) {
            String iid = UUID.randomUUID().toString().replace("-", "");
            orderltem.setIid(iid);
            Cartltem cartltem = cart.get(i);
            int bid = cartltem.getBook().getBid();
            int count = cartltem.getCount();
            //小计
            double subtotal = cartltem.getBook().getPrice() * count;
            orderltem.setCount(count);
            orderltem.setSubtotal(subtotal);
            orderltem.setBid(bid);
            orderService.addOrderItem(orderltem);
            cartltemList.add(cartltem);
        }
        cart.clear();
        request.setAttribute("order",order);
        request.setAttribute("cartltemList",cartltemList);
        return "r:jsps/order/desc.jsp";
    }

    public String myOrders(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String uid = user.getUid();
        List<Order> orders = orderService.queryByUid(uid);
        request.setAttribute("orders",orders);
        List<OrderBook> orderBooks = orderService.queryBy();
        request.setAttribute("orderBooks",orderBooks);
//        OrderBook ob = new OrderBook();
//        List<OrderBook> orderBook = new ArrayList<>();
//        for (int i = 0; i < orders.size(); i++) {
//            List<Orderltem> orderltems = orderService.queryOrderByOid(orders.get(i).getOid());
//            List<Cartltem> cart = new ArrayList<>();
//            for (int j = 0; j < orderltems.size(); j++) {
//                Book book = bookDao.findByBid(orderltems.get(j).getBid());
//                int count = orderltems.get(j).getCount();
//                Cartltem cartltem = new Cartltem();
//                cartltem.setCount(count);
//                cartltem.setBook(book);
//                cart.add(cartltem);
//            }
//            ob.setCartltemList(cart);
//            ob.setOid(orders.get(i).getOid());
//            ob.setOrdertime(orders.get(i).getOrdertime());
//            ob.setPrice(orders.get(i).getPrice());
//            orderBook.add(ob);
//        }
        return "r:jsps/order/list.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String oid = request.getParameter("oid");
        System.out.println(oid);
        Order order = orderService.queryByOid(oid);
        request.setAttribute("order",order);
        List<Cartltem> cartltemList = new ArrayList<>();
        List<Orderltem> orderltems = orderService.queryOrderltem(oid);
        for (int i = 0; i < orderltems.size(); i++) {
            Book book = bookDao.findByBid(orderltems.get(i).getBid());
            Cartltem cartltem = new Cartltem();
            cartltem.setCount(orderltems.get(i).getCount());
            cartltem.setBook(book);
            cartltemList.add(cartltem);
        }
        request.setAttribute("cartltemList",cartltemList);
        return "r:/jsps/order/desc.jsp";
    }

    public String confirm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String oid = request.getParameter("oid");
        int state =Integer.parseInt(request.getParameter("state")) ;
        try {
            orderService.confirm(oid,state);
        } catch (OrderException e) {
            e.getMessage();
        }
        return "f:msg.jsp";
    }

    public String isSure(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String oid = request.getParameter("oid");
        orderService.isSure(oid);
        return "f:index.jsp";
    }
}
