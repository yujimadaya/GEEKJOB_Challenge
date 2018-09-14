<%-- 
    Document   : registrationconfirm
    Created on : 2018/07/25, 16:49:40
    Author     : yamadayuushi
--%>

<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataBeans" 
        import="kagoyume.KagoyumeHelper "
        import="java.util.ArrayList "%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/EcCss.css" rel="stylesheet" type="text/css"/> 
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%   
        KagoyumeHelper k_helper = KagoyumeHelper.getInstance();                 //KagoyumeHelperをインスタンス化
        HttpSession hs = request.getSession();                                  //セッションスコープの取得
        UserDataBeans userdatabeans = (UserDataBeans)hs.getAttribute("udb");    //サーブレットで格納したデータをUserDataBeans(udb)に格納する。
        ArrayList<String> checkList = userdatabeans.checkfour();                //入力されていない、若しくは指示通り入力されていない場合、checkListにコマンドが格納されている。
%>
        <title>登録確認画面</title>
    </head>
    <body style="margin:20px; padding:0px;"><center>
        
        <%if(checkList.size()==0){%>
        
    <div class="box26">          
        <p class="text">  
                <span class="box-title">入力情報</span>
                <font color="#955D30" size="4" face="ヒラギノ丸ゴ Pro W4">
                名前:<%=userdatabeans.getName()%><br>
                パスワード:<%=userdatabeans.getPass()%><br>
                メールアドレス:<%=userdatabeans.getMail()%><br>
                住所:<%=userdatabeans.getAddress()%><br>
                </font>
            </p>
    </div>    
         
        <br>上記の内容で登録いたします。よろしいですか？<br>
        <br><form action="RegistrationComplete" method="POST">
            <input type="hidden" name="Insert_ac" value=<%=hs.getAttribute("Insert_ac")%>> 
            <input type="submit" name="yes" value="はい" class="yes">
            </form>
            <br>
            <form action="Registration" method="POST">
            <input type="submit" name="no" value="いいえ" class="no">
            <input type="hidden" name="modori" value="Modori">
        </form>
        <%}else{%>
        <br>
        <%=k_helper.checkip(checkList)%>
        
        <br><form action="Registration" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            <input type="hidden" name="modori" value="Modori">
            </form>
        <%}%>
         
        <br><br>
        <%=k_helper.home()%>
    </center></body>
</html>
