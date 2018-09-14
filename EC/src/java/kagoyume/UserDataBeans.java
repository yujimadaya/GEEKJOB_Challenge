/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author yamadayuushi
 */
public class UserDataBeans implements Serializable  {
    
    private String name;
    private String pass;
    private String passconfirm;
    private String mail;
    private String address;
    
    public UserDataBeans(){
    this.name="";
    this.pass="";
    this.passconfirm="";
    this.mail="";
    this.address="";
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        if(name.trim().length()==0){
            this.name="";
        }else{
            this.name= name;
        }
    }
        
    public String getPass(){
        return pass;
    }
    
    public void setPass(String pass){
        if(pass.trim().length()==0){
            this.pass="";
        }else{
            this.pass= pass;
        }
    }
    
    public String getPassConfirm(){
        return passconfirm;
    }
    
    public void setPassConfirm(String passconfirm){
        this.passconfirm = passconfirm;
    }
    
    public String getMail(){
        return mail;
    }
       
    public void setMail(String mail){
        if(mail.trim().length()==0){
            this.mail = "";
        }else{
            this.mail = mail;
        }
       
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        if(address.trim().length()==0){
            this.address = "";
        }else{
            this.address = address;
        }
    }
    
    public ArrayList<String> checkfour(){   //入力チェック
        
        ArrayList<String> check = new ArrayList<>();
    
        if(this.name.equals("")){
            check.add("name");
        }
        if(!this.name.equals("")&&this.name.length() < 4 || this.name.length() > 20){
            check.add("name2");
        }
        if(this.pass.equals("")){
            check.add("pass");
        }
        if(!this.pass.equals("")&&this.pass.length() < 6 || this.pass.length() > 20){
            check.add("pass2");
        }
        if(!this.pass.equals(this.passconfirm) &&!(this.pass.equals("")&&this.pass.length() < 6 || this.pass.length() > 20)){
            check.add("pass3");
        }    
        if(this.mail.equals("")){
            check.add("mail");
        }
        if(this.mail.length() > 100){
            check.add("mail2");
        }
        if(this.address.equals("")){
            check.add("address");
        }
        if(this.address.length() > 100){
            check.add("address2");
        }
        return check;
        
    }
    
    
    public void mapDTO(UserDataDTO udd){    //UDB→DTOへ値を変換
        
        udd.setName(this.name);
        udd.setPass(this.pass);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
    
    }
    
    public void mapUserDataBeans(UserDataDTO udd){  //DTO→UDBへ値を変換
        
        this.name = udd.getName();
        this.pass = udd.getPass();
        this.mail = udd.getMail();
        this.address = udd.getAddress(); 
        
    }
    
}
    
