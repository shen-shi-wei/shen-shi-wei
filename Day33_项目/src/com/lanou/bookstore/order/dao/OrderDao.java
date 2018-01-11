package com.lanou.bookstore.order.dao;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.domain.Cartltem;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderBook;
import com.lanou.bookstore.order.domain.Orderltem;
import com.lanou.bookstore.user.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    QueryRunner queryRunner = new QueryRunner();
    public void addOrder(Order order) throws SQLException {
        String sql = "insert into orders values(?,?,?,?,?,?)";
        queryRunner.update(
                C3P0Util.getConnection()
                ,sql,order.getOid()
                ,order.getOrdertime()
                ,order.getPrice()
                ,order.getState()
                ,order.getUid()
                ,order.getAddress());
    }

    public void addOrderItemList(Orderltem orderltem) throws SQLException {
        String sql = "insert into orderitem values(?,?,?,?,?)";
        queryRunner.update(
                C3P0Util.getConnection()
                ,sql
                ,orderltem.getIid()
                ,orderltem.getCount()
                ,orderltem.getSubtotal()
                ,orderltem.getOid()
                ,orderltem.getBid()
        );

    }

    public List<Order> queryByUid(String uid) throws SQLException {
        String sql = "select * from orders WHERE uid = ?";
        List<Order> orders = queryRunner.query(
                C3P0Util.getConnection()
                , sql
                , new BeanListHandler<Order>(Order.class)
                , uid
        );
        return orders;
    }

//    public List<Orderltem> queryOrderByOid(String oid) throws SQLException {
//        String sql = "select * from orderitem where oid=?";
//        List<Orderltem> orderltems = queryRunner.query(
//                C3P0Util.getConnection()
//                , sql
//                , new BeanListHandler<Orderltem>(Orderltem.class)
//                , oid
//        );
//        return orderltems;
//    }

    public List<OrderBook> queryAll() throws SQLException {
        String sql = "SELECT b.*,COUNT,o2.oid FROM book b INNER JOIN orderitem o1 on b.bid = o1.bid INNER JOIN orders o2 ON o2.oid = o1.oid";

        List<OrderBook> orderBooks = queryRunner.query(
                C3P0Util.getConnection()
                , sql
                , new BeanListHandler<OrderBook>(OrderBook.class)
        );
        return orderBooks;
    }

    public Order queryOrderByOid(String oid) throws SQLException {
        String sql = "select * from orders where oid = ?";
        Order order = queryRunner.query(
                C3P0Util.getConnection()
                , sql
                , new BeanHandler<Order>(Order.class)
                ,oid
        );
        return order;
    }


    public List<Orderltem> queryOrderltemByOid(String oid) throws SQLException {
        String sql = "select * from orderitem where oid = ?";
        List<Orderltem> orderltemList = queryRunner.query(
                C3P0Util.getConnection()
                , sql
                , new BeanListHandler<Orderltem>(Orderltem.class)
                ,oid
        );
        return orderltemList;
    }


    public void update(String oid) throws SQLException {
        String sql = "update orders set state = 3 where oid = ?";
        queryRunner.update(
                C3P0Util.getConnection()
                ,sql
                ,oid
        );
    }













}
