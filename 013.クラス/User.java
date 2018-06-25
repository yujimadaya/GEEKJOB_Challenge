/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.util.ArrayList;

/**
 *
 * @author yamadayuushi
 */
public class User extends Human {
    
    public int open(){ //手札の合計値を計算するメソッド
    
    int motihuda = 0; //int変数 motihuda を初期化
            
            for(int i = 0 ; i < myCards.size() ; i++ ){  //現在の手札の合計値を計算していく(myCards.size() = 現在の手札枚数、枚数分だけ数える処理)
    
            motihuda = motihuda + myCards.get(i); //手札の枚数分、変数motihudaに手札の数字の値を追加していく
            
            }
            return motihuda; //手札の合計値を変数motihudaで返却する
    }

    public void setCard(ArrayList al){ //山札から引いたカードを手札に追加するメソッド
        
        myCards.addAll(al); //山札から引いたカードの値をmyCardsに格納する
        
        System.out.println("Userの手札合計:" + open());
        System.out.println("");
        
        }
    
    public boolean checkSum(){ //まだカードを引くか判断するメソッド
        
        int a = open(); 
        
            if(a < 17 && a < 21){ //手札の合計値が16以下の時、trueを送る
                return true;
            }else{                //手札の合計値が17以上の時、falseを送る
                return false;
            }    
            
        }

}
