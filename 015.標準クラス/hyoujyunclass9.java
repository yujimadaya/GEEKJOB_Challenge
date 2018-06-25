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
public class hyoujyunclass9 {
    
    public static void main(String[] args){
    
        try{
            
            File fp = new File("test.txt"); //ファイルオープン
            
            FileReader fr = new FileReader(fp); //FileReader作成
            BufferedReader br = new BufferedReader(fr); //BufferedReader作成
            
            System.out.println(br.readLine()); //1行目呼び出し
            System.out.println(br.readLine()); //2行目呼び出し
            System.out.println(br.readLine()); //3行目呼び出し
            System.out.println(br.readLine()); //4行目呼び出し
            System.out.println(br.readLine()); //5行目呼び出し
            
            fr.close();//ファイルのクローズ
            
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
} 
