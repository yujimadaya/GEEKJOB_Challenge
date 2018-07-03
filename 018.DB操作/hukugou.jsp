<%-- 
    Document   : hukugou
    Created on : 2018/07/03, 13:02:00
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
    
        db_st = db_con.prepareStatement("select * from profiles where name = ? or age=? or birthday=? "); //orを使い　いずれかの条件が満たしているレコードを表示させる
        
        String a = request.getParameter("namae");//HTMLで入力された文字を1番目の?に入力
        db_st.setString(1,a);
        
        String b1 = request.getParameter("tosi");//HTMLで入力された文字を2番目の?に入力
        int b2 = 0; //何も入力されなかった場合は0を入力させる処理
        if(!(b1.equals(""))){//もし変数b1が""(何も入力されていない状態)でないのなら
        b2 = Integer.parseInt(b1); //b1をintに変換して変数b2に格納する。
        }
        db_st.setInt(2, b2);
        
        String c = request.getParameter("tan");//HTMLで入力された文字を3番目の?に入力
        db_st.setString(3,c);
        
        db_data = db_st.executeQuery();
        while(db_data.next()){ //条件を満たしたレコードを表示させる処理
        
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
