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
public class database1 {
    public static void main(String[] args){
    
    Connection db_con = null ;
    PreparedStatement db_st = null;
    ResultSet db_data = null ;
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","yuujiyamada","hamuhuku");
        db_con.close();

    }catch(SQLException e_sql){
        System.out.println("接続時にエラーが発生しました:" + e_sql.toString());
    }catch(Exception e){
        System.out.println("接続時にエラーが発生しました:" + e.toString());
    } finally{
        if(db_con != null)
            try{
                db_con.close();
            }catch(Exception e_con){
                System.out.println(e_con.getMessage());
            }

    }

    }
}
