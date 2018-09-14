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


/**
 *
 * @author yamadayuushi
 */
public class Add extends HttpServlet {

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
        
        try{       
            request.setCharacterEncoding("UTF-8");
            CartBeans cartbeans = new CartBeans();  //CartBeansのインスタンス生成
                        
            if(hs.getAttribute("cartID") == null){//cartIDが登録されていない場合
                
                if(hs.getAttribute("loginDTO") == null){//cartIDが登録されていない場合且つログインされていない場合
                    
                    hs.setAttribute("cartID", "guest");                                         //セッション名:"cartID"を"guest"の数字としてセッションに登録
                    cartbeans.setItemCodeList(request.getParameter("code"));                    //CartBeansのアイテム追加メソッドに商品コードを追加   
                    hs.setAttribute(hs.getAttribute("cartID").toString(),cartbeans);            //セッション名:cartID（"guest")をCartBeansクラスに格納
                
                }else{//ログインはされているが、cartIDが登録されていない場合
                    
                    UserDataDTO loginDTO =(UserDataDTO)hs.getAttribute("loginDTO");
                    hs.setAttribute("cartID", String.valueOf(loginDTO.getUserID()));            //セッション名:"cartID"をuserIDの数字としてセッションに登録
                    cartbeans.setItemCodeList(request.getParameter("code"));                    //CartBeansのアイテム追加メソッドに商品コードを追加
                    hs.setAttribute(hs.getAttribute("cartID").toString(),cartbeans);            //セッション名:cartID（ユーザーID)をCartBeansクラスに格納
                }
                
            }else{//cartIDが登録されている場合
                
                cartbeans =(CartBeans)hs.getAttribute(hs.getAttribute("cartID").toString());    //セッションに追加したCartBeansクラスをCartBeansクラスに格納
                cartbeans.setItemCodeList(request.getParameter("code"));                        //CartBeansのアイテム追加メソッドに商品コードを追加
                hs.setAttribute(hs.getAttribute("cartID").toString(), cartbeans);               //名前cartID（ユーザーID)にCartBeansクラスを格納
                
            }
            //add.jspへ移動する          
            request.getRequestDispatcher("/add.jsp").forward(request, response);
            
        }catch(Exception e){      
            request.setAttribute("error", e);
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
