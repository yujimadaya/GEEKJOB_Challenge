<%-- 
    Document   : forbun3
    Created on : 2018/06/18, 13:34:24
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

int a = 0; //変数aを0と置く
    
for(int i=0 ;i<=100;i++){ //100回繰り返す

a =a + i; //0から100までの数字をaに順番に足していく

}

out.print(a); //上記aの合計値を表示

%>
