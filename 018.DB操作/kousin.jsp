<%-- 
    Document   : kousin
    Created on : 2018/07/03, 11:46:28
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
    
        db_st = db_con.prepareStatement("update profiles set name=? ,tel=? ,age=? ,birthday=? where profilesID=? "); 
        
        String a = request.getParameter("onamae"); //THMLで入力された文字を１番目の?に格納する処理
        db_st.setString(1,a);
        
        String b = request.getParameter("denwa");//THMLで入力された文字を2番目の?に格納する処理
        db_st.setString(2,b);
        
        String c1 = request.getParameter("nenrei");//THMLで入力された文字を3番目の?に格納する処理
        int c2 = Integer.parseInt(c1);
        db_st.setInt(3, c2);
        
        String d = request.getParameter("birth");//THMLで入力された文字を4番目の?に格納する処理
        db_st.setString(4,d);
        
        String e1 = request.getParameter("id");//THMLで入力された文字を5番目の?に格納する処理
        int e2 = Integer.parseInt(e1);
        db_st.setInt(5,e2);
        
        int result = db_st.executeUpdate(); //更新された行を表示させる処理
        out.println(result + "行更新されました。" + "<br>");
        out.println("<br>");
        
        db_st = db_con.prepareStatement("select * from profiles order by profilesID");
        
        db_data = db_st.executeQuery();
        while(db_data.next()){ //すべてのカラムの値を画面に表示する処理
        
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
