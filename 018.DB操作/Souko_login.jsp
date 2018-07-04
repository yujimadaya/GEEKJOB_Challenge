<%-- 
    Document   : Souko_login
    Created on : 2018/07/03, 14:23:30
    Author     : yamadayuushi
--%>

<!--
Souko_top.jspで入力されたID、Passwordがデータベースに格納されているID,Passwordと一致しているかどうかを確認するためのページ
合致していた場合は分岐処理によってSouko_loginpage.jspへと移動する。
合致しなかった場合は分岐処理によってSouko_error.jspへと移動する。
-->

<%@page session="true" %>
<%@ page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
<%
request.setCharacterEncoding("UTF-8");
        
    Connection db_con = null ;
    PreparedStatement db_st = null;
    ResultSet db_data = null ;

try{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","yuujiyamada","hamuhuku");
    
        db_st = db_con.prepareStatement("select * from users where ID = ? and password = ?"); //IDとパスワードが合致しているレコードを取り出す処理
        
        String a = request.getParameter("id"); //1番目の?に入力された文字を格納する
        db_st.setString(1,a);
        
        String b = request.getParameter("pass");//2番目の?に入力された文字を格納する
        db_st.setString(2,b);
        
        db_data = db_st.executeQuery();
        
        String c = "";//String cに空を格納
        String d = "";//String dに空を格納
        
        while(db_data.next()){//すべてのカラムの値を画面に表示させる
        
        c = db_data.getString("id"); //変数cにデータベースに保存されている"id"の文字を格納
        d = db_data.getString("password"); //変数dにデータベースに保存されている"password"の文字を格納
            
        }
        
        boolean A; //boolean変数Aを作成
        
        if(a!="" && b!="" && a.equals(c) && b.equals(d)){//変数a,bが空でなく　且つ　変数aとc 及び　変数bとd　が同じ時
            A = true;                                    //trueを変数Aに格納
        }else{                                           //違った場合
            A = false;                                   //falseを変数Aに格納
        }
        
        HttpSession hs = request.getSession(); //セッションを呼び出す
        
        hs.setAttribute("taf",A); // "taf"　にboolean変数Aをセットする。
        
        db_st.close();
        db_con.close();
        db_data.close();
        
    
    }catch(SQLException e_sql){
        out.println("接続時にエラーが発生しました:" + e_sql.toString());
    }catch(Exception e){
        out.println("接続時にエラーが発生しました:" + e.toString());
    } finally{
        if(db_con != null)
            try{
                
                db_con.close();
                db_st.close();
                db_data.close();
                
            }catch(Exception e_con){
                out.println(e_con.getMessage());
            }


    }


%>

<%
    HttpSession hs = request.getSession();//セッションを呼び出す。

    Boolean tof = (Boolean)hs.getAttribute("taf"); //Sessionで登録したboolean変数をboolean変数tofに格納する。

    if(tof){//移動先を分岐させる

%><jsp:forward page="./Souko_loginpage.jsp" /><%//IDとパスワードが合致した場合、ログインページに移動する
    }else{
%><jsp:forward page="./Souko_error.jsp" /><%//IDとパスワードが合致しなかった場合、エラーページへ移動する。
}
%>
    
    </body>
</html>
