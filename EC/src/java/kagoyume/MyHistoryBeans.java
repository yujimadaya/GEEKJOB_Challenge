/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * mySQLに登録されているitemcodeを利用し、YahooAPIとUserDataDAOから受け取った情報を格納する為のJavaBeans
 * MyHistory.java、myhistory.jspで使用
 * @author yamadayuushi
 */
public class MyHistoryBeans implements Serializable{
    private String name;
    private int price;
    private String image;
    private int type;
    private Timestamp buyDate;
    
    public MyHistoryBeans(){
    this.name="";
    this.price =0;
    this.image="";
    this.type=0;
    this.buyDate=new Timestamp(System.currentTimeMillis());
    }   

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }  

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
    
    public void setImage(String image){
        this.image= image;
    }

    public String getImage(){
        return image;
    }
    
    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }
    
    public void setBuyDate(Timestamp buyDate){
        this.buyDate = buyDate;
    }

    public Timestamp getBuyDate(){
        return buyDate;
    }
    
}

