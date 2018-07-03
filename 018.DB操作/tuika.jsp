<%-- 
    Document   : tuika
    Created on : 2018/07/02, 17:57:22
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
    
            db_st = db_con.prepareStatement("insert into profiles (profilesID,name,tel,age,birthday) values (?,?,?,?,?) ");
        
        String a1 = request.getParameter("id"); //HTMLで入力した文字を格納
        int a2 = Integer.parseInt(a1); //文字列をint変数に変換
            db_st.setInt(1, a2);
        
        String b = request.getParameter("onamae");   //HTMLで入力した文字を格納
            db_st.setString(2, b);
            
        String c = request.getParameter("denwa");    //HTMLで入力した文字を格納
            db_st.setString(3,c);
            
        String d1 = request.getParameter("nenrei"); //HTMLで入力した文字を格納
        int d2 = Integer.parseInt(d1);
            db_st.setInt(4,d2);
            
        String e = request.getParameter("birth"); //HTMLで入力した文字を格納
            db_st.setString(5,e); 
    
        int result = db_st.executeUpdate(); //変更された行数を表示させる処理

        out.println(result + "行追加されました。" + "<br>");
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
