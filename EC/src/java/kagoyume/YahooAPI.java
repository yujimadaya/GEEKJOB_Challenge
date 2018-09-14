/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.URL;
import java.util.ArrayList;

public class YahooAPI {
    
    public ArrayList<SearchBeans> ItemSearch(SearchBeans searchbeans)throws Exception{
    try{
    String url="http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=dj00aiZpPVZwYm4wTmEzNElIcCZzPWNvbnN1bWVyc2VjcmV0Jng9NDI-&hits=10";
    
    if(searchbeans.getWord()!=null && !searchbeans.getWord().equals("")){
        String word = URLEncoder.encode(searchbeans.getWord(),"UTF-8");     //検索ワードを"UTF-8形式に変更"
        url += "&query=" + word;                                            //URLの末尾に追加
    }
    
    URL searchURL = new URL(url);                                           //String変数urlをURLクラス(searchURL)として登録
    HttpURLConnection con = (HttpURLConnection)searchURL.openConnection();  //URLが参照するリモートオブジェクトへの接続
    con.connect();                                                          //URLに接続                                                          
    
    BufferedReader searchJSON = new BufferedReader(new InputStreamReader(con.getInputStream()));    //検索結果のデータをsearchJSONに格納
    
    String JSONdata = "";
    String line = "";
        while((line = searchJSON.readLine()) != null) { //検索結果のデータをすべて取り出す
            JSONdata += line;                           //BufferedReaderのデータをString型のデータとして格納
        }
    
    searchJSON.close();
    con.disconnect();
        
    ObjectMapper mapper = new ObjectMapper();           //ObjectMapperをインスタンス化
    JsonNode JSONresult = mapper.readTree(JSONdata);    //Jsonのデータをjavaで読み取れる形に変換
    
    int hit = JSONresult.get("ResultSet").get("totalResultsAvailable").asInt();                             //JsonNodeのhit情報を格納
    ArrayList<SearchBeans> searchbeans_Array = new ArrayList<>();                                           //SearchBeansを追加できるArrayListを作成
    if(hit!=0){//hit件数が0件ではない場合(0件の場合は空のArrayListをreturnする。)
        
        int hit_num = 10;   //検索結果が10件以上の場合は、jspに10件分のデータを表示させる
        if(10>hit){         //検索結果が1~9件の場合
            hit_num = hit;  //検索件数分の検索結果を表示
        }
 for(int i = 0; i < hit_num; i++){
     SearchBeans storage_searchbeans = new SearchBeans();
     JsonNode abridgementNode = JSONresult.get("ResultSet").get("0").get("Result").get(String.valueOf(i));  //上文省略
     String name = abridgementNode.get("Name").asText();                                                    //JsonNodeのname情報を格納
     String image = abridgementNode.get("Image").get("Medium").asText();                                    //JsonNodeのimage情報を格納
     int price = abridgementNode.get("Price").get("_value").asInt();                                        //JsonNodeのprice情報を格納
     String itemcode = abridgementNode.get("Code").asText();                                                //JsonNodeのitemcode情報を格納
     storage_searchbeans.setName(name);                                                                     //SearchBeansにname情報を格納
     storage_searchbeans.setImage(image);                                                                   //SearchBeansにimage情報を格納
     storage_searchbeans.serPrice(price);                                                                   //SearchBeansにprice情報を格納
     storage_searchbeans.setItemCode(itemcode);                                                             //SearchBeansにitemcode情報を格納
     searchbeans_Array.add(storage_searchbeans);                                                            //SearchBeansのArrayListに情報を格納したSearchBeansを追加する。
 }   
    searchbeans_Array.get(0).setWord(searchbeans.getWord());                                                //SearchBeansのArrayListの1番目に検索ワードの情報を格納する。
    searchbeans_Array.get(0).setHit(hit);                                                                   //SearchBeansのArrayListの1番目にhit件数の情報を格納する。
 }  
    return searchbeans_Array;
    
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception(e);
    }
}
    
