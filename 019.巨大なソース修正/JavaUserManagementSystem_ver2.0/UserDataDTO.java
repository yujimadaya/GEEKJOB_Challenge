package jums;

import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;

/**
 * ユーザー情報を持ちまわるJavaBeans
 * データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 * @version 1.00
 * @author hayashi-s
 */
public class UserDataDTO {
    private int userID;
    private String name;
    private Date birthday;
    private String tell;
    private int type;
    private String comment;
    private Timestamp newDate;
    //DTOに格納されたものをArrayListに格納していく
    private ArrayList<Integer> userID2 = new ArrayList();
    private ArrayList<String> name2 = new ArrayList();
    private ArrayList<Date> birthday2 = new ArrayList();
    private ArrayList<String> tell2 = new ArrayList();
    private ArrayList<Integer> type2 = new ArrayList();
    private ArrayList<String> comment2 = new ArrayList();
    private ArrayList<Timestamp> newDate2 = new ArrayList();
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }

    public void kakunou(){//DTOの値をArrayListに格納するメソッド
    
    userID2.add(userID) ;
    name2.add(name);
    birthday2.add(birthday);
    tell2.add(tell);
    type2.add(type);
    comment2.add(comment);
    newDate2.add(newDate);
    
}

    public void irekomi(int i){//ArrayListに格納した値をDTOの値に再度格納するメソッド
    
    userID = userID2.get(i);
    name = name2.get(i);
    birthday = birthday2.get(i);
    tell = tell2.get(i);
    type =type2.get(i);
    comment = comment2.get(i);
    newDate = newDate2.get(i);
        
    }
    
    public int retukazu(){//データベースの列の数を戻り値で返すメソッド
        
        int kazu = userID2.size();
        
        return kazu;
        
}
    
}


    