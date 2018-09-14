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
public class Search extends HttpServlet {
    
   

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
        
        try{
            
            request.setCharacterEncoding("UTF-8");
            
            HttpSession hs = request.getSession();
            SearchBeans searchbeans = new SearchBeans();
            YahooAPI yahooapi = new YahooAPI();
        
            if(request.getParameter("search_word")!=null){                                      //Parameterに値が格納されている場合
            
                if(request.getParameter("search_word").equals("")){                             //未入力の場合
                    throw new Exception("未入力です");                                                                                                          
                }else if(request.getParameter("search_word").length() > 255 ){                  //文字数が255文字より多い場合
                    throw new Exception("文字数オーバーです");  
                }
                searchbeans.setWord(request.getParameter("search_word"));                       //searchbeansに検索ワードを格納
                ArrayList<SearchBeans> searchbeans_Array = yahooapi.ItemSearch(searchbeans);    //yahooAPIで検索ワードの上位10位までをSearchBeansのArrayListに格納する。
                request.setAttribute("SearchData", searchbeans_Array);                          //SearchBeansのArrayListデータをリクエストにセットする。
                hs.setAttribute("search_word",request.getParameter("search_word"));             //検索ワードをセッションに登録する
                request.getRequestDispatcher("./search.jsp").forward(request, response);        //search.jspへ移動     
            
            }else if(hs.getAttribute("search_word")!=null){                                     //セッション("search_word")に値が登録されている場合
                searchbeans.setWord(hs.getAttribute("search_word").toString());                 //searchbeansに検索ワードを格納
                ArrayList<SearchBeans> searchbeans_Array = yahooapi.ItemSearch(searchbeans);    //yahooAPIで検索ワードの上位10位までをSearchBeansのArrayListに格納する。
                request.setAttribute("SearchData", searchbeans_Array);                          //SearchBeansのArrayListデータをリクエストにセットする。
                request.getRequestDispatcher("./search.jsp").forward(request, response);        //search.jspへ移動     
            }
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
