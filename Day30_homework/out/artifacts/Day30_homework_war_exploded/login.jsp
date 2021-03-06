<%@ page import="com.lanou3g.domain.User" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <style type="text/css">
        *{
            margin:0;
            padding: 0;
        }
        body{
            width: 100%;
            height: 100%;
            /*background-color: aqua;*/
        }
        .top{
            height: 10%;
            width: 100%;
            /*background-color: red;*/
        }
        .top-center{
            position: relative;
            left: 45%;
            top: -20px;
        }
        .top img{
            position: relative;
            top: 30px;
        }
        .top ul{
            list-style: none;
            float: right;
            position: relative;
            top: -40px;
        }
        .top ul li{
            float: left;
            font-size: 22px;
            padding-right: 15px;
        }
        .bottom{
            height: 90%;
            width: 100%;
            float: right;
            background-color: wheat;
        }
        .bottom img{
            position: relative;
            left: 200px;
            top:200px;
        }
        .box{
            width: 460px;
            height: 600px;
            background-color: azure;
            position: relative;
            left: 55%;
            top:-300px;
        }
        .box h1{
            text-align: center;
            padding-top: 30px;
        }
        .box form input{
            width: 380px;
            height: 50px;
            margin-top: 50px;
            position: relative;
            left: 30px;
            font-size: 25px;
        }
        .box form input#s1{
            margin-top: 120px;
        }
        /*.box form input#s{*/
            /*width: 10px;*/
            /*height: 10px;*/
        /*}*/
        .box form span{
            /*position: relative;*/
            margin-left: 30px;
        }
        .box form span#t{
            visibility: hidden;
            font-size: 18px;
            color: red;
        }
        .box form span#t1{
            visibility: hidden;
            font-size: 18px;
            color: red;
        }
        .box form span#s2{
            margin-left: 160px;
        }
    </style>
</head>
<body onload="showLeftTime()">
    <div class="top">
        <img src="../img/4.png">
        <div class="top-center"  >
            <label id="show">显示时间的位置</label>
        </div>

        <ul>
            <li>网易云首页</li>
            <li>|</li>
            <li>帮助文档</li>
        </ul>
    </div>
    <div class="bottom">
        <img src="../img/5.png">
        <div class="box">
            <h1>网易云登录</h1>
            <form action="login" method="post">
                <input type="text" name="username" placeholder="网易云账号/网易云邮箱账号" <%
                if(application.getAttribute("username") != null){
                %>
                        value="${username}"
                <%
                    }
                %> onfocus="inputFocus(this)" onblur="inputBlur(this)"><span id="t">请输入您的邮箱</span><br/>
                <input type="password" name="password" placeholder="登录密码" onfocus="inputFocus(this)" onblur="inputBlur(this)"><span id="t1">字符不能是单一</span>
                <!--<input type="checkbox" id="s">-->
                <!--<label>同意并遵守 <a href="#">《服务条款》</a> </label>-->
                <input type="submit" value="登   录" id="s1" onclick="submit()"><br/>
                <span>还没有账号?<a href="register.jsp">免费注册</a></span>
                <span id="s2"><a href="#">忘记密码</a></span>
            </form>
        </div>
    </div>
</body>
<script language="javascript" type="text/javascript">
    function inputFocus(ele) {
        ele.style.fontSize = "25px";
        ele.style.border = "solid red";
    }
    function inputBlur(ele) {
        ele.style.fontSize = "20px";
        ele.style.border = "solid orange";
    }

    //获得当前时间,刻度为一千分一秒
    var initializationTime=(new Date()).getTime();
    function showLeftTime()
    {
        var now=new Date();
        var year=now.getFullYear();
        var month=now.getMonth();
        var day=now.getDate();
        var hours=now.getHours();
        var minutes=now.getMinutes();
        var seconds=now.getSeconds();
        document.all.show.innerHTML=""+year+"年"+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds+"";
//一秒刷新一次显示时间
        var timeID=setTimeout(showLeftTime,1000);
    }

    //    function hints1(ele) {
//        var t1 = document.getElementById("t");
//        t1.style.visibility="hidden";
//    }
//    function hints2(ele) {
//        var t1 = document.getElementById("t");
//        t1.style.visibility="visible";
//    }
//    function hint1(ele) {
//        var t1 = document.getElementById("t1");
//        t1.style.visibility="hidden";
//    }
//    function hint2(ele) {
//        var t1 = document.getElementById("t1");
//        t1.style.visibility="visible";
//    }
</script>
</html>