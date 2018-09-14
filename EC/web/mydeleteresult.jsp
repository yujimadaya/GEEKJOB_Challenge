<%-- 
    Document   : mydeleteresult
    Created on : 2018/08/08, 13:57:11
    Author     : yamadayuushi
--%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<%
    KagoyumeHelper k_helper = KagoyumeHelper.getInstance();//KagoyumeHelperをインスタンス化
%>    
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除完了画面</title>
    </head>
    <body style="margin:20px; padding:0px;">
        <center>
            <h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">削除しました。</font></h1>
            <br>
            <%=k_helper.home()%>    
        </center>
    </body>
</html>
