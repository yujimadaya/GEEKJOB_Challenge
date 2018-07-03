<%-- 
    Document   : sakujyo
    Created on : 2018/07/03, 11:08:24
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
    
            db_st = db_con.prepareStatement("delete from profiles where profilesID = ?");
            
            String a1 = request.getParameter("sakujyo"); //"sakujyo"に入力された数字を?に代入し,そのID番号のレコードを削除させる。
            int a2 = Integer.parseInt(a1);
            db_st.setInt(1,a2);
            
            
            
            int result = db_st.executeUpdate(); //変更された行数を表示させる処理

        out.println(result + "行削除されました。" + "<br>");
        out.println("<br>");
        
        db_st = db_con.prepareStatement("select * from profiles order by profilesID"); //profilesIDを昇順にして全レコードの全カラムを表示
    
        db_data = db_st.executeQuery();
    
        while(db_data.next()){
        
            out.println(db_data.getString("profilesID") + " " +  db_data.getString("name") + " " 
                                + db_data.getString("tel") + " " + db_data.getString("age") + " " + db_data.getString("birthday") + "<br>");
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
    </body>
</html>
