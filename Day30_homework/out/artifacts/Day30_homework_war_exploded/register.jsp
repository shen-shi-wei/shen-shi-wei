<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
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
        .buttom{
            height: 888px;
            width: 100%;
            background-color: aliceblue;
        }
        .buttom-center{
            height: 750px;
            width: 80%;
            background-color: azure;
            position: relative;
            top:138px;
            left: 10%;
        }
        .buttom-center-mix{
            height: 650px;
            width: 780px;
            /*background-color: wheat;*/
            position: relative;
            left: 27%;
            top: 8%;
        }
        .buttom-center-mix h1{
            text-align: center;
            color: blueviolet;
        }
        .buttom-center-mix form label{
            font-size: 23px;
            position: relative;
            left: 20px;
        }
        .buttom-center-mix form label#i{
            position: relative;
            top: 20px;
        }
        .buttom-center-mix form label#i2{
            position: relative;
            top: 110px;
        }
        .buttom-center-mix form label#i3{
            position: relative;
            top: 285px;
            font-size: 16px;
            left: 110px;
        }
        .buttom-center-mix form input{
            position: relative;

        }
        .buttom-center-mix form input#t{
            position: relative;
            top: 20px;
            width: 500px;
            height: 50px;
            left: 25px;
            width: 500px;
            height: 50px;
            font-size: 25px;
        }
        .buttom-center-mix form input#t2{
            position: relative;
            top: 110px;
            left: 25px;
            width: 500px;
            height: 50px;
            font-size: 25px;
          }
        .buttom-center-mix form input#t3{
            position: relative;
            top: 330px;
            left: -95px;
            width: 500px;
            height: 50px;
            font-size: 25px;
            background-color: darkslateblue;

        }
        .buttom-center-mix form input#t4{
            position: relative;
            top: 290px;
            left: 110px;
            width: 18px;
            height: 18px;
        }
        .buttom-center-mix form span#d{
            visibility: hidden;
            font-size: 22px;
            color: red;
            position: relative;
            left: 30px;
            top:16px;
        }
        .buttom-center-mix form span#d1{
            visibility: hidden;
            font-size: 22px;
            color: red;
            position: relative;
            left: 30px;
            top:108px;
        }
    </style>
</head>
<body>
    <div class="top">
        <img src="../img/4.png">
    </div>
    <div class="buttom">
        <div class="buttom-center">
            <div class="buttom-center-mix">
                <h1>邮箱注册</h1>
                <form action="register" method="post">
                    <label id="i">邮箱地址</label>
                    <input type="text" id="t" name="username" placeholder="请输入邮箱地址" onfocus="hints2(this)" onblur="hints1(this)"><span id="d">请输入您的邮箱</span><br>
                    <label id="i2">登录密码</label>
                    <input type="password" id="t2" name="password" placeholder="请输入登录密码" onfocus="hint2(this)" onblur="hint1(this)"><span id="d1">字符不能是单一</span><br/>
                    <input type="checkbox" id="t4">
                    <label id="i3">同意并遵守《服务条款》</label>
                    <input type="submit"  id="t3" onclick="change(this)">
                </form>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    function hints1(ele) {
        var t1 = document.getElementById("d");
        t1.style.visibility="hidden";
    }
    function hints2(ele) {
        var t1 = document.getElementById("d");
        t1.style.visibility="visible";
    }
    function hint1(ele) {
        var t1 = document.getElementById("d1");
        t1.style.visibility="hidden";
    }
    function hint2(ele) {
        var t1 = document.getElementById("d1");
        t1.style.visibility="visible";
    }
    function change(ele) {
       var t3 = document.getElementById("t3");
       t3.style.background="red";
    }
</script>
</html>