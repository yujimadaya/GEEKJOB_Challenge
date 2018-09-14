<%-- 
    Document   : myhistory
    Created on : 2018/08/10, 13:09:56
    Author     : yamadayuushi
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO"
        import="kagoyume.MyHistoryBeans"
        import="kagoyume.KagoyumeHelper"
        import="java.util.ArrayList"
        import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/return.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">               
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
    HttpSession hs = request.getSession();                                          //セッションスコープの取得
    UserDataDTO loginDTO = null;                                                    //UserDataDTO初期化   
    KagoyumeHelper k_helper = KagoyumeHelper.getInstance();                               //KagoyumeHelperをインスタンス化
    boolean login = k_helper.logincheck((UserDataDTO)hs.getAttribute("loginDTO"));        //ログインチェック、ログイン済みの場合"login"にtrueを返却
    if(login){loginDTO = (UserDataDTO)hs.getAttribute("loginDTO");}                 //ログインされている場合、UserDataDTOにユーザー情報を格納     
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分");           //購入日時の表示用
    ArrayList<MyHistoryBeans> myhistorybeans_array = (ArrayList<MyHistoryBeans>)hs.getAttribute("myhistoryData");
%>
        <title>購入履歴</title>
    </head>
    <body style="margin:20px; padding:0px;">
        <%if(login){%>  <%--ログインの有無で表示が変化する。--%>
            <%=k_helper.logout()%> 
        <%}else{%>
            <%=k_helper.login()%>
        <%}%>
    <center><h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">購入履歴</font></h1></center><br>
<%for(int i=0;i< myhistorybeans_array.size();i++){%>             

    <a><img src="<%=myhistorybeans_array.get(i).getImage() %>" alt="<%=myhistorybeans_array.get(i).getName() %>" align="left" hspace="20"></a> <%--画像情報--%>
    <font size="3" face='ヒラギノ丸ゴ Pro W4'>
    <br><a>名前:<%=myhistorybeans_array.get(i).getName() %></a>
    <br><font size="3" color="#dc143c" face='ヒラギノ丸ゴ Pro W4'>¥<%=myhistorybeans_array.get(i).getPrice() %></font>
    <br>配送方法:<%=k_helper.exTypenum(myhistorybeans_array.get(i).getType())%>
    <br>購入日時:<%=sdf.format(myhistorybeans_array.get(i).getBuyDate())%>
    <br clear="left">      
    </font>
<Hr Color="#339900">           
<%}%> 
<br>総購入金額:<%=loginDTO.getTotal()%>円
<br>
<center>
    <form action="MyData" name="mydata" method="post">
    <input type="submit" value="ユーザー情報へ戻る" class="return">     
    <input type="hidden" name="User_ac" value=<%=hs.getAttribute("User_ac")%>> 
    </form>
</center>
<br><br>
    <%=k_helper.home()%>
    <br>
    </body>
</html>
