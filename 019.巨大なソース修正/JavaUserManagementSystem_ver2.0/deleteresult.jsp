
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    削除しました。<br>
    <form action="SearchResult" method="POST">
            <input type="submit" name="no" value="検索結果画面に戻る">
            
            <input type="hidden" name="name" value=<%
                   out.print(session.getAttribute("sename").toString());
                   %>>
            <%int a;%>
            <input type="hidden" name="type" value=<%
                String type = "0";
                if(session.getAttribute("setype") != null){
                type = session.getAttribute("setype").toString();  
                }
                out.print(type); 
                    %>>
            <input type="hidden" name="year" value=<%
                   out.print(session.getAttribute("seyear").toString());
                   %>>            
        </form>
    </body>
</html>
