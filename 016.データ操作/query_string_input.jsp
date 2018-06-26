<%-- 
    Document   : query_string_input
    Created on : 2018/06/26, 16:11:20
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品購入</title>
    </head>
        <body>
            <center>
                <form action="./query_string_output.jsp" method="get">
                    <br>購入した商品の総額
                    <br><input type="text" name="sougaku" required="">円
                    <br>
                    <br>購入した商品の数量
                    <br><input type="text" name="suuryou" required="">個
                    <br>
                    <br>商品種別
                    <br><select size="1" name="syubetu"> 
                        <option value=1>1.雑貨</option>
                        <option value=2>2.生鮮食品</option>
                        <option value=3>3.その他</option>
                    </select>
                    <br>
                    <br><input type="submit" value="送信">
            </center>    
        </form>
    </body>
</html>
