<%-- 
    Document   : Souko_loginpage
    Created on : 2018/07/03, 16:29:24
    Author     : yamadayuushi
--%>

<!--    IDとパスワードが合致していた場合表示されるページです。 
        在庫情報変更ボタンを押すと在庫情報の登録・変更・削除・閲覧ができます。
        ログアウトをすると最初のページへ移動します。
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理システム</title>
    </head>
    <body>
    <center><h1>在庫管理システムへようこそ</h1></center>
        <br>
        <br>
        <br><center><form action="./Souko_touroku.jsp" method="get">
        <input type="submit" name="btnSubmit" value="在庫情報変更"> 
        </form></center>
        <br>
        <br><center><form action="./Souko_eturan.jsp" method="get">
        <input type="submit" name="btnSubmit" value="在庫一覧">
        </form></center>
        <br>
        <br><center><form action="./Souko_top.jsp" method="get">
        <input type="submit" name="btnSubmit" value="Logout">
        </form></center>
    </body>
</html>