    public ItemBeans ItemResult(String itemcode)throws Exception{
    try{
    String url="https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?appid=dj00aiZpPVZwYm4wTmEzNElIcCZzPWNvbnN1bWVyc2VjcmV0Jng9NDI-&responsegroup=medium";
        
        String code = URLEncoder.encode(itemcode, "UTF-8"); //itemcodeを"UTF-8"形式に変更
        url += "&itemcode=" + code;
      
    URL searchURL = new URL(url);                                           //String変数urlをURLクラス(searchURL)として登録
    HttpURLConnection con = (HttpURLConnection)searchURL.openConnection();  //URLが参照するリモートオブジェクトへの接続
    con.connect(); //URL接続
    
    BufferedReader searchJSON = new BufferedReader(new InputStreamReader(con.getInputStream())); //検索結果のデータをsearchJSONに格納
    
    String JSONdata = "";
    String line = "";
        while((line = searchJSON.readLine()) != null) { //検索結果のデータをすべて取り出す
            JSONdata += line;                           //BufferedReaderのデータをString型のデータとして格納
        }
    
    searchJSON.close(); 
    con.disconnect();
        
    ObjectMapper mapper = new ObjectMapper();           //ObjectMapperをインスタンス化
    JsonNode JSONresult = mapper.readTree(JSONdata);    //Jsonのデータをjavaで読み取れる形に変換
    
    ItemBeans itembeans = new ItemBeans();
        JsonNode abridgementNode = JSONresult.get("ResultSet").get("0").get("Result").get(String.valueOf("0")); //上文省略
        String name = abridgementNode.get("Name").asText();                                                     //JsonNodeのname情報を格納
        String image = abridgementNode.get("Image").get("Medium").asText();                                     //JsonNodeのimage情報を格納
        int price = abridgementNode.get("Price").get("_value").asInt();                                         //JsonNodeのprice情報を格納
        itemcode = abridgementNode.get("Code").asText();                                                        //JsonNodeのitemcode情報を格納
        String overview = abridgementNode.get("Description").asText();                                          //JsonNodeのoverview情報を格納
        String rate = abridgementNode.get("Review").get("Rate").asText();                                       //JsonNodeのrate情報を格納
        itembeans.setName(name);                                                                                //itembeansにname情報を格納
        itembeans.setImage(image);                                                                              //itembeansにimage情報を格納
        itembeans.setPrice(price);                                                                              //itembeansにprice情報を格納
        itembeans.setItemCode(itemcode);                                                                        //itembeansにitemcode情報を格納
        itembeans.setOverview(overview);                                                                        //itembeansにoverview情報を格納
        itembeans.setRate(rate);                                                                                //itembeansにrate情報を格納
        
    return itembeans;
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception(e);
    }
    }
    
    
public ArrayList<CartBeans> CartItem(CartBeans cartbeans)throws Exception{
    
    try{ 
        
    ArrayList<CartBeans> cartbeans_Array = new ArrayList<>();  
    
    for(int i=0;i<cartbeans.getItemCodeArray().size();i++){
    
    String url="https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?appid=dj00aiZpPVZwYm4wTmEzNElIcCZzPWNvbnN1bWVyc2VjcmV0Jng9NDI-&responsegroup=medium";
        
        String code = URLEncoder.encode(cartbeans.getItemCodeList(i), "UTF-8"); //itemcodeを"UTF-8"形式に変更
        url += "&itemcode=" + code;
      
    URL searchURL = new URL(url);                                               //String変数urlをURLクラス(searchURL)として登録
    HttpURLConnection con = (HttpURLConnection)searchURL.openConnection();      //URLが参照するリモートオブジェクトへの接続
    con.connect();//URLに接続
    
    BufferedReader searchJSON = new BufferedReader(new InputStreamReader(con.getInputStream()));    //検索結果のデータをsearchJSONに格納
    
    String JSONdata = "";
    String line = "";
        while((line = searchJSON.readLine()) != null) { //検索結果のデータをすべて取り出す
        JSONdata += line;                               //BufferedReaderのデータをString型のデータとして格納
        }
    
    searchJSON.close();
    con.disconnect();
        
    ObjectMapper mapper = new ObjectMapper();   //ObjectMapperをインスタンス化
    JsonNode JSONresult = mapper.readTree(JSONdata);//Jsonのデータをjavaで読み取れる形に変換
    
    CartBeans storage_cartbeans = new CartBeans();
    JsonNode abridgementNode = JSONresult.get("ResultSet").get("0").get("Result").get(String.valueOf("0")); //上文省略
    String name = abridgementNode.get("Name").asText();                                                     //JsonNodeのname情報を格納
    String image = abridgementNode.get("Image").get("Medium").asText();                                     //JsonNodeのimage情報を格納
    int price = abridgementNode.get("Price").get("_value").asInt();                                         //JsonNodeのprice情報を格納
    storage_cartbeans.setItemCode(cartbeans.getItemCodeList(i));                                            //CartBeansにitemcode情報を格納
    storage_cartbeans.setName(name);                                                                        //CartBeansにname情報を格納
    storage_cartbeans.setImage(image);                                                                      //CartBeansにimage情報を格納
    storage_cartbeans.setPrice(price);                                                                      //CartBeansにprice情報を格納
    cartbeans_Array.add(storage_cartbeans);                                                                 //CartBeansのArrayListに情報を格納したCartBeansを追加する。
    }   
    int total = 0;
    for(int a=0;a<cartbeans_Array.size();a++){                                                              
        total += cartbeans_Array.get(a).getPrice();                                                         //CartBeansのArrayList内のprice総合計額を計算
    }
    cartbeans_Array.get(0).setTotal(total);                                                                 //CartBeansのArrayListの1番目に上記で計算したprice総合計額を格納
        return cartbeans_Array;                                                                             //cartbeans_Arrayをreturnする。
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception(e);
    }
}

public ArrayList<MyHistoryBeans> HistoryItem(ArrayList<MyHistoryDTO> myhistoryDTO_array)throws Exception{
    
    try{ 
        
    ArrayList<MyHistoryBeans> myhistorybeans_array = new ArrayList<>();  
    
    for(int i=0;i<myhistoryDTO_array.size();i++){
    
    String url="https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?appid=dj00aiZpPVZwYm4wTmEzNElIcCZzPWNvbnN1bWVyc2VjcmV0Jng9NDI-&responsegroup=medium";
        
        String code = URLEncoder.encode(myhistoryDTO_array.get(i).getItemCode(), "UTF-8");      //itemcodeをUTF-8形式に変更
        url += "&itemcode=" + code;                                                             //URLの末尾に追加する
           
    URL searchURL = new URL(url);                                           //String変数urlをURLクラス(searchURL)として登録
    HttpURLConnection con = (HttpURLConnection)searchURL.openConnection();  //URLが参照するリモートオブジェクトへの接続
    con.connect();                                                          //URLに接続
    
    BufferedReader searchJSON = new BufferedReader(new InputStreamReader(con.getInputStream()));//検索結果のデータをsearchJSONに格納
    
    String JSONdata = "";
    String line = "";
        while((line = searchJSON.readLine()) != null) {                                         //検索結果のデータをすべて取り出す
            JSONdata += line;                                                                   //BufferedReaderのデータをString型のデータとして格納
        }
    
    searchJSON.close();
    con.disconnect();
        
    ObjectMapper mapper = new ObjectMapper();   //ObjectMapperをインスタンス化
    JsonNode JSONresult = mapper.readTree(JSONdata);//Jsonのデータをjavaで読み取れる形に変換
    
    MyHistoryBeans str_myhistorybeans = new MyHistoryBeans();
    JsonNode abridgementNode = JSONresult.get("ResultSet").get("0").get("Result").get(String.valueOf("0")); //上文省略
    String name = abridgementNode.get("Name").asText();                                                     //JsonNodeのname情報を格納
    String image = abridgementNode.get("Image").get("Medium").asText();                                     //JsonNodeのimage情報を格納
    int price = abridgementNode.get("Price").get("_value").asInt();                                         //JsonNodeのprice情報を格納
    str_myhistorybeans.setName(name);                                                                       //MyhistoryBeansにname情報を格納
    str_myhistorybeans.setImage(image);                                                                     //MyhistoryBeansにimage情報を格納
    str_myhistorybeans.setPrice(price);                                                                     //MyhistoryBeansにprice情報を格納
    str_myhistorybeans.setType(myhistoryDTO_array.get(i).getType());                                        //MyhistoryBeansにmyhistoryDTO内のtype情報を格納   
    str_myhistorybeans.setBuyDate(myhistoryDTO_array.get(i).getBuyDate());                                  //MyhistoryBeansにmyhistoryDTO内のbuydate情報を格納
    myhistorybeans_array.add(str_myhistorybeans);                                                           //MyhistoryBeansのArrayListに情報を格納したMyhistoryBeansを格納する。
    }   
        return myhistorybeans_array;
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception(e);
    }
}

}
