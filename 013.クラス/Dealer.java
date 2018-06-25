/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author yamadayuushi
 */
public class Dealer extends Human {
   
    public int open(){ //手札の合計値を計算するメソッド
    
        int motihuda = 0; //int変数 motihuda を初期化
            
        for(int i = 0 ; i < myCards.size()  ; i++ ){ //現在の手札の合計値を計算していく(myCards.size() = 現在の手札枚数、枚数分だけ数える処理)
    
            motihuda = motihuda +myCards.get(i); //手札の枚数分、変数motihudaに手札の数字の値を追加していく
            
        }
            return motihuda; //手札の合計値を変数motihudaで返却する
    }

    public void setCard(ArrayList al){ //山札から引いたカードを手札に追加するメソッド
        
        myCards.addAll(al); //山札から引いたカードの値をmyCardsに格納する
        
        System.out.println("Dealerの手札合計:" + open());
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

    

    protected ArrayList<Integer> cards = new ArrayList<Integer>(); //山札のフィールド
        
        

    public Dealer(){ //コンストラクタ

        
        int b = 1;
            
            for(int i = 1 ; i <= 13 ; i++){ //Dealerの中に山札52枚を追加する処理
        
            if(i > 10){                     //11~13のカードは10としてcardsに加える。（ルールより）
                cards.add(10);
            }else{ 
                cards.add(i);               //1~10までのカードはそのままcardsに加える
            } 
                if(b < 4 && i == 13 ){      //この処理を4回繰り返す(4(絵柄) ×　13(枚) = 52(枚）)
                b++; i=0;
                }
        
            } 
            
        System.out.println("BlackJackを開始します");
        System.out.println("");
            
}    

    public ArrayList<Integer> deal(){ //山札からカードを2枚引き、引いた値を戻り値とするメソッド
    
    Random rand = new Random(); 
    
    int index1 = rand.nextInt(cards.size()); //cardsの要素数の中からランダムに配列番号を選ぶ
    int a =cards.get(index1);                //変数aに山札からランダムに選ばれた数字の値を格納する。(cardsから配列番号(index1)の値を取り出す。)
    cards.remove(index1);                    //引かれたカードを山札から削除する
    int index2 = rand.nextInt(cards.size()); //cardsの要素数の中からランダムに配列番号を選ぶ
    int b =cards.get(index2);                //変数bに山札からランダムに選ばれた数字の値を格納する。(cardsから配列番号(index2)の値を取り出す。)
    cards.remove(index2);                    //引かれたカードを山札から削除する
    
    System.out.println("配られたカードは" + a + "と" + b + "です");
    
    ArrayList<Integer> hutatu = new ArrayList<Integer>(); //ArrayListの変数hutatuに上記の変数a,bの値を格納させる
   
    hutatu.add(a);
    hutatu.add(b);
    
    return hutatu; //変数hutatuを返却する
    
    }
    
    public ArrayList<Integer> hit(){ //山札からカードを1枚引き、引いた値を戻り値とするメソッド
    
    Random rand = new Random();
    
    int index3 = rand.nextInt(cards.size()); //cardsの要素数の中からランダムに配列番号を選ぶ
    int c = cards.get(index3);               //変数cに山札からランダムに選ばれた数字の値を格納する。(cardsから配列番号(index3)の値を取り出す。)
    cards.remove(index3);                    //引かれたカードを山札から削除する
    
    System.out.println("配られたカードは" + c + "です");
    
    ArrayList<Integer> hitotu = new ArrayList<Integer>(); //ArrayListの変数hitotuに上記の変数cの値を格納させる
    
    hitotu.add(c);
    
    return hitotu; //変数hitotuを返却する
    
    }
    
}
    
