<%-- 
    Document   : forbun1
    Created on : 2018/06/18, 12:48:39
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
long a = 1;
    
for(long i= 0;i<20;++i){ //20回繰り返し

a= a * 8; //8の20乗

}

out.print(a); //計算結果
%>
