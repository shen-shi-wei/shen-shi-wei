<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2017/12/28
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <button id="btn">点我</button>
  <table border="1"></table>
  <a href="insert.html">点我添加</a>
  </body>
  <script type="text/javascript">
      $('#btn').click(function () {
          $('table>tr').remove();
          $.get("http://localhost:8080/home",function (data,status) {
              if (status=="success"){
                  var jsonData = $.parseJSON(data);
                  if (jsonData!= null){
                      $('table').append(
                          $('<tr>').append(
                              $('<td>').text("uid")
                          ).append(
                              $('<td>').text("uname")
                          ).append(
                              $('<td>').text("age")
                          ).append(
                              $('<td>').text("loc")
                          )
                      )
                      $.each(jsonData,function (index,obj) {
                          $('table').append(
                              $('<tr>').append(
                                  $('<td>').text(obj['uid'])
                              ).append(
                                  $('<td>').text(obj['uname'])
                              ).append(
                                  $('<td>').text(obj['age'])
                              ).append(
                                  $('<td>').text(obj['loc'])
                              )
                          )
                      })
                  }
              }
          })
      })

  </script>
</html>
