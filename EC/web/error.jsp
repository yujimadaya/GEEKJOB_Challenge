<%-- 
    Document   : error
    Created on : 2018/07/30, 15:44:14
    Author     : yamadayuushi
--%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"
        import="javax.servlet.http.HttpSession"%> 
<!DOCTYPE html>
<html>
<%
    KagoyumeHelper k_helper = KagoyumeHelper.getInstance(); //KagoyumeHelperをインスタンス化
    HttpSession hs = request.getSession();                  //セッションスコープの取得
%>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
    </head>
    <body style="margin:20px; padding:0px;">
        <center>
            <br>
                エラーが発生しました。以下の項目を確認してください。
            <br>
                <%=request.getAttribute("error")%><%--エラーの内容を表示--%>
            <br><br>
            <form action=<%
                if(request.getAttribute("loginmiss")!=null&&request.getAttribute("loginmiss").equals("LoginMiss")){
                    out.print("./Login");
                }else{
                    out.print(request.getAttribute("pageid"));
                        }%> method="POST"><%--pageidに登録してあるページ先へ移動する。--%>
                <input type="hidden" name="pageid" value=<%=request.getAttribute("pageid")%>><%--pageidに登録された値をhiddenで受け渡し--%>
                <input type="hidden" name="User_ac" value=<%if(hs.getAttribute("User_ac")!=null){out.print(hs.getAttribute("User_ac"));}%>><%--アクセスチェックの値をhiddenで受け渡し--%>
                <input type="hidden" name="Cart_ac" value=<%if(request.getParameter("Cart_ac")!=null){out.print(request.getParameter("Cart_ac"));};%>><%--アクセスチェックの値をhiddenで受け渡し--%>
                <input type="submit" name="modoru" value="戻る">
            </form>
            <br>
            <%=k_helper.home()%>
        </center>
    </body>
</html>
