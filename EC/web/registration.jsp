<%-- 
    Document   : registration
    Created on : 2018/07/25, 16:43:08
    Author     : yamadayuushi
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataBeans" 
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
    KagoyumeHelper k_helper = KagoyumeHelper.getInstance();                                         //KagoyumeHelperをインスタンス化
    HttpSession hs = request.getSession();                                                          //セッションスコープの取得
    UserDataBeans userdatabeans = null;                                                             //userDataBeans(udb)を初期化
    boolean modoru = false;                                                                         //boolean変数"modoru"をfalseに設定する。
    if(request.getParameter("modori")!=null && request.getParameter("modori").equals("Modori")){    //registrationconfirm.jspから移動してきた場合
        modoru = true;                                                                              //boolean変数"modoru"をtrueに変更する。
        userdatabeans = (UserDataBeans)hs.getAttribute("udb");                                      //UserDataBeans(udb)にセッションで登録した"udb"のデータを格納する。
    }
%>
        <title>新規登録</title>
    </head>
    <body style="margin:20px; padding:0px;"><center>
        <h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">新規登録</font></h1><br>
        <form action="Registrationconfirm" method="POST" name="sinki">
            <div class="mx-auto" style="width: 200px;">
                <div class="form-row">
                    <div class="form-group">
                        <label for="UserName"><font color="#8BC34A" size="2" face="ヒラギノ丸ゴ Pro W4">ユーザー名</font></label>
                        <input type="text" class="form-control" pattern="^([a-zA-Z0-9]{4,20})$" maxlength='20' name="name" value="<%if(modoru){out.print(userdatabeans.getName());}%>"  required>
                        <small class="text-muted">半角英数字4文字以上20文字以下</small>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="PassWord"><font color="#8BC34A" size="2" face="ヒラギノ丸ゴ Pro W4">パスワード</font></label>
                        <input type="password" class="form-control" pattern="^([a-zA-Z0-9]{6,20})$" maxlength='20' name="pass"  required>
                        <small class="text-muted">半角英数字6文字以上20文字以下</small>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="PassWordConfirm"><font color="#8BC34A" size="2" face="ヒラギノ丸ゴ Pro W4">パスワード（確認用）</font></label>
                        <input type="password" class="form-control" pattern="^([a-zA-Z0-9]{6,20})$" maxlength='20' name="passconfirm"  required>
                        <small class="text-muted">半角英数字6文字以上20文字以下</small>
                    </div>
                </div>        
                <div class="form-row">
                    <div class="form-group">
                        <label for="E-mail"><font color="#8BC34A" size="2" face="ヒラギノ丸ゴ Pro W4">メールアドレス</font></label>
                        <input type="text" class="form-control" pattern=".{0,100}" maxlength='100' name="mail" value="<%if(modoru){out.print(userdatabeans.getMail());}%>"  required>
                        <small class="text-muted">100文字以下</small>
                    </div>
                </div>      
                <div class="form-row">
                    <div class="form-group">
                        <label for="Address"><font color="#8BC34A" size="2" face="ヒラギノ丸ゴ Pro W4">住所</font></label>
                        <input type="text" class="form-control" pattern=".{0,100}" maxlength='100' name="address" value="<%if(modoru){out.print(userdatabeans.getAddress());}%>"  required>
                        <small class="text-muted">100文字以下</small>
                    </div>
                </div>                         
            </div>                

                <input type="hidden" name="Insert_ac" value=<%=hs.getAttribute("Insert_ac")%>> 
            
                <br><input type="submit" name="registration" value="登録" class="green">
 
        </form>
            <br>
            <br>
            <%=k_helper.home()%>
    </body></center>
</html>
