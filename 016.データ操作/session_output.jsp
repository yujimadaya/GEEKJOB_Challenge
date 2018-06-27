<%-- 
    Document   : session_output
    Created on : 2018/06/27, 13:57:01
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            
            String a = request.getParameter("onamae"); //request.getParameter("onamae")の値を変数aに格納
            String b = request.getParameter("danjyo"); //request.getParameter("danjyo")の値を変数bに格納
            String c = request.getParameter("gosyumi");//request.getParameter("gosyumi")の値を変数cに格納
           
            HttpSession hs = request.getSession();
            
            hs.setAttribute("namae", a); //セッションへ"namae"という名前で変数aを登録
            hs.setAttribute("malefemale", b); //セッションへ"malefemale"という名前で変数bを登録
            hs.setAttribute("syumi", c); //セッションへ"syumi"という名前で変数cを登録
            
            out.print("名前:" + a + "<br>");
            out.print("<br>");
            out.print("性別:" + b + "<br>");
            out.print("<br>");
            out.print("趣味:" + c + "<br>");
            
        %> 
        
    </body>
</html>
