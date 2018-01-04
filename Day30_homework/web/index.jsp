<%@ page import="com.lanou3g.dao.BookDao" %>
<%@ page import="com.lanou3g.domain.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lanou3g.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/3
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<table border="1">
  <tr>
    <th>用户名</th>
    <th>密码</th>
  </tr>
  <%
    User user = (User) session.getAttribute("user");
    if (user != null){
  %>
    <tr>
      <td><%=user.getUsername()%></td>
      <td><%=user.getPassword()%></td>
    </tr>
  <%
    }else {
    response.sendRedirect("exception.jsp");
    }
  %>


</table>

<table id="t1" border="1">
  <tr>

    <th>书名</th>

  </tr>
  <%
    BookDao bookDao = new BookDao();
    List<Book> books = bookDao.queryall();
    for (Book book : books) {
  %>
  <tr>
    <td><a href=""><%=
      book.getBname()
    %></a> </td>
  </tr>
  <%
    }
  %>
</table>

<a href="login.jsp"><%
  session.removeAttribute("user");
%>退出</a>
</body>
<script type="text/javascript">

</script>
</html>
