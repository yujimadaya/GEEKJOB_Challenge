<%-- 
    Document   : add
    Created on : 2018/07/25, 16:25:13
    Author     : yamadayuushi
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO" 
        import="kagoyume.KagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    HttpSession hs = request.getSession();                                           //セッションインスタンス生成
    KagoyumeHelper k_helper = new KagoyumeHelper();                                  //KagoyumeHelperをインスタンス化
    boolean login = k_helper.logincheck((UserDataDTO)hs.getAttribute("loginDTO"));   //ログインチェック、ログイン済みの場合"login"にtrueを返却 
%>    
    <head>
        <link href="css/return.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>追加完了</title>
    </head>
    <body style="margin:20px; padding:0px;">
        <center>
        <%if(login){%>  <%--ログインの有無で表示が変化する。--%>
            <%=k_helper.logout()%> 
        <%}else{%>
            <%=k_helper.login()%>
        <%}%>
            <br>
            <h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">カートに追加しました！</font></h1>
            <br>
                <form action="Search" name="mydata" method="post">
                    <input type="submit" value="検索一覧へ戻る" class="return">     
                </form>
            <br>
            <%=k_helper.home()%>
        </center> 
    </body>
</html>
