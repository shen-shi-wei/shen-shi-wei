package com.lanou.bookstore.category.dao;

import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.user.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
  QueryRunner queryRunner = new QueryRunner();

   public List<Category> queryAll() throws SQLException {
       String sql="select * from category";
       Connection conn = C3P0Util.getConnection();
       List<Category> categoryList = queryRunner.query(conn, sql, new BeanListHandler<Category>(Category.class));
       C3P0Util.release(null,null,conn);
     return categoryList;
   }



}
