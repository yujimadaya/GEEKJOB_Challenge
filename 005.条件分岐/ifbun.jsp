<%-- 
    Document   : ifbun
    Created on : 2018/06/17, 16:02:24
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int num = 2;
    
    //変数に2を指定した為、"プログラミングキャンプ！"の表示が行われます。
    
    if(num == 1){
        out.print("１です！");
    }else if(num == 2){
        out.print("プログラミングキャンプ！");
    }else{
        out.print("その他です！");
    }
    


%>
