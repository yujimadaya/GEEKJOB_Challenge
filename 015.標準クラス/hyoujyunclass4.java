/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.util.Date;

/**
 *
 * @author yamadayuushi
 */
public class hyoujyunclass4 {

    public static void main(String[] args){
    
    Date nenmatu = new Date(1451573999000L); //変数nenmatu = 2015年12月31日 23時59分59秒　タイムスタンプ生成
    
    Date nenshi = new Date(1420038000000L); //変数 nenshi = 2015年1月1日 0時0分0秒 タイムスタンプ生成
    
    
    System.out.println(nenmatu); //2015年12月31日 23時59分59秒を表示
    
    System.out.println(nenshi); //2015年1月1日 0時0分0秒を表示
    
    System.out.println(nenmatu.getTime() - nenshi.getTime()); //変数nenmatuから変数nenshiを引いた差のタイムスタンプを表示
    
    
    }
    
}
