<%-- 
    Document   : search
    Created on : 2018/07/25, 16:16:04
    Author     : yamadayuushi
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO" 
        import="kagoyume.KagoyumeHelper"
        import="kagoyume.SearchBeans"
        import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();                                                                  //セッションスコープの取得
    KagoyumeHelper k_helper = new KagoyumeHelper();                                                         //KagoyumeHelperをインスタンス化
    boolean login = k_helper.logincheck((UserDataDTO)hs.getAttribute("loginDTO"));                          //ログインチェック、ログイン済みの場合"login"にtrueを返却
    ArrayList<SearchBeans> searchbeans_Array =(ArrayList<SearchBeans>)request.getAttribute("SearchData");   //検索結果の商品情報を格納しているArrayList
    int result_num = 10;                                                                                    //表示件数（通常は10件表示させる）                                
    if(searchbeans_Array.size()!=0){result_num = k_helper.num_check(searchbeans_Array.get(0).getHit());}    //検索結果が1~9件の場合はその数分表示させる
%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/EcCss.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <title>検索Page</title>
    </head>
    <body style="margin:20px; padding:0px;"> 
        <%if(login){%>  <%--ログインの有無で表示が変化する。--%>
            <%=k_helper.logout()%> 
        <%}else{%>
            <%=k_helper.login("Search") %>
        <%}%>
        
        <%if(searchbeans_Array.size()!=0){%> <%--検索結果が0件ではない場合--%>
            <center><h1><font color="#955D30" face="ヒラギノ丸ゴ Pro W4">検索商品一覧</font></h1></center>

                    <br>検索ワード:<%=searchbeans_Array.get(0).getWord()%><br>
                    <br>検索結果:<%=searchbeans_Array.get(0).getHit()%>件
                    <br><br>   
                    <%for(int i=0;i<result_num;i++){%> <%--10件表示させる処理(1~9件の場合はその数だけ表示する)--%>
                            <font size="3" face='ヒラギノ丸ゴ Pro W4'>
                                <form action="Item" method="GET"><%--Item.javaにGETメソッドで送る--%>
                                    <input type="hidden" name="code" value="<%=searchbeans_Array.get(i).getItemCode()%>">
                                    <input type="image" src="<%=searchbeans_Array.get(i).getImage()%>" alt="<%=searchbeans_Array.get(i).getName()%>" align="left" hspace="20"></a><%--画像情報--%>  
                                </form>
                                <br>
                                <form action="Item" method="GET"><%--Item.javaにGETメソッドで送る--%>
                                    <input type="hidden" name="code" value="<%=searchbeans_Array.get(i).getItemCode()%>">
                                    <button type="submit" class="btn btn-link"><%=searchbeans_Array.get(i).getName()%></button>    
                                </form> 
                                    <font size="3" color="#dc143c" face='ヒラギノ丸ゴ Pro W4'><p>&emsp;¥<%=searchbeans_Array.get(i).getPrice()%></p></font>
                            </font>        
                            <br clear="left">    
                            <Hr size="20" Color="#339900">                   
                    <%}%>
        <%}else{%><%--検索結果が0件の場合↓--%>    
            <center>
                検索結果が見つかりませんでした。
                <br><br>    
                検索ワード:<%=hs.getAttribute("search_word")%><%--検索した言葉を表示--%>
                <br><br>
            </center>
        <%}%>
        <%=k_helper.home()%><%--TOP画面に戻る--%>
        <br>
    </body>
</html>
