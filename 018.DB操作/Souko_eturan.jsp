<%-- 
    Document   : Souko_eturan
    Created on : 2018/07/03, 16:43:58
    Author     : yamadayuushi
--%>

<!--　在庫一覧を表示させるページです -->

<%@ page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫一覧</title>
    </head>
    <body>
        <center><h1>在庫一覧</h1></center>
        <br>
        <br>
        <br>
<%
        
        request.setCharacterEncoding("UTF-8");
        
    Connection db_con = null ;
    PreparedStatement db_st = null;
    ResultSet db_data = null ;
    
try{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","yuujiyamada","hamuhuku");
    
        db_st = db_con.prepareStatement("select * from zaiko order by ID");//IDを昇順にして全カラムの全レコード情報を表示させる処理
        
        db_data = db_st.executeQuery();
       
        while(db_data.next()){
        
            out.println("ID: " + db_data.getString("ID") + "   " + "商品名: " +  db_data.getString("name") + "   " + "個数: " + db_data.getString("num") + "<br>");
            out.println("<br>");
        }

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
                db_data.close();
                db_con.close();
                db_st.close();
            }catch(Exception e_con){
                out.println(e_con.getMessage());
            }


    }

 %>
  <br><center><form action="./Souko_loginpage.jsp" method="get">
        <input type="submit" name="btnSubmit" value="戻る"> 
        </form></center>  
</body>
</html>
