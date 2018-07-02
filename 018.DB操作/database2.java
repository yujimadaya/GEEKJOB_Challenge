/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.sql.*;
/**
 *
 * @author yamadayuushi
 */
public class database2 {
    public static void main(String[] args){
    
    Connection db_con = null ;
    PreparedStatement db_st = null;
    ResultSet db_data = null ;
    
try{
    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","yuujiyamada","hamuhuku");
    
    db_st = db_con.prepareStatement("insert into profiles (profilesID,name,tel,age,birthday) values (?,?,?,?,?) ");
    db_st.setInt(1, 6);
    db_st.setString(2, "阿部 寛");
    db_st.setString(3,"0120-441-222");
    db_st.setInt(4, 54);
    db_st.setString(5,"1964-06-22" ); 
    
    int result = db_st.executeUpdate();
    System.out.println(result + "行が追加されました。");
    
    db_st.close();
    db_con.close();
    
}catch(SQLException e_sql){
    System.out.println("接続時にエラーが発生しました:" + e_sql.toString());
}catch(Exception e){
    System.out.println("接続時にエラーが発生しました:" + e.toString());
} finally{
    if(db_con != null)
        try{
            db_data.close();
            db_con.close();
            db_st.close();
        }catch(Exception e_con){
            System.out.println(e_con.getMessage());
        }


}



}
}

