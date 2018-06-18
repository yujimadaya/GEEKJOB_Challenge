<%-- 
    Document   : whilebun
    Created on : 2018/06/18, 14:13:25
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
double a = 1000;

while(a > 100){ //100より小さい

    a = (a / 2); //2で割り続ける処理

}

out.print(a);

%>
