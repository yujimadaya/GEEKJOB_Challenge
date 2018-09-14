/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author yamadayuushi
 */
public class UserDataDAO {
    
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    public void insert(UserDataDTO userdataDTO) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name,password,mail,address,total,newDate,deleteFlg) VALUES(?,?,?,?,?,?,?)"); //ConnectionのprepareStatementメソッドにSQL文を渡す
            st.setString(1,userdataDTO.getName());                          //1番目の?に情報を追加
            st.setString(2,userdataDTO.getPass());                          //2番目の?に情報を追加
            st.setString(3,userdataDTO.getMail());                          //3番目の?に情報を追加
            st.setString(4,userdataDTO.getAddress());                       //4番目の?に情報を追加
            st.setInt(5,0);                                                 //5番目の?に情報を追加
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));  //6番目の?に情報を追加
            st.setInt(7, 0);                                                //7番目の?に情報を追加
            st.executeUpdate();                                             //前処理済みのSQL文を実行し，更新行数を返却
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public void updata(UserDataDTO userdataDTO) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("UPDATE user_t SET name=?,password=?,mail=?,address=?,total=?,newDate=? where userID=?"); //ConnectionのprepareStatementメソッドにSQL文を渡す
            st.setString(1,userdataDTO.getName());                          //1番目の?に情報を追加
            st.setString(2,userdataDTO.getPass());                          //2番目の?に情報を追加
            st.setString(3,userdataDTO.getMail());                          //3番目の?に情報を追加
            st.setString(4,userdataDTO.getAddress());                       //4番目の?に情報を追加
            st.setInt(5, userdataDTO.getTotal());                           //5番目の?に情報を追加
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));  //6番目の?に情報を追加
            st.setInt(7, userdataDTO.getUserID());                          //7番目の?に情報を追加
            st.executeUpdate();                                             //前処理済みのSQL文を実行し，更新行数を返却
            System.out.println("updata completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public void delete(UserDataDTO userdataDTO) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("UPDATE user_t SET deleteFlg=? where userID=?"); //ConnectionのprepareStatementメソッドにSQL文を渡す
            st.setString(1,"1");                        //1番目の?に情報を追加
            st.setInt(2,userdataDTO.getUserID());       //2番目の?に情報を追加
            st.executeUpdate();                         //前処理済みのSQL文を実行し，更新行数を返却
            System.out.println("delete completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public UserDataDTO logincheck(UserDataDTO userdataDTO) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
        
        st = con.prepareStatement("SELECT * FROM user_t WHERE mail = ? and password = ?"); //ConnectionのprepareStatementメソッドにSQL文を渡す
        
        st.setString(1, userdataDTO.getMail()); //1番目の?に情報を追加
        st.setString(2, userdataDTO.getPass()); //2番目の?に情報を追加
        ResultSet rs = st.executeQuery();       //実行結果をResultSetとして返却
        
        boolean number =rs.next();
        UserDataDTO set_userdataDTO = new UserDataDTO();
        if(number){
        set_userdataDTO.setUserID(rs.getInt(1));
        set_userdataDTO.setName(rs.getString(2));
        set_userdataDTO.setPass(rs.getString(3));
        set_userdataDTO.setMail(rs.getString(4));
        set_userdataDTO.setAddress(rs.getString(5));
        set_userdataDTO.setTotal(rs.getInt(6));
        set_userdataDTO.setNewDate(rs.getTimestamp(7));
        set_userdataDTO.setDeleteFlg(rs.getInt(8));
        }
        return set_userdataDTO;
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        
        }
    
    }
    
    public void Cartbuy(ArrayList<BuyDTO> buyDTOArray) throws SQLException{ //商品購入用INSERT
        Connection con = null;
        PreparedStatement st = null; 
        try{
            con = DBManager.getConnection();
            for(int i=0;i<buyDTOArray.size();i++){
            st = con.prepareStatement("INSERT INTO buy_t(userID,itemCode,type,buyDate) VALUES(?,?,?,?)"); //ConnectionのprepareStatementメソッドにSQL文を渡す
            st.setInt(1,buyDTOArray.get(0).getUserID());                    //1番目の?に情報を追加
            st.setString(2,buyDTOArray.get(i).getItemCode());               //2番目の?に情報を追加 
            st.setInt(3,buyDTOArray.get(0).getType());                      //3番目の?に情報を追加
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));  //4番目の?に情報を追加
            st.executeUpdate();                                             //前処理済みのSQL文を実行し，更新行数を返却
            }
            System.out.println("cartbuy completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        
        }
    
    }
    
    public ArrayList<MyHistoryDTO> HistorySearch(MyHistoryDTO myhistoryDTO) throws SQLException{ //購入履歴データ所得
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
        
        st = con.prepareStatement("SELECT * FROM buy_t WHERE userID=?");
        st.setInt(1, myhistoryDTO.getUserID());
         
        ArrayList<MyHistoryDTO> history = new ArrayList(); 
        
        ResultSet rs = st.executeQuery(); //実行結果をResultSetとして返却
        while(rs.next()){  
            MyHistoryDTO myhistoryDTO2 = new MyHistoryDTO();
            myhistoryDTO2.setBuyID(rs.getInt(1));
            myhistoryDTO2.setUserID(rs.getInt(2));
            myhistoryDTO2.setItemCode(rs.getString(3));
            myhistoryDTO2.setType(rs.getInt(4));
            myhistoryDTO2.setBuyDate(rs.getTimestamp(5));
            history.add(myhistoryDTO2);
        }

        return history;
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }

}