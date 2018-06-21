
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

/**
 *
 * @author yamadayuushi
 */

class Japan {
    
    public String moji = ""; //1つめのフィールド
    public String moji2 = "";//2つめのフィールド
    
    public void setJapan(String a,String b){ //メソッド①引数として受け取った2つの変数を、フィールドに格納する
        this.moji = a; //mojiにaで入力された物を格納
        this.moji2 = b; //moji2にbで入力された物を格納
        
    }
    
    public void JPN(){ //メソッド②２つのフィールドの値をそれぞれ画面に表示する
          
    System.out.println(moji); //mojiに格納されている変数を表示する
    System.out.println(moji2); //moji2に格納されている変数を表示する
        
    }
    
}
    

public class class1{

public static void main(String[] arg){

    Japan tokyo = new Japan(); //Japanクラスのインスタンスを生成する
    
    tokyo.setJapan("北海道", "沖縄"); //setJapanメソッドを呼び出し、(a,b)にそれぞれの文字を格納させる。
    
    tokyo.JPN();//JPNメソッドを呼び出しmojiとmoji2に格納されている変数を表示させる。
    


    }

    
}

