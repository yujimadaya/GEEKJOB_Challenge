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
public class BlackJack {

    public static void main(String[] arg){
    
        Dealer dealer = new Dealer(); //Dealerクラスをインスタンス化
    
        User user = new User(); //Userクラスをインスタンス化
    
            System.out.println("Dealerにカードを2枚配ります");
    
        dealer.setCard(dealer.deal()); //Dealer側にカードを2枚配る処理
    
            System.out.println("DealerがUserにカードを2枚配ります");
    
        user.setCard(dealer.deal()); //User側にカードを2枚配る処理
    
            System.out.println("-Userのターン-");
            System.out.println("");
        
        
        while(user.checkSum() == true){ //Userの手札の合計値が16以下の時、下記の処理(hit）が行われる処理
    
            System.out.println("Userがhitしました");
            
            user.setCard(dealer.hit()); //User側にカードを1枚配る処理
        
        }
    
        if(user.open() > 21){ //もしUser側の手札の合計値が21より大きくなった場合、Dealerの勝利となる処理
            System.out.println("Userがbustした為、dealerの勝ち");
            System.out.println("");
        }else{
            
            System.out.println("Userがstandしました");
            System.out.println("");
            System.out.println("-Userのターン終了-");
            System.out.println("");
            System.out.println("-Dealerのターン-");
            System.out.println("");
            System.out.println("Dealerがホールカードを開きました");
            System.out.println("");
    
            while(dealer.checkSum() == true){  //Dealer側の合計値が17以上になるまでカードを引き続ける処理（ルールより）
                
            System.out.println("Dealerがカードを1枚引きました");
            
            dealer.setCard(dealer.hit()); //Dealer側にカードを1枚配る処理
        
            }
        
            if(dealer.open() > 21){ //もしDealer側の手札の合計値が21より大きくなった場合、Userの勝利となる処理
                System.out.println("dealerがbustした為、Userの勝ち");
                System.out.println("");
            }else{
        
                System.out.println("-dealerのターン終了-");
                System.out.println("");
                System.out.println("-check-");
                System.out.println("");
                
                if(user.open() > dealer.open() ){ //Userの手札の合計値がDealerの手札の合計値より大きい場合、Userの勝利とする処理
                    System.out.println("Userの手札合計:" + user.open() + "、" + "Dealerの手札合計:" + dealer.open());
                    System.out.println("");
                    System.out.println("Userの勝ち");
                    System.out.println("");
                }else if(user.open() < dealer.open() ){ //Userの手札の合計値がDealerの手札の合計値より小さい場合、Dealerの勝利とする処理
                    System.out.println("Userの手札合計:" + user.open() + "、" + "Dealerの手札合計:" + dealer.open());
                    System.out.println("");
                    System.out.println("Dealerの勝ち");
                    System.out.println("");
                }else{ //Userの手札の合計値がDealerの手札の合計値と同じ場合、引き分けとする処理
                    System.out.println("Userの手札の合計:" + user.open() + "、" + "Dealerの手札合計:" + dealer.open());
                    System.out.println("");
                    System.out.println("引き分け");
                    System.out.println("");
    
                }
            
            }
    
        }
    
        System.out.println("BlackJackを終了します");
        System.out.println("");
        
    }
    
}
