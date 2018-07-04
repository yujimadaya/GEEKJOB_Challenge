<%-- 
    Document   : Souko_touroku
    Created on : 2018/07/03, 16:43:19
    Author     : yamadayuushi
--%>

<!--
在庫の登録・変更・削除を行う為のページ
登録を行う場合は、入力された内容がSouko_touroku2.jspで処理される。
変更を行う場合は、入力された内容がSouko_henkou.jspで処理される。
削除を行う場合は、入力された内容がSouko_sakujyo.jspで処理される。
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫登録page</title>
    </head>
    <body>
    <center><h1>登録</h1></center>
    <center><form action="./Souko_touroku2.jsp" method="get">
            ID
            <br><input type="text" name="id" size="4">
            <br>
            <br>商品名
            <br><input type="text" name="name">
            <br>
            <br>個数
            <br><input type="text" name="kosu" size="4">
            <br>
            <br>
            <input type="submit" name="btnSubmit" value="登録する">
            <br>
            <br></form>
            <br>
    <center><h1>変更</h1></center>
    <center><form action="./Souko_henkou.jsp" method="get">
            ID
            <br><input type="text" name="id" size="4">
            <br>
            <br>商品名
            <br><input type="text" name="name">
            <br>
            <br>個数
            <br><input type="text" name="kosu" size="4">
            <br>
            <br>
            <input type="submit" name="btnSubmit" value="変更する">
            <br>
            <br></form>
            <br>
            <center><h1>削除</h1></center>
            <center><form action="./Souko_sakujyo.jsp" method="get">
            ID
            <br><input type="text" name="id" size="4">
            <br>    
            <br>
            <input type="submit" name="btnSubmit" value="削除する">
            <br>
            <br></form></center>
            </form>
    <br><center><form action="./Souko_loginpage.jsp" method="get">
        <input type="submit" name="btnSubmit" value="戻る"> 
        </form></center>
    </body>
</html>
