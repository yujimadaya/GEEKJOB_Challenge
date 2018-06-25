/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author yamadayuushi
 */
public class hyoujyunclass_log2 { //3.処理を終了する旨と、その時間（課題が終了した時刻をlogend.txtに記録してあります。）
    
    public static void main(String[] args){
    
        Date now =new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("処理を終了しました yyyy-MM-dd HH:mm 終了"); //課題の型を作成
        
        String end = sdf.format(now); //現在時刻をendに格納
        
        try{
        
        File ff = new File("logend.txt"); 
        
        FileWriter fw = new FileWriter(ff); //FileWriter作成
        
        fw.write(end); //終了時刻を格納
        
        fw.close();
        
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
}
