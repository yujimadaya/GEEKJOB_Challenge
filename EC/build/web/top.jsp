<%-- 
    Document   : top
    Created on : 2018/07/24, 11:52:37
    Author     : yamadayuushi
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO" 
        import="kagoyume.UserDataBeans"
        import="kagoyume.KagoyumeHelper"%>
<%
    HttpSession hs = request.getSession();                                          //セッションスコープの取得
    KagoyumeHelper k_helper = KagoyumeHelper.getInstance();                         //KagoyumeHelperをインスタンス化
    UserDataDTO loginDTO = null;                                                    //UserDataDTO初期化
    boolean login = k_helper.logincheck((UserDataDTO)hs.getAttribute("loginDTO"));  //ログインチェック、ログイン済みの場合"login"にtrueを返却
    if(login){loginDTO = (UserDataDTO)hs.getAttribute("loginDTO");}                 //ログインされている場合、UserDataDTO(loginDTO)にユーザー情報を格納
%>        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/EcCss.css" rel="stylesheet" type="text/css"/>      
        <title>かごゆめTOP PAGE</title>
    </head>
    <body style="margin:20px; padding:0px;">
        <center>
            <%if(login){%> 
                <%=k_helper.logout()%> 
            <%}else{%>
                <%=k_helper.login()%>
            <%}%>
            <img src="image/logo-4.png"><%--画像ファイル--%>         
            <br>
            <font size="4" color="#54d1a7" face='ヒラギノ丸ゴ Pro W4'>このサイトは架空で買い物ができるサイトです。</font>
            <br>
            <br><%if(login){out.print("ようこそ" + loginDTO.getName() + "さん");}%><br> <%--loginDTOからnameを取り出す。--%>
            <br>                      
            <form action="Search" method="get" name="search"> <%--getメソッドで送る--%>
                <div class="mx-auto" style="width: 200px;">
                    <div class="form-row align-items-center">
                        <div class="form-group">
                            <label for="Search">商品名検索</label>
                            <input type="text" class="form-control" maxlength='100' name="search_word"> <%--100文字以上入力フォームに文字が入らない--%>
                        </div>
                    </div> 
                </div>     
                <a href="javascript:document.search.submit()" class="cp_btn">検索</a>
            </form>
            <br>
            <br>
            <%if(login){%>
            <br><form action="MyData" method="POST">
                    <button type="submit" class="btn btn-outline-success btn-lg">ユーザー情報</button>
                    <input type="hidden" name="User_ac" value=<%=(int)(Math.random() * 1000)%>> <%--アクセスチェックの作成--%>
                </form>
            <%}%>
            <br><form action="Cart" method="POST">
                    <button type="submit" class="btn btn-outline-primary btn-lg">買い物カゴ</button>
                    <input type="hidden" name="Cart_ac" value=<%=(int)(Math.random() * 1000)%>><br> <%--アクセスチェックの作成--%>
                </form>            
        </center>
    </body>
</html>
