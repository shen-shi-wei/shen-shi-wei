<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    <base target="body"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			font-size:10pt;
			text-align: center;
		}
		div {
			background: #87CEFA; 
			margin: 3px; 
			padding: 3px;
		}
		a {
			text-decoration: none;
		}
	</style>
  </head>
  
  <body>
<div>
	<%--调用book下的findAll方法可以找到所有的书--%>
	<a href="<c:url value='/book?method=findAll'/>">全部分类</a>
</div>
	<%--
		根据session中的种类category（是一个集合）
		可以循环遍历出是哪几种种类的名字（cate.cname）
		同时可以根据种类来获得cid（种类编号）
		最后调用book下的findByCategory方法
	--%>
<c:if test="${sessionScope.category !=null}">
	<c:forEach items="${sessionScope.category}" var="cate">
		<div>
		<a href="<c:url value='/book?method=findByCategory&cid=${cate.cid}'/>">${cate.cname}</a>
		</div>
	</c:forEach>
</c:if>


<%--<div>--%>
	<%--<a href="<c:url value='/jsps/book/list.jsp'/>">JavaSE分类</a>--%>
<%--</div>--%>
<%--<div>--%>
	<%--<a href="<c:url value='/jsps/book/list.jsp'/>">JavaEE分类</a>--%>
<%--</div>--%>
<%--<div>--%>
	<%--<a href="<c:url value='/jsps/book/list.jsp'/>">Javascript分类</a>--%>
<%--</div>--%>
  </body>
</html>
