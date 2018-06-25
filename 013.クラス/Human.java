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
    abstract public class Human {

    protected ArrayList<Integer> myCards = new ArrayList<Integer>();

        abstract public int open(); //手札の合計値を計算するメソッド
    
        abstract public void setCard(ArrayList al); //山札から引いたカードを手札に追加するメソッド
        
        abstract public boolean checkSum(); //まだカードを引くか判断するメソッド
               
}
        
        
        































    

