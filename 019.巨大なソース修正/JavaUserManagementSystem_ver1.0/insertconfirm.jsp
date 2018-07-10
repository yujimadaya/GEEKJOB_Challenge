<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans data = (UserDataBeans)request.getAttribute("DATA"); //JavaBeans(UserDataBeans)を使用する。
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if(data.minyu()){ %> <!--入力フォームですべての値が格納されている場合はtrueを、それ以外の場合はfalseを表示させる処理-->
        <h1>登録確認</h1>
        名前:<%= hs.getAttribute("name")%><br>
        生年月日:<%= hs.getAttribute("year")+"年"+hs.getAttribute("month")+"月"+hs.getAttribute("day")+"日"%><br>
        種別:<%= hs.getAttribute("type")%><br>
        電話番号:<%= hs.getAttribute("tell")%><br>
        自己紹介:<%= hs.getAttribute("comment")%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
            <input type="hidden" name="acc"  value="<%= hs.getAttribute("acc")%>">
        </form>
    <% }else{ %>
    
    <%    //未入力の項目を表示させる処理
    
        out.print("ERROR" + "<br>" + "<br>");
        
        if(data.getA().equals("")){
            out.print("名前が未入力です" + "<br>");
        }
        if(data.getB() == 0){
            out.print("年が未入力です" + "<br>");
        }
        if(data.getC() == 0){
            out.print("月が未入力です" + "<br>");
        }
        if(data.getD() == 0){
            out.print("日が未入力です" + "<br>");
        }
        if(data.getE() == 0){
            out.print("タイプが選択されていません" + "<br>");
        }
        if(data.getF().equals("")){
            out.print("電話番号が未入力です" + "<br>");
        }    
        if(data.getG().equals("")){
            out.print("自己紹介文が未入力です" + "<br>");
        }
        
        out.print("<br>");

    %>    
    
    <% } %>
        <form action="insert" method="POST">
<%
//別セッションにセッションの値を追加（登録画面に戻った際に値を保持させる為）    
session.setAttribute("name2", hs.getAttribute("name"));
session.setAttribute("year2",hs.getAttribute("year"));
session.setAttribute("month2", hs.getAttribute("month"));
session.setAttribute("day2", hs.getAttribute("day"));
session.setAttribute("type2",hs.getAttribute("type"));
session.setAttribute("tell2",hs.getAttribute("tell"));
session.setAttribute("comment2",hs.getAttribute("comment"));

%>            
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%><!--トップへのリンク-->
    </body>
</html>
