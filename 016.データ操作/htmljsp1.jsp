<%-- 
    Document   : htmljsp1
    Created on : 2018/06/26, 10:45:27
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>自己紹介 Page</title>
    </head>
    <body>
        <%
        // 受け取るパラメータの文字コード
        request.setCharacterEncoding("UTF-8");
        // テキストボックスの情報→名前を入力させるフォーム
        out.print("お名前" + "<br>");
        out.print(request.getParameter("onamae"));
        out.print("<br>");
        out.print("<br>");
        // ラジオボタンの情報→性別を選ばせるフォーム
        out.print("性別" + "<br>");
        out.print(request.getParameter("danjyo"));
        out.print("<br>");
        out.print("<br>");
        // テキストエリアの情報→趣味嗜好を書かせるフォーム
        out.print("趣味" + "<br>");
        out.print(request.getParameter("gosyumi"));
        out.print("<br>");
        out.print("<br>");
        %>
    </body>
</html>



