<%-- 
    Document   : login
    Created on : 2018/07/25, 15:25:05
    Author     : yamadayuushi
--%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    KagoyumeHelper k_helper = KagoyumeHelper.getInstance();   //KagoyumeHelperをインスタンス化
%>    
    <head>
        <link href="css/EcCss.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Login Page</title>
    </head>
    <body style="margin:20px; padding:0px;"><center>
        <br>
        <h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">ログインページ</font></h1>
        <form action="LoginCheck" method="POST" name="login">
            <br>
            <br>メールアドレス
            <br>
            <input type="text" name="mail" maxlength='20'><%--入力制限(20文字)--%>
            <br>
            <br>パスワード
            <br>
            <input type="password" name="password" maxlength='20'><%--入力制限(20文字)--%>
            <br><br>
            <a href="javascript:document.login.submit()" class="square_btn">LOGIN</a>
            <input type="hidden" name="pageid" value=<%=request.getAttribute("pageid")%>>
            <input type="hidden" name="Cart_ac" value=<%if(request.getParameter("Cart_ac")!=null){out.print(request.getParameter("Cart_ac"));}%>>
        </form>
        <br><br>
        <a href="Registration"><button type="button" class="btn btn-outline-info btn-lg">新規登録する</button></a>
        <br>
        <br>
        <%=k_helper.home()%>
    </body></center>
</html>
