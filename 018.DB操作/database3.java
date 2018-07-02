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
public class database3 {
    
    public static void main(String[] args){
    
        Connection db_con = null ;
        PreparedStatement db_st = null;
        ResultSet db_data = null ;
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","yuujiyamada","hamuhuku");
    
        db_st = db_con.prepareStatement("select * from profiles");
    
        db_data = db_st.executeQuery();
    
        while(db_data.next()){
        
            System.out.println(db_data.getString("profilesID") + " " +  db_data.getString("name") + " " 
                                + db_data.getString("tel") + " " + db_data.getString("age") + " " + db_data.getString("birthday"));
        }
    
    
        db_st.close();
        db_con.close();
        db_data.close();
    
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
