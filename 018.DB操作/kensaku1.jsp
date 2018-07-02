<%-- 
    Document   : kensaku1
    Created on : 2018/07/02, 17:09:24
    Author     : yamadayuushi
--%>
<%@ page import="java.sql.*"%>
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
        
    Connection db_con = null ;
    PreparedStatement db_st = null;
    ResultSet db_data = null ;
    
try{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","yuujiyamada","hamuhuku");
    
        db_st = db_con.prepareStatement("select * from profiles where name like ?");
        String a = request.getParameter("kensaku");//入力フォームで入力された文字を変数aに格納する 
        db_st.setString(1, "%" + a +"%"); //格納された変数aを?に入れる。
    
        db_data = db_st.executeQuery();
    
        while(db_data.next()){//すべてのカラムの値を画面に表示させる
        
            out.println(db_data.getString("profilesID") + " " +  db_data.getString("name") + " " 
                                + db_data.getString("tel") + " " + db_data.getString("age") + " " + db_data.getString("birthday") +"<br>");
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
     
    </body>
</html>
