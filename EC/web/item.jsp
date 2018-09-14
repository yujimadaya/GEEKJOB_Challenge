<%-- 
    Document   : item
    Created on : 2018/07/25, 16:21:37
    Author     : yamadayuushi
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO" 
        import="kagoyume.KagoyumeHelper"
        import="kagoyume.ItemBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();                                     //セッションインスタンス生成
    KagoyumeHelper k_helper = new KagoyumeHelper();                                  //KagoyumeHelperをインスタンス化
    boolean login = k_helper.logincheck((UserDataDTO)hs.getAttribute("loginDTO"));   //ログインチェック、ログイン済みの場合"login"にtrueを返却
    ItemBeans itembeans = (ItemBeans)request.getAttribute("ItemData");
%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/EcCss.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item Page</title>
    </head>
    <body style="margin:20px; padding:0px;">
        <%if(login){%>  <%--ログインの有無で表示が変化する。--%>
            <%=k_helper.logout()%> 
        <%}else{%>
            <%=k_helper.login("Item") %>
            <%}%>
    <center><h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">カートへ商品を追加</font></h1></center>
    

 <br><center><img src="<%=itembeans.getImage()%>" alt="<%=itembeans.getName()%>" ></a></center> <%--画像情報--%>
 <font size="3" face='ヒラギノ丸ゴ Pro W4'>            
    <br>名前:<%=itembeans.getName()%><br>
    <br>金額:<%=itembeans.getPrice()%>円（税込）<br>
    <br>概要：<%=itembeans.getOverview() %><br>
    <br>評価値：<%=itembeans.getRate() %><br>
 </font>                 
        <center>
            <form action="Add" method="get">
                <input type="hidden" name="code" value=<%=itembeans.getItemCode() %>>
                <input type="hidden" name="price" value=<%=itembeans.getPrice() %>
                <br><br><input type="submit" name="add" value="追加する" class="green"> 
            </form>
            <br><br><br>   
        <%if(request.getParameter("page")!=null && request.getParameter("page").equals("cartpage")){%>
        <form action="Cart" method="GET" name="cart">
            <br><a href="javascript:document.cart.submit()" class="earth">CARTに戻る</a>
        </form>       
        <%}else{%>
        <form action="Search" method="GET" name="search">
            <br><a href="javascript:document.search.submit()" class="earth">商品一覧に戻る</a>
        </form>
        <%}%>
            <br><%=k_helper.home()%>
            <br>
        </center></body>
</html>
