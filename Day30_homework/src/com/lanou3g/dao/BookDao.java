package com.lanou3g.dao;


import com.lanou3g.domain.Book;
import com.lanou3g.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new QueryRunner();
    public List<Book> queryall()  {
        String sql = "select * from book";
        List<Book> books = null;
        try {
            books = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


}
