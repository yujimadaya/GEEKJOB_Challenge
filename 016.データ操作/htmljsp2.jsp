<%-- 
    Document   : htmljsp2
    Created on : 2018/06/26, 14:05:38
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>診断結果</title>
    </head>
    <body>
        
    <center><font size="20" color="#ff0000"><% 
        request.setCharacterEncoding("UTF-8");
        out.print("診断結果");%></font>
    <br>
    <br>
    <br>
    <p><center><font size="4" color=""><% 
        request.setCharacterEncoding("UTF-8");
        out.print(request.getParameter("erabu")+ "の診断結果は...");%></font></p>
    
    <p><center><font size="10"><%
        request.setCharacterEncoding("UTF-8");
        
        String a = request.getParameter("erabu"); //String変数aに血液型を格納
        
        if(a.equals("A型")){ //血液型ごとに診断結果を表示します
            out.print("努力家です");
        }else if(a.equals("B型")){
            out.print("熱中家です");
        }else if(a.equals("O型")){
            out.print("おおらかです");
        }else if(a.equals("AB型")){
            out.print("天才肌です");
        }
       

%></font></center></p>
    
        </center>
    </body>
</html>
