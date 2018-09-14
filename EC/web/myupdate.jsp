<%-- 
    Document   : myupdata
    Created on : 2018/08/07, 17:22:26
    Author     : yamadayuushi
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO"
        import="kagoyume.KagoyumeHelper"%>
        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<%
    HttpSession hs = request.getSession();                                      //セッションスコープの取得
    KagoyumeHelper k_helper = new KagoyumeHelper();                                   //KagoyumeHelperをインスタンス化
    UserDataDTO loginDTO = null;                                                //UserDataDTO初期化                 
    boolean login = k_helper.logincheck((UserDataDTO)hs.getAttribute("loginDTO"));    //ログインチェック、ログイン済みの場合"login"にtrueを返却
    if(login){loginDTO = (UserDataDTO)hs.getAttribute("loginDTO");}             //ログインされている場合、UserDataDTO(loginDTO)にユーザー情報を格納
%>
        <link href="css/return.css" rel="stylesheet" type="text/css"/>
        <link href="css/EcCss.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="margin:20px; padding:0px;"><center>
        <%if(login){%>  <%--ログインの有無で表示が変化する。--%>
            <%=k_helper.logout()%> 
        <%}else{%>
            <%=k_helper.login()%>
        <%}%>  
            <h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">ユーザー情報変更</font></h1>
        <form action="MyUpdateresult" method="POST">
            <div class="mx-auto" style="width: 200px;">
                <div class="form-row">
                    <div class="form-group">
                        <label for="UserName"><font color="#8BC34A" size="2" face="ヒラギノ丸ゴ Pro W4">ユーザー名</font></label>
                        <input type="text" class="form-control" pattern="^([a-zA-Z0-9]{4,20})$" maxlength='20' name="name" value="<%if(login){out.print(loginDTO.getName());}%>" placeholder="UserName" required>
                        <small class="text-muted">半角英数字4文字以上20文字以下</small>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="PassWord"><font color="#8BC34A" size="2" face="ヒラギノ丸ゴ Pro W4">パスワード</font></label>
                        <input type="password" class="form-control" pattern="^([a-zA-Z0-9]{6,20})$" maxlength='20' name="pass" required>
                        <small class="text-muted">半角英数字6文字以上20文字以下</small>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="PassWordConfirm"><font color="#8BC34A" size="2" face="ヒラギノ丸ゴ Pro W4">パスワード（確認用）</font></label>
                        <input type="password" class="form-control" pattern="^([a-zA-Z0-9]{6,20})$" maxlength='20' name="passconfirm" required>
                        <small class="text-muted">半角英数字6文字以上20文字以下</small>
                    </div>
                </div>           
                <div class="form-row">
                    <div class="form-group">
                        <label for="E-mail"><font color="#8BC34A" size="2" face="ヒラギノ丸ゴ Pro W4">メールアドレス</font></label>
                        <input type="text" class="form-control" pattern=".{0,100}" maxlength='100' name="mail" value="<%if(login){out.print(loginDTO.getMail());}%>" placeholder="E-mail" required>
                        <small class="text-muted">100文字以下</small>
                    </div>
                </div>      
                <div class="form-row">
                    <div class="form-group">                         
                        <label for="Address"><font color="#8BC34A" size="2" face="ヒラギノ丸ゴ Pro W4">住所</font></label>
                        <input type="text" class="form-control" pattern=".{0,100}" maxlength='100' name="address" value="<%if(login){out.print(loginDTO.getAddress());}%>" placeholder="Address" required>
                        <small class="text-muted">100文字以下</small>
                    </div>
                </div>                         
            </div>
            <br>
            <br><input type="hidden" name="User_ac" value=<%=hs.getAttribute("User_ac")%>> 
            <br><input type="submit" name="touroku" class="green" value="変更する">
        </form>
            <br><br>
                <form action="MyData" name="mydata" method="post">
                    <input type="submit" value="ユーザー情報へ戻る" class="bluereturn">     
                    <input type="hidden" name="User_ac" value=<%=hs.getAttribute("User_ac")%>> 
                </form>    
            <br>
            <br>
            <%=k_helper.home()%>
            <br>
    </body></center>
</html>
