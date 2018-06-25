/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author yamadayuushi
 */
public class hyoujyunclass2 {
    
    public static void main(String[] args){

    Date now = new Date();
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
    
    String dateString = sdf.format(now);
    System.out.println(dateString);
        
    }
}
