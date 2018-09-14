/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.sql.Timestamp;

/**
 *
 * @author yamadayuushi
 */
public class MyHistoryDTO {
    private int buyID;
    private int userID;
    private String itemCode;
    private int type;
    private Timestamp buyDate;
    
    public int getBuyID(){
        return this.buyID;
    }
    public void setBuyID(int buyID){
        this.buyID = buyID;
    }
    public int getUserID(){
        return this.userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    public String getItemCode(){
        return this.itemCode;
    }
    public void setItemCode(String itemCode){
        this.itemCode = itemCode;
    }
    public int getType(){
        return this.type;
    }
    public void setType(int type){
        this.type = type;
    }
    public Timestamp getBuyDate(){
        return this.buyDate;
    }
    public void setBuyDate(Timestamp buyDate){
        this.buyDate = buyDate;
    }
    
}
