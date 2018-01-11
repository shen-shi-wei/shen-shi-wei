package com.lanou.bookstore.book.dao;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.user.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
  private QueryRunner queryRunner = new QueryRunner();
  public List<Book> finAll() throws SQLException {
      Connection conn = C3P0Util.getConnection();
      String sql="select * from book";
      List<Book> bookList = queryRunner.query(conn, sql, new BeanListHandler<Book>(Book.class));
      C3P0Util.release(null,null,conn);
      return bookList;
  }

  public List<Book> findByCategory(int cid) throws SQLException {
      Connection conn = C3P0Util.getConnection();
      String sql = "select * from book where cid=?";
      List<Book> bookList = queryRunner.query(conn, sql, new BeanListHandler<Book>(Book.class), cid);
      C3P0Util.release(null,null,conn);
    return bookList;
  }

  public Book findByBid(int bid) throws SQLException {
      Connection conn = C3P0Util.getConnection();
      String sql="select * from book where bid=?";
      Book book = queryRunner.query(conn, sql, new BeanHandler<Book>(Book.class), bid);
      C3P0Util.release(null,null,conn);
      return book;

  }





}
