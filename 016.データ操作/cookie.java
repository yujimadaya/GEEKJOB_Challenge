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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Cookie;

/**
 *
 * @author yamadayuushi
 */
public class cookie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Date now = new Date();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            
            String nowtime = sdf.format(now);// nowtime= 現在の時刻のString変数
            
            Cookie c = new Cookie("zenkai", nowtime); //クッキーに情報を書き込む
            
            response.addCookie(c); //クッキーを登録する
            
            Cookie[] cs = request.getCookies(); //クッキー内の情報を配列化させる
            
            if(cs != null) //値が格納されているかを確認
                
                for(int i = 0; i < cs.length;i++){ //クッキー内の情報を順番に確認する
                    
                    String cookieName = cs[i].getName(); //名前情報の取り出し
                    
                    if(cookieName.equals("zenkai")){ //同じかどうかを調べる
                        
                        String cookieValue = cs[i].getValue(); //値を取り出しcookieValueへ格納する
                        
                        out.print("前回のログイン日時:" + cookieValue);
                        break;
                    
                    }
                        
                        
            
            
            
            
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
