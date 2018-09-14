/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.util.ArrayList;
import javax.servlet.http.HttpSession; 

/**
 *
 * @author yamadayuushi
 */
public class KagoyumeHelper {
    
    
        
    public static KagoyumeHelper getInstance(){
        return new KagoyumeHelper();
    }
    
    public String home(){//トップボタンに戻るボタンの情報
        return "<center><a href=\"./top.jsp\"><button type=\"button\" class=\"btn btn-danger btn-sm\">TOPに戻る</button></a></center>";
    }
    
    public String login(String pageid){//loginボタンの情報（引数のページのデータを追加）
        return "<div align=\"right\"><a href=\"Login?pageid="+ pageid +"\"><button type=\"button\" class=\"btn btn-link btn-sm\">ログイン</button></a></div>";
    }
    
    public String login(){//loginボタンの情報(引数に情報がない場合はすべてtop.jspへ移動する)
        return login("top.jsp");        
    }
    
    public String logout(){//logoutボタンの情報
        return "<div align=\"right\"><a href=\"Login?pageid=./top.jsp\"><button type=\"button\" class=\"btn btn-link btn-sm\">ログアウト</button></a></div>";
    }
        
    
    public String checkip(ArrayList<String> checkList){//新規登録時、未入力の物を返却
    
        String e_message = "";
        
        for(String four : checkList){
            if(four.equals("name")){
                e_message += "名前が未入力です<br>";
            }
            if(four.equals("name2")){
                e_message +="ユーザー名の文字数が指定の文字数で入力されていません<br>";
            }
            if(four.equals("pass")){
                e_message += "パスワードが未入力です<br>";
            }
            if(four.equals("pass2")){
                e_message += "パスワードの文字数が指定の文字数で入力されていません<br>";
            }
            if(four.equals("pass3")){
                e_message += "パスワードが一致しません<br>";
            }
            if(four.equals("mail")){
                e_message += "メールアドレスが未入力です<br>";  
            }
            if(four.equals("mail2")){
                e_message += "メールアドレスが文字数オーバーです<br>";  
            }
            if(four.equals("address")){
                e_message +="住所が未入力です<br>";
            }
            if(four.equals("address2")){
                e_message += "住所が文字数オーバーです<br>";  
            }
        }      
            return e_message;      
    }
        
    public boolean logincheck(UserDataDTO userdatadto){ //login確認メソッド
        return userdatadto != null;   
    }
    
    public String exTypenum(int i){ //データベースで保存されている配送方法(int型)を文字列として返却
        switch(i){
            case 1:
                return "通常配送";
            case 2:
                return "お急ぎ配送";
            case 3:
                return "指定日配送";
        }
            return "";
        }
 
    public int num_check(int num){
        if(10<=num){
            return 10;
        }else{
            return num;
        }
    }
    
    public void DeleteSession(HttpSession hs){//セッションの削除(logoutした時に使用する)
        hs.setAttribute("loginDTO", null);          //"loginDTO"情報を削除
        hs.setAttribute("cartID",null);             //"cartID"を削除
        hs.setAttribute("Insert_ac", null);         //"Insert_ac"を削除
        hs.setAttribute("User_ac", null);           //User_ac"を削除
        hs.setAttribute("Cart_ac", null);           //"Cart_ac"を削除　
        hs.setAttribute("myhistoryData", null);     //"myhistoryData"を削除
        hs.setAttribute("hits", null);              //"hits"を削除
    }
        
}

