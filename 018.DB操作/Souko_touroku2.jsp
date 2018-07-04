<%-- 
    Document   : Souko_touroku2
    Created on : 2018/07/03, 17:41:52
    Author     : yamadayuushi
--%>

<!-- 在庫情報を登録する為のページです -->

<%@ page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録しました</title>
    </head>
    <body>
<center><%

request.setCharacterEncoding("UTF-8");
            
        Connection db_con = null ;
        PreparedStatement db_st = null;
        ResultSet db_data = null ;
    
            try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","yuujiyamada","hamuhuku");
    
            db_st = db_con.prepareStatement("insert into zaiko (ID,name,num) values (?,?,?) ");//テーブルzaikoの中に入力された項目を格納する処理
        
        String a1 = request.getParameter("id"); //1番目の?に入力された文字を格納する。
        int a2 = Integer.parseInt(a1); 
            db_st.setInt(1, a2);
        
        String b = request.getParameter("name");//2番目の?に入力された文字を格納する。   
            db_st.setString(2, b);
            
        String c1 = request.getParameter("kosu"); //3番目の?に入力された文字を格納する。
        int c2 = Integer.parseInt(c1);
            db_st.setInt(3,c2);
            
        int result = db_st.executeUpdate();

        out.println("登録しました！" + "<br>");
        
        out.println("<br>");
        
        db_st = db_con.prepareStatement("select * from zaiko order by ID"); //IDを昇順にして全レコードの全カラムを表示
    
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
            
                    db_con.close();
                    db_st.close();
                    db_data.close();
                    
                }catch(Exception e_con){
                    out.println(e_con.getMessage());
                }


        }

%></center>       
        <br><center><form action="./Souko_loginpage.jsp" method="get">
        <input type="submit" name="btnSubmit" value="戻る"> 
        </form></center>  
    </body>
</html>
