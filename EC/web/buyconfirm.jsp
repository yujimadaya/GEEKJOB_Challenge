<%-- 
    Document   : buyconfirm
    Created on : 2018/08/07, 14:45:11
    Author     : yamadayuushi
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO" 
        import="kagoyume.CartBeans"
        import="kagoyume.KagoyumeHelper"
        import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    KagoyumeHelper k_helper = KagoyumeHelper.getInstance();                                     //KagoyumeHelperをインスタンス化
    HttpSession hs = request.getSession();                                                      //セッションスコープの取得
    boolean login = k_helper.logincheck((UserDataDTO)hs.getAttribute("loginDTO"));              //ログインチェック、ログイン済みの場合"login"にtrueを返却
    ArrayList<CartBeans> cartbeans_Array = (ArrayList<CartBeans>)hs.getAttribute("CartData");   //CartBeansの情報を格納をしているArrayList
%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/EcCss.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入確認画面</title>
    </head>
    <body style="margin:20px; padding:0px;"> 
        <%if(login){%>  <%--ログインの有無で表示が変化する。--%>
            <%=k_helper.logout()%> 
        <%}else{%>
            <%=k_helper.login()%>
        <%}%>
        <center><h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">購入確認画面</font></h1></center><br>    
        <%for(int i=0;i< cartbeans_Array.size() ;i++){%>          
    <font size="3" face='ヒラギノ丸ゴ Pro W4'> 
    <img src="<%=cartbeans_Array.get(i).getImage()%>" alt="<%=cartbeans_Array.get(i).getName()%>" align="left" hspace="20">
    <br>名前:<%=cartbeans_Array.get(i).getName()%><br>
    <br><font size="3" color="#dc143c" face='ヒラギノ丸ゴ Pro W4'>¥<%=cartbeans_Array.get(i).getPrice()%></font>
    <br clear="left">    
    </font>
<br><Hr Color="#339900"> 
<%}%>  
<br><br><a>合計額:<%=cartbeans_Array.get(0).getTotal() %>円</a><br>
<br><form action="BuyComplete" method="GET">
<br>配送方法
    <br><input type="radio" name="type" value="1" checked="checked">通常配送
    <br><input type="radio" name="type" value="2">お急ぎ配送
    <br><input type="radio" name="type" value="3">指定日配送
    <input type="hidden" name="Cart_ac" value=<%=hs.getAttribute("Cart_ac")%>>    
    <br><br>
    <center><input type="submit" name="kanryo" class="green" value="上記の内容で購入する"></center>
</form>
    <center>
    <br>
    <br>
    <br><form action="Cart" method="POST" name="cart">
        <br><a href="javascript:document.cart.submit()" class="earth">カートに戻る</a>
        </form>
        <br>
        <%=k_helper.home()%>
    </center>
</body>
</html>
