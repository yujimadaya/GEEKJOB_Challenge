/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author yamadayuushi
 */
public class hyoujyunclass_log { //2.処理を開始する旨と、その時間（課題を開始した時刻をlog.txtに記録してあります）
    
    public static void main(String[] args){
    
        Date now =new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("処理を開始しました yyyy-MM-dd HH:mm 開始");
        
        String start = sdf.format(now); //現在時刻をstartに格納
        
        try{
        
        File ff = new File("log.txt");
        
        FileWriter fw = new FileWriter(ff); //FileWriter作成
        
        fw.write(start); //開始時刻を格納
        
        fw.close();
        
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
}
