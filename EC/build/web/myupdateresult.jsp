<%-- 
    Document   : myupdateresult
    Created on : 2018/08/08, 11:40:56
    Author     : yamadayuushi
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO"
        import="kagoyume.KagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/EcCss.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
<%
    KagoyumeHelper k_helper = KagoyumeHelper.getInstance();                         //KagoyumeHelperをインスタンス化
    HttpSession hs = request.getSession();                                          //セッションスコープの取得
    UserDataDTO loginDTO = null;                                                    //UserDataDTO初期化                 
    boolean login = k_helper.logincheck((UserDataDTO)hs.getAttribute("loginDTO"));  //ログインチェック、ログイン済みの場合"login"にtrueを返却
    if(login){loginDTO = (UserDataDTO)hs.getAttribute("loginDTO");}                 //ログインされている場合、UserDataDTO(loginDTO)にユーザー情報を格納
%>
        <title>更新完了</title>
    </head>
    <body style="margin:20px; padding:0px;"><center>
        <%if(login){%>  <%--ログインの有無で表示が変化する。--%>
            <%=k_helper.logout()%> 
        <%}else{%>
            <%=k_helper.login()%>
        <%}%>  
        <br>
        <h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">以上の内容で更新しました!</font></h1>
         <div class="box26">          
        <p class="text">  
                <span class="box-title">更新結果</span>
                <font color="#955D30" size="4" face="ヒラギノ丸ゴ Pro W4">
                名前:<%=loginDTO.getName()%>
                <br>パスワード:<%=loginDTO.getPass()%>
                <br>メールアドレス:<%=loginDTO.getMail()%>
                <br>住所:<%=loginDTO.getAddress()%>
                </font>
            </p>
    </div>
        <br>
        <br>
        <%=k_helper.home()%>
    </center></body>
</html>
