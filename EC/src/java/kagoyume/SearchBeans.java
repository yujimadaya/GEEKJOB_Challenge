/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;

/**
 *検索ワードを元に、検索情報を格納する為のJavaBeans
 *Search.java、Search.jspで使用 
 * @author yamadayuushi
 */
public class SearchBeans implements Serializable{
    private String word;
    private int hit;
    private String name;
    private int price;
    private String itemcode;
    private String image;

public SearchBeans(){
    this.word = "";
    this.hit = 0;
    this.name="";
    this.price=0;
    this.itemcode="";
    this.image="";
}

public void setWord(String word){
    this.word = word;
}

public String getWord(){
    return word;
}

public int getHit(){
    return hit;
}

public void setHit(int hit){
    this.hit = hit;
}

public void setName(String name){
    this.name = name;
}
public String getName(){
    return name;
}

public void serPrice(int price){
    this.price = price;
}

public int getPrice(){
    return price;
}

public void setItemCode(String itemcode){
    this.itemcode= itemcode;
}

public String getItemCode(){
    return itemcode;
}

public void setImage(String image){
    this.image= image;
}

public String getImage(){
    return image;
}

}
