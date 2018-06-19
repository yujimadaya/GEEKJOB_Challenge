<%-- 
    Document   : FortuneTellingResult
    Created on : 2018/06/19, 11:13:14
    Author     : yamadayuushi
--%>
<%@page import="org.camp.servlet.ResultDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultDate data = (ResultDate)request.getAttribute("DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(data != null){
                out.print("<h1>あなたの" + data.getD() + "の運勢は" + data.getLuck() + "です</h1>");
            }
        %>
    </body>
</html>
