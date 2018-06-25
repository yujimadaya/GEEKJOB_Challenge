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
public class hyoujyunclass8 {
    
    public static void main(String[] args){
    
        try{
            
            File fp = new File("test.txt");
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(fp));
          
            
            bw.write("自己紹介");
            bw.newLine();
            bw.write("名前:山田侑司");
            bw.newLine();
            bw.write("年齢:24歳");
            bw.newLine();
            bw.write("趣味:山登り、読書");
            bw.newLine();
            bw.write("よろしくお願いいたします");
            
            bw.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
}
    

