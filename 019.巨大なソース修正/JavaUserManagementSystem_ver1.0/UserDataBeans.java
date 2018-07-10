/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
/**
 *
 * @author yamadayuushi
 */
public class UserDataBeans implements Serializable{
    
    private String a; //name
    private int b; //year
    private int c; //month
    private int d; //day
    private int e; //type
    private String f; //tell
    private String g; //comment
    
    public UserDataBeans(){}; //コンストラクト
    
    public static UserDataBeans getInstance(){
        return new UserDataBeans();
    }
    
    public String getA(){return a;}
    
    public void setA(String a){this.a = a;}
    
    public int getB(){return b;}
    
    public void setB(int b){this.b = b;}
    
    public int getC(){return c;}
    
    public void setC(int c){this.c = c;}
    
    public int getD(){return d;}
    
    public void setD(int d){this.d = d;}
    
    public int getE(){return e;}
    
    public void setE(int e){this.e = e;}
    
    public String getF(){return f;}
    
    public void setF(String f){this.f = f;}
    
    public String getG(){return g;}
    
    public void setG(String g){this.g = g;}
    
    
    public boolean minyu(){//フィールドすべてに値が格納されているのかのチェック
    
        if(a.equals("") || b == 0 || c == 0 || d == 0 || e == 0 || f.equals("") || g.equals("")){
            return false;
        }else{}
            return true;
    }
    
    
    
}
