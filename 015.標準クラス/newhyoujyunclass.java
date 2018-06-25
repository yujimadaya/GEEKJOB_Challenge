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
public class newhyoujyunclass { //ログファイル
    
    public static void main(String[] args){
    
        try{
            
            File text1 = new File("logtext.txt"); //処理の内容を保存したlogtext.txtを開く
            
            FileReader text2 = new FileReader(text1); //FileReader作成
            BufferedReader text3 = new BufferedReader(text2); //BufferedReader作成
            
            System.out.println(text3.readLine()); //1行目を表示
            System.out.println(text3.readLine()); //2行目を表示
            System.out.println(text3.readLine()); //3行目を表示
            System.out.println(text3.readLine()); //4行目を表示
            System.out.println(text3.readLine()); //5行目を表示
            System.out.println(text3.readLine()); //6行目を表示
            System.out.println(text3.readLine()); //7行目を表示
            System.out.println(text3.readLine()); //8行目を表示
            System.out.println(text3.readLine()); //9行目を表示
            System.out.println(text3.readLine()); //10行目を表示
            
            File fp = new File("log.txt"); //開始時刻を保存したlog.txtを開く
            
            FileReader fr = new FileReader(fp); //FileReader作成
            BufferedReader br = new BufferedReader(fr); //BufferedReader作成
            
            System.out.println(br.readLine()); //1行目を表示
            
            fr.close();//ファイルのクローズ
            
            File fa = new File("logend.txt"); //終了時刻を保存したlogend.txtを開く
            
            FileReader fb = new FileReader(fa); //FileReader作成
            BufferedReader bc = new BufferedReader(fb); //BufferedReader作成
            
            System.out.println(bc.readLine()); //1行目呼び出し
            
            fr.close();//ファイルのクローズ
            
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
}
