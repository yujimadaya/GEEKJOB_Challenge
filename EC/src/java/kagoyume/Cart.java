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
public class Cart extends HttpServlet {

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
        
            HttpSession hs = request.getSession();  //セッションスコープ
            CartBeans cartbeans = new CartBeans();  //CartBeansインスタンス生成
            YahooAPI yahooapi = new YahooAPI();     //YahooAPIインスタンス生成
            
        
        try {
            String accesscheck = request.getParameter("Cart_ac");
            if(accesscheck==null && hs.getAttribute("Cart_ac")==null){
                throw new Exception("不正なアクセスです");
            }
            
        if(hs.getAttribute("loginDTO") == null){                                    //ログインされていない場合
            request.setAttribute("pageid", "Cart");                                 //"pageid"に"Cartをセット"（ログイン成功後、戻る用）
            request.setAttribute("Cart_ac", accesscheck);                           //アクセスチェックの値をリクエストに登録する
            //login.jspへ移動する
            request.getRequestDispatcher("/login.jsp").forward(request, response);  
        
        }else{
            //アクセスチェック
            if(hs.getAttribute("Cart_ac")==null){
                hs.setAttribute("Cart_ac", accesscheck);
            }
            
            UserDataDTO loginDTO = (UserDataDTO)hs.getAttribute("loginDTO");                            //UserDataDTOにログイン時のデータ情報を格納する。
            
            //deleteの処理、deleteIDに数字が追加されている場合
            if(request.getParameter("deleteID")!=null) {
                cartbeans = (CartBeans)hs.getAttribute(hs.getAttribute("cartID").toString());           //cb(CartBeansにデータをセット）
                cartbeans.DeleteItemCode(Integer.parseInt(request.getParameter("deleteID")));           //数字を指定し、商品と値段のデータを削除する
                hs.setAttribute(hs.getAttribute("cartID").toString(), cartbeans);                       //cb(CartBeans)のデータを更新する。
            }

            ArrayList<CartBeans> cartbeans_Array = new ArrayList<>();                                   //CartBeansを格納するArrayListを作成する。
            
            if((CartBeans)hs.getAttribute(String.valueOf(loginDTO.getUserID()))!=null){//CartBeansにデータがある場合
                
                cartbeans = (CartBeans)hs.getAttribute(String.valueOf(loginDTO.getUserID()));           //UserIDに格納してあるCartBeansのデータを変数cartbeansに格納する。
            }
            
            if(!cartbeans.getItemCodeArray().isEmpty()){        //CartBean内の商品コードを格納しているArrayListの中にコードが追加されている場合         
                cartbeans_Array = yahooapi.CartItem(cartbeans); //YahooAPIを使用し、そのコードの商品情報を所得する
                hs.setAttribute("CartData", cartbeans_Array);   //商品情報を所得したリストをセッションに登録する
            }
            //セッション("CartData")へCartBeansのArrayList(cartbeans_Array)を格納する
            hs.setAttribute("CartData", cartbeans_Array);
            //cart.jspへ移動する
            request.getRequestDispatcher("/cart.jsp").forward(request, response); 
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
