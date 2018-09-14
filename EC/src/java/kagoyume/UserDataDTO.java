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
public class UserDataDTO {
    
    private int userID;
    private String name;
    private String pass;
    private String mail;
    private String address;
    private int total;
    private Timestamp newDate;
    private int deleteFlg;
    
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPass(){
        return pass;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public Timestamp getNewDate(){
        return newDate;
    }
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }
    public int getDeleteFlg(){
        return deleteFlg;
    }
    public void setDeleteFlg(int deleteFlg){
        this.deleteFlg = deleteFlg;
    }
    
    
}
