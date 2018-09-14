<%-- 
    Document   : registrationcomplete
    Created on : 2018/07/30, 16:13:01
    Author     : yamadayuushi
--%>
<%@page import="kagoyume.UserDataBeans" 
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
        KagoyumeHelper k_helper = KagoyumeHelper.getInstance();                     //KagoyumeHelperをインスタンス化
        UserDataBeans userdatabeans = (UserDataBeans)request.getAttribute("udb");   //サーブレットで格納したデータをUserDataBeans(udb)に格納する。   
%>
        
        <title>登録完了!</title>
    </head>
    <body style="margin:20px; padding:0px;"><center>
        <br>
        <h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">以上の内容で登録しました。</font></h1>
    <div class="box26">          
        <p class="text">  
                <span class="box-title">登録情報</span><%--UserDataBeansに格納されている情報の表示--%>
                <font color="#955D30" size="4" face="ヒラギノ丸ゴ Pro W4">
                名前:<%=userdatabeans.getName()%><br>
                パスワード:<%=userdatabeans.getPass()%><br>
                メールアドレス:<%=userdatabeans.getMail()%><br>
                住所:<%=userdatabeans.getAddress()%><br>
                </font>
            </p>
    </div>  
        <br>
        <%=k_helper.home()%>    
    </center></body>
</html>
