<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value=<%
            if(hs.getAttribute("name2") instanceof String){ //セッション"name2"に格納されているのがnullではないとき
                out.print(hs.getAttribute("name2")); //セッションで登録された値をvalueへ格納
            }else{//それ以外の場合
                out.print("");//何も表示させない
            }
        %>>
        <br><br>

        生年月日:
        
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <%
                String snum = "";
                if(hs.getAttribute("year2") instanceof String){//セッション"year2"に格納されているのがnullではないとき
                snum = hs.getAttribute("year2").toString();//String変数に値を格納
                }
                if(!(snum.equals(""))){//Stringが""でないなら                    
                    int num = Integer.parseInt(snum); //String変数をintへ変換
                        if(i == num){//iの値がnumの値と同じ時
                        out.print("selected=\"selected\"");//selectedを格納させる
                        }
                }
                                    %> > <%=i%> </option>
            <% } %>
        </select>年
        
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <%
                String snum = "";
                if(hs.getAttribute("month2") instanceof String){ //セッション"month2"に格納されているのがnullではないとき
                snum = hs.getAttribute("month2").toString(); //String変数に値を格納
                }
                if(!(snum.equals(""))){//Stringが""でないなら
                    int num = Integer.parseInt(snum);//String変数をintへ変換
                        if(i == num){//iの値がnumの値と同じ時
                        out.print("selected=\"selected\"");//selectedを格納させる
                        }
                }   
                                     %>><%=i%></option>
            <% } %>
        </select>月
        
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <%
                String snum = "";
                if(hs.getAttribute("day2") instanceof String){//セッション"day2"に格納されているのがnullではないとき
                snum = hs.getAttribute("day2").toString();//String変数に値を格納
                }
                if(!(snum.equals(""))){//Stringが""でないなら
                    int num = Integer.parseInt(snum);//String変数をintへ変換
                        if(i == num){//iの値がnumの値と同じ時
                        out.print("selected=\"selected\"");//selectedを格納させる
                        }
                }   
                    %>><%=i%></option>
            <% } %>
        </select>日
        
        <br><br>

        種別:
        <br>
        
        
        <input type="radio" name="type" value="1" <%
                if(!(hs.getAttribute("type2") instanceof String)){//"type2"がString変数ではないなら
                        out.print("checked");                     //checkedを格納（初期値設定）
                }
                if(hs.getAttribute("type2") instanceof String){   //"type2"がString変数であり
                    if(hs.getAttribute("type2").equals("1")){     //"type2"に格納されている値が"1"ならば、checkedを格納  
                        out.print("checked");
                    }
                }%>>エンジニア<br>
        <input type="radio" name="type" value="2" <%
                if(hs.getAttribute("type2") instanceof String){   //"type2"がString変数であり
                    if(hs.getAttribute("type2").equals("2")){     //"type2"に格納されている値が"2"ならば、checkedを格納
                        out.print("checked");
                    }
                }%>>営業<br>
        <input type="radio" name="type" value="3" <%
                if(hs.getAttribute("type2") instanceof String){   //"type2"がString変数であり
                    if(hs.getAttribute("type2").equals("3")){     //"type2"に格納されている値が"3"ならば、checkedを格納
                        out.print("checked");                     
                    }
                }%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value=<%
                if(hs.getAttribute("tell2") instanceof String){  //"tell2"がString変数ならば
                    out.print(hs.getAttribute("tell2"));         //valueに"tell2"の値を格納
                }else{
                    out.print("");//違うならば、空白を出力
                }
        %>>
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%
                if(hs.getAttribute("comment2") instanceof String){ //"comment2"がString変数ならば    
                    out.print(hs.getAttribute("comment2"));        //valueに"comment2"の値を格納
                }else{
                    out.print("");//違うならば、空白を出力
                }
            %></textarea><br><br>

        <input type="hidden" name="acc"  value=<%= hs.getAttribute("acc")%>><!--アクセスチェック値（セッション）を hiddenの"acc"　に格納-->
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%><!--トップへのリンク-->
        
<%  //insertCongirm.jsp内で指定したセッションの削除、2回目にアクセスした際に消去させる為
session.setAttribute("name2",null);
session.setAttribute("year2",null);
session.setAttribute("month2",null);
session.setAttribute("day2",null);
session.setAttribute("type2",null);
session.setAttribute("tell2",null);
session.setAttribute("comment2",null);
%>        
    </body>
</html>
