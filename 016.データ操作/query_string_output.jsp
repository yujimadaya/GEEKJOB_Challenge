<%-- 
    Document   : query_string_output
    Created on : 2018/06/26, 16:12:01
    Author     : yamadayuushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<%
request.setCharacterEncoding("UTF-8");

String a = request.getParameter("sougaku");
int numa = Integer.parseInt(a);
String b = request.getParameter("suuryou");
int numb = Integer.parseInt(b);


out.print("購入した商品の総額:" + a + "円" + "<br>");
out.print("<br>");
out.print("購入した商品の個数:" + b + "個" + "<br>");
out.print("<br>");
 
String c = request.getParameter("syubetu");
int numc = Integer.parseInt(c);

switch(numc){ //商品種別を調べる処理
    case 1:
        out.print("商品種別:雑貨" + "<br>");
        break;
    
    case 2:
        out.print("商品種別:生鮮食品" + "<br>");
        break;
     
    case 3:
        out.print("商品種別:その他" + "<br>");
        break;

}
out.print("<br>");
out.print("商品の単価:" + (numa/numb) + "円" + "<br>"); //商品の単価(総額/個数)

out.print("<br>");
out.print("今回のポイント:"); 

if(numa >= 5000){ //総額が5000円以上の時総額の5%をポイントにする処理
    out.print((numa * 5/100) + "円です");
}else if(numa >= 3000 ){ //総額が3000円以上の時総額の5%をポイントにする処理
    out.print((numa * 4/100) + "円です");
}else //総額が3000円未満の時,ポイント無し
    out.print("0円です");
 
%>        
        
    </body>
</html>
