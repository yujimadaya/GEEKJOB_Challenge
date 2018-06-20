/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yamadayuushi
 */
public class method7 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String user_profile(int num,int num2){ //(a,b) aは配列の指定,bは指定された配列の要素の番号を選択する
        String[] word  ={"1","技育太郎","東京","null","プログラマー"};
        String[] word2 ={"2","技育花子","null","女","システムエンジニア"};
        String[] word3 ={"3","技育三郎","大阪","男","null"};
        
        int kazu  = Integer.parseInt(word[0]); //word配列の0番目の要素"1"を数値型の変数に変える
        int kazu2 = Integer.parseInt(word2[0]);//word2配列の0番目の要素"2"を数値型の変数に変える
        int kazu3 = Integer.parseInt(word3[0]);//word3配列の0番目の要素"3"を数値型の変数に変える
        
        if(num == kazu){        //word配列の0番目の要素"1"と 変数numに入力された数字が同じかどうかを調べる
            return word[num2];
        }else if(num == kazu2){ //word2配列の0番目の要素"2"と　変数numに入力された数字が同じかどうかを調べる
            return word2[num2];
        }else if(num == kazu3){ //word3配列の0番目の要素"3"と　変数numに入力された数字が同じかどうかを調べる
            return word3[num2];
        }else{                  //上記以外の場合はnullを返却する。
            return null;
        }
    
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            
            
            for(int i = 1;i < 5 ;i++){ //4回ループさせる
                
            String a = user_profile(3,i); //(a,b) aに取り出したい配列番号,bは取り出した配列の2~5番目の要素を取り出す処理   
                                          //メソッドを変数aとおく
                if(a.equals ("null")){ //変数aが"null"の場合はcontinueする
                    continue;
                }else{
                    out.print(a + "<br>"); //変数aが"null"以外の場合は変数aの文字を表示する
                }                       //aに1,2,3以外を入力すると、すべてnullで表示される。
            }
            
                
            
            
            
            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
