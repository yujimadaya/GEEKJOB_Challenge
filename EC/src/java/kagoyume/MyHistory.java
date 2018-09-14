/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList; 

/**
 *
 * @author yamadayuushi
 */
public class MyHistory extends HttpServlet {

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
        
        HttpSession hs = request.getSession();
        UserDataDTO loginDTO = (UserDataDTO)hs.getAttribute("loginDTO");
        YahooAPI yahooapi = new YahooAPI();
        
        
        try{  
            //アクセスチェック
            String accesscheck = request.getParameter("User_ac");
            if(accesscheck==null || !hs.getAttribute("User_ac").toString().equals(accesscheck)){
                throw new Exception("不正なアクセスです");
            }
                       
            MyHistoryDTO myhistoryDTO = new MyHistoryDTO();
            myhistoryDTO.setUserID(loginDTO.getUserID());
            ArrayList<MyHistoryDTO> myhistoryDTO_array = UserDataDAO.getInstance().HistorySearch(myhistoryDTO);   //HistoryにSQL内の購入情報を格納する。
            
            ArrayList<MyHistoryBeans> myhistorybeans_array = yahooapi.HistoryItem(myhistoryDTO_array);            
            
            hs.setAttribute("myhistoryData", myhistorybeans_array); //"myhistory"にHistoryデータを格納
            hs.setAttribute("hits", myhistorybeans_array.size());
            
            request.getRequestDispatcher("/myhistory.jsp").forward(request, response);  //myhistory.jspに移動
            
        }catch(Exception e){

            request.setAttribute("error", e.getMessage());
            request.setAttribute("pageid", "top.jsp");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
