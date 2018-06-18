<%-- 
    Document   : forbun2
    Created on : 2018/06/18, 13:21:38
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

String a =""; //aには何も置かない

for(int i=0;i<30;i++){ //30回繰り返す

a = a + "A"; //Aを30回入力させる

}

out.print(a); //上記で作成した a を表示させる
%>
