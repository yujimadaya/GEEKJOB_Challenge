/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author yamadayuushi
 */
public class hyoujyunclass3 {
    
    public static void main(String[] args){
    
        Date kako = new Date(1478221200000L); //タイムスタンプ生成
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //課題の形式
        
        System.out.println(kako.getTime()); //タイムスタンプを表示
        
        System.out.println(sdf.format(kako)); //課題の形式で画面に表示
        
    }
   
}
