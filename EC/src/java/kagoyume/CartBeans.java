/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *add.jspで登録した商品コードを利用し、写真や名前などを新たに格納する為のJavaBeans
 *YahooAPI.java、cart.jspで使用
 *ArrayListのitemcodeListに格納された情報をYahooAPIのメソッドに受け渡し、返された情報をitemcode~totalフィールドに追加する。
 * @author yamadayuushi
 */
public class CartBeans implements Serializable{
    private ArrayList<String> itemcodelist;
    private String itemcode;
    private String image;
    private String name;
    private int price;
    private int total;
   
    public CartBeans(){
        this.itemcodelist = new ArrayList<>();
        this.itemcode = "";
        this.image = "";
        this.name = "";
        this.price = 0;
        this.total = 0;
    }
    
    public ArrayList<String> getItemCodeArray(){
        return itemcodelist;
    }
    public String getItemCodeList(int i){
        return this.itemcodelist.get(i);
    }
    public void setItemCodeList(String itemcode){
        this.itemcodelist.add(itemcode);
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
    
    public void setTotal(int total){
        this.total = total;
    }
    
    public int getTotal(){
        return total;
    }

    public void DeleteItemCode(int i){ //指定したアイテム情報を削除
            this.itemcodelist.remove(i);  
    }
 
    public void CartAll(CartBeans cartbeans,CartBeans guest){ //gest用カートで追加したアイテムをログインID用のカートにすべて格納する。
        cartbeans.getItemCodeArray().addAll(guest.getItemCodeArray());
    }
    
}