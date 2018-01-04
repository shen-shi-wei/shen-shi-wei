package com.lanou3g.dao;


import com.lanou3g.daomain.Book;
import com.lanou3g.daomain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new QueryRunner();
    public List<Book> queryall() throws SQLException {
        String sql = "select * from book";
        List<Book> books = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<Book>(Book.class));
        return books;
    }


}
