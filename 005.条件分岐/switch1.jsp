<%-- 
    Document   : switch1
    Created on : 2018/06/17, 17:45:32
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int num = 3;

//変数の値が1の場合　「one」と表示する
//変数の値が2の場合　「two」と表示する
//それ以外の場合　「想定外」と表示する

switch(num){
    case 1:
        out.print("one");
        break;
    case 2:
        out.print("two");
        break;
    default:
        out.print("想定外");
        break;

}

%>
