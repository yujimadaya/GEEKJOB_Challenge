/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.io.*;

/**
 *
 * @author yamadayuushi
 */
public class hyoujyunclass_log3 { //1.処理の内容（mathのmaxについて調べました）
    
    public static void main(String[] args){
    
        try{
            
            File fp = new File("logtext.txt"); //ファイルオープン
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(fp)); //改行させる為、BufferedWriterを使用する。
          
            
            bw.write("Mathクラスについて"); //1行目 (Mathクラスのmaxについて下記にまとめました。）
            bw.newLine(); 
            bw.write(""); //2行目
            bw.newLine(); 
            bw.write("どちらか大きい値を所得するmax"); //3行目
            bw.newLine(); 
            bw.write(""); //4行目
            bw.newLine(); 
            bw.write("int a = 5"); //5行目
            bw.newLine(); 
            bw.write("int b = 10"); //6行目
            bw.newLine(); 
            bw.write(""); //7行目
            bw.newLine(); 
            bw.write("int max_num =Math.max(a,b);"); //8行目
            bw.newLine(); 
            bw.write("大きい値の変数b(10)が変数max_numへ格納される"); //9行目
            bw.newLine(); 
            bw.write(""); //10行目
            bw.newLine(); 
            
            bw.close(); //ファイルのクローズ
            
            }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
}
