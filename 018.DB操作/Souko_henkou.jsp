<%-- 
    Document   : Souko_henkou
    Created on : 2018/07/03, 17:42:04
    Author     : yamadayuushi
--%>

<<!-- 在庫の中身を変更させるページです。-->

<%@ page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>変更しました</title>
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
    
                db_st = db_con.prepareStatement("update zaiko set name=? ,num=?  where ID= ?");//IDを選択し、中身を変更させる処理
            
                String a = request.getParameter("name"); //1番目の?に"name"で入力された文字を格納
                    db_st.setString(1, a);
        
                String b1 = request.getParameter("kosu");//2番目の?に"kosu"で入力された文字を格納
                    int b2 = Integer.parseInt(b1);
                        db_st.setInt(2, b2);
            
                String c1 = request.getParameter("id"); //3番目の?に"id"で入力された文字を格納
                    int c2 = Integer.parseInt(c1);
                        db_st.setInt(3,c2);
            
                int result = db_st.executeUpdate();

                out.println("変更しました！" + "<br>");
        
                out.println("<br>");
        
                db_st = db_con.prepareStatement("select * from zaiko order by ID"); //IDを昇順にして全レコードの全カラム情報を表示
    
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
%>            
        <br><center><form action="./Souko_loginpage.jsp" method="get">
        <input type="submit" name="btnSubmit" value="戻る"> 
        </form></center>  
    </body>
</html>
