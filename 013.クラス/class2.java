/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

class America extends Japan{ //クラスAmericaに、クラスJapanを継承させる

    public void Clear(){ //Humanクラスのフィールド mojiとmoji2をクリアさせる処理
        moji  = "";
        moji2 = "";
    }


}







/**
 *
 * @author yamadayuushi
 */
public class class2 {
    
    public static void main(String[] arg){
    
    America washi = new America(); //Americaクラスのインスタンスを生成する


    washi.setJapan("愛知","福岡"); //継承したJapanクラス内のsetJapanメソッドを呼び出し、(a,b)にそれぞれの文字を格納させる。
    
    washi.JPN(); //継承したJapanクラス内のJPNメソッドを呼び出し上記で入力された文字を表示させる
    
    washi.Clear(); //Clearメソッドを呼び出し、setJapanメソッドで入力された文字をクリアさせる
    
    washi.JPN(); //継承したJapanクラス内のJPNメソッドを呼び出し上記で入力された文字を表示させる


    }
}
