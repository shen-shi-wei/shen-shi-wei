package com.lanou.bookstore.order.service;

import com.lanou.bookstore.order.dao.OrderDao;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderBook;
import com.lanou.bookstore.order.domain.Orderltem;
import com.lanou.bookstore.order.service.exception.OrderException;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    public void add(Order order) throws SQLException {
        orderDao.addOrder(order);
    }
    public void addOrderItem(Orderltem orderltem) throws SQLException {
        orderDao.addOrderItemList(orderltem);
    }

    public List<Order> queryByUid(String uid) throws SQLException {
        List<Order> orders = orderDao.queryByUid(uid);
        return orders;
    }

    public List<OrderBook> queryBy() throws SQLException {
        List<OrderBook> orderBooks = orderDao.queryAll();
        return orderBooks;
    }

    public Order queryByOid(String oid) throws SQLException {
        Order order = orderDao.queryOrderByOid(oid);
        return order;
    }

    public List<Orderltem> queryOrderltem (String oid) throws SQLException {
        List<Orderltem> orderltems = orderDao.queryOrderltemByOid(oid);
        return orderltems;
    }

    public void confirm(String oid,int state) throws SQLException, OrderException {
        Order order = orderDao.queryOrderByOid(oid);
        if (order.getState()==3){
            return;
        }else {
            orderDao.update(oid);
            throw new OrderException();
        }
    }
    public void isSure(String oid) throws SQLException {
        orderDao.update(oid);
    }
}
