<%-- 
    Document   : switch2
    Created on : 2018/06/17, 18:35:04
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
char moji = 'あ';

//変数の値が'A'の場合　「英語」と表示する
//変数の値が'あ'の場合　「日本語」と表示する
//それ以外の場合　何も表示しない（処理を行わない）
switch(moji){
    case 'A':
        out.print("英語");
        break;
    case 'あ':
        out.print("日本語");
        break;
    default:
        break;
}

%>
