<%-- 
    Document   : cart
    Created on : 2018/08/03, 15:37:37
    Author     : yamadayuushi
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO" 
        import="kagoyume.CartBeans"
        import="kagoyume.KagoyumeHelper"
        import="java.util.ArrayList"
        import="javax.servlet.http.Cookie"%>
        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    KagoyumeHelper k_helper = KagoyumeHelper.getInstance();                                     //KagoyumeHelperをインスタンス化
    HttpSession hs = request.getSession();                                                      //セッションスコープの取得                                                  //UserDataDTO初期化
    boolean login = k_helper.logincheck((UserDataDTO)hs.getAttribute("loginDTO"));              //ログインチェック、ログイン済みの場合"login"にtrueを返却
    ArrayList<CartBeans> cartbeans_Array = (ArrayList<CartBeans>)hs.getAttribute("CartData");   //CartBeansの情報を格納するArrayList
%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/EcCss.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カートページ</title>
    </head>
    <body style="margin:20px; padding:0px;"> 
        <%if(login){%>  <%--ログインの有無で表示が変化する。--%>
            <%=k_helper.logout()%> 
        <%}else{%>
            <%=k_helper.login()%>
        <%}%>
        
    <center><h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">買い物かご</font></h1></center><br>
            <%if(cartbeans_Array.size() != 0){%>        
        
    <%for(int i=0;i< cartbeans_Array.size() ;i++){%>        
            

 <font size="3" face='ヒラギノ丸ゴ Pro W4'> 
    <br><form action="Item" method="GET"><%--Item.javaにGETメソッドで送る--%>
        <input type="hidden" name="code" value="<%=cartbeans_Array.get(i).getItemCode() %>">
        <input type="hidden" name="page" value="cartpage">
        <input type="image" src="<%=cartbeans_Array.get(i).getImage() %>" alt="<%=cartbeans_Array.get(i).getName() %>" align="left"></a><%--画像情報--%>  
        </form>
    <br><form action="Item" method="GET"><%--Item.javaにGETメソッドで送る--%>
        <input type="hidden" name="code" value="<%=cartbeans_Array.get(i).getItemCode() %>">
        <input type="hidden" name="page" value="cartpage">    
        <button type="submit" class="btn btn-link"><%=cartbeans_Array.get(i).getName() %></button>    
        </form> 
        <br><font size="3" color="#dc143c" face='ヒラギノ丸ゴ Pro W4'>&emsp;¥<%=cartbeans_Array.get(i).getPrice() %></font>
        <br clear="left">
 </font>
    <form action="Cart">
        <input type="hidden" name="deleteID" value=<%=i%>> <%--デリートIDを指定し、そのIDの商品情報を削除する--%>
        <input type="submit" class="btn btn-outline-dark btn-sm" name="delete" value="削除">        
    </form>
<Hr Color="#339900">           
<%}%> 

<br><br><a>合計額:<%=cartbeans_Array.get(0).getTotal()%>円</a> 

<br><form action="BuyConfirm">
    <input type="hidden" name="Cart_ac" value=<%=hs.getAttribute("Cart_ac")%>>
    <br><center><input type="submit" name="konyu" value="購入する" class="green"></center> 
</form>
<%}else{%> <%="カートには何も登録されていません。"%> <%}%>
<br>
<%=k_helper.home()%>
    </body>
</html>
