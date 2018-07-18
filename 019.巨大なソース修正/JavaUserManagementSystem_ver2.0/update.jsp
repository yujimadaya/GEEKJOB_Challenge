<%@page import="jums.JumsHelper" 
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="POST">
        名前:
        <input type="text" name="name2" value=<%
               out.print(udd.getName());
               %>>
        <br><br>

        <%String[] hiduke = udd.getBirthday().toString().split("-",0);%>
        
        生年月日:　
        <select name="year2">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <%
                int year2 = Integer.parseInt(hiduke[0]);
                    if(i==year2){
                        out.print("selected = \"selected\"");
                    }    
                    %>><%=i%></option>
            <% } %>
        </select>年
        <select name="month2">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <%
                int month2 = Integer.parseInt(hiduke[1]);
                    if(i==month2){
                        out.print("selected = \"selected\"");
                    }
                    %>><%=i%></option>
            <% } %>
        </select>月
        <select name="day2">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <%
                int day2 = Integer.parseInt(hiduke[2]);    
                    if(i==day2){
                        out.print("selected = \"selected\"");
                    }
                    %>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type2" value="<%=i%>" <%
                if(i==udd.getType()){
                    out.print("checked");
                }  
                    %>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell2" value=<%
               out.print(udd.getTell());
               %>>
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment2" rows=10 cols=50 style="resize:none" wrap="hard"><%
                out.print(udd.getComment());
            %></textarea><br><br>
        
        <input type="submit" name="btnSubmit" value="確認画面へ">
        
            <br><br>
      
    </form>
            <form action="ResultDetail" method="POST">
              <input type="submit" name="NO" value="詳細画面に戻る"style="width:100px">  
            </form>
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
