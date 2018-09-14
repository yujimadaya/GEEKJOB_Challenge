/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;


/**
 *Search.jspから送られてきた商品コードを利用し、概要や評価などを含めた商品情報を再度受け取るためのJavaBeans
 * Item.java、Item.jspで使用
 * @author yamadayuushi
 */
public class ItemBeans implements Serializable{
    private String name;
    private int price;
    private String itemcode;
    private String overview;
    private String rate;
    private String image;
    
public ItemBeans(){
    this.name = "";
    this.price = 0;
    this.itemcode = "";
    this.overview = "";
    this.rate = "";
    this.image = "";
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

public void setItemCode(String itemcode){
    this.itemcode = itemcode;
}

public String getItemCode(){
    return itemcode;    
}

public void setOverview(String overview){
    this.overview = overview;
}

public String getOverview(){
    return overview;    
}
    
public void setRate(String rate){
    this.rate = rate;
}

public String getRate(){
    return rate;    
}    

public void setImage(String image){
    this.image = image;
}    
    
public String getImage(){
    return image;
}    
        
}
