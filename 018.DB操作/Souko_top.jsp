<%-- 
    Document   : Souko_top
    Created on : 2018/07/03, 14:15:52
    Author     : yamadayuushi
--%>
<!--    IDとPasswordを入力される画面
        入力された値はSouko_login.jspで合致しているかどうかを確認する。
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理 Top Page</title>
    </head>
    <body>
        <center><form action="./Souko_login.jsp" method="get">
            <br>ID
            <br><input type="text" name="id">
            <br>
            <br>PassWord
            <br><input type="text" name="pass">
            <br>
            <br>
            <input type="submit" name="btnSubmit" value="login">
        </form></center>
    </body>
</html>
