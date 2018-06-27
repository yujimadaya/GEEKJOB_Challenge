<%-- 
    Document   : session_input
    Created on : 2018/06/27, 13:56:37
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
        <form action="./session_output.jsp" method="get"></a>
        <br>お名前
        <br><input type="text" name="onamae" value=<%
                        
                        HttpSession hs = request.getSession(); //セッションの所得
                        
                        String simei = (String)hs.getAttribute("namae"); //セッションから"namae"に登録された文字をsemeiに格納する
                        
                        out.print(simei);
                   %> >
        <br>
        <br>性別
        <br><input type="radio" name="danjyo" value="男" <%
                    String otoko =(String)hs.getAttribute("malefemale"); //セッションから"malefemale"に登録された文字をotokoに格納する
                    
                    if(otoko != null){
                        
                        if(otoko.equals("男")){ //otokoに格納された文字が"男"の場合
                            
                            out.print("checked=\"checked\""); //checked="check"（初期値で選択された状態)を表示させる
                        
                        }else{
                        
                        } 
                        
                    } 
                   %> >男
            <input type="radio" name="danjyo" value="女" <%
                    String onna =(String)hs.getAttribute("malefemale"); //セッションから"malefemale"に登録された文字をonnaに格納する
                    
                    if(onna != null){
                    
                        if(otoko.equals("女")){ //onnaに格納された文字が"女"の場合  
                            
                            out.print("checked=\"checked\""); //checked="check"（初期値で選択された状態)を表示させる
                        }else{
                            
                        }    
                        
                    } 

                   %>>女
        <br>
        <br>趣味
        <br><input type="text" name="gosyumi" value=<%
                   
                        String misyu = (String)hs.getAttribute("syumi"); //セッションから"syumi"に登録された文字をmisyuに格納する
                   
                        out.print(misyu);
                      
                    %> ></textarea>
        <br>
        <br><input type="submit" name="btnSubmit">
        </form>
    </body>
</html>
