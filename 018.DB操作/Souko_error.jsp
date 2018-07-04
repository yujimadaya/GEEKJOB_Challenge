<%-- 
    Document   : Souko_error
    Created on : 2018/07/03, 16:29:40
    Author     : yamadayuushi
--%>

<!-- パスワードまたはIDが違った場合に表示されるページです。-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
        <body><center>
            <h1>IDまたはPasswordが違います</h1>
            <center><form action="./Souko_top.jsp" method="get">
                <br>
                <br>
                <center><input type="submit" name="btnSubmit" value="Top pageへ戻る"></center>
            </form>
        </center></body>
</html>
