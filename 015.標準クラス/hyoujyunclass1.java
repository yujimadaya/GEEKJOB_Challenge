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

class hyoujyunclass1 {

    public static void main(String[] args) throws Exception {

    Date someday = new Date(1451574000000L);
    
    System.out.println(someday); //日付を表示

    System.out.println(someday.getTime()); //タイムスタンプ表示

    }
}
