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
public class RegistrationComplete extends HttpServlet {

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
        CartBeans cartbeans = new CartBeans();        
        try{ 
            
            request.setCharacterEncoding("UTF-8");
            
            //アクセスチェック
            String accesscheck = request.getParameter("Insert_ac");                                 
            if(accesscheck==null || !hs.getAttribute("Insert_ac").toString().equals(accesscheck)){ 
                throw new Exception("不正なアクセスです");
            }  
            
            UserDataBeans userdatabeans = (UserDataBeans)hs.getAttribute("udb");                //入力したデータをUserDataBeans(userdatabeans)に格納
            
            UserDataDTO registrationDTO = new UserDataDTO();                                    //UserDataDTO(registrationDTO)を設定
            userdatabeans.mapDTO(registrationDTO);                                              //udbのデータをDTOのデータに変換
            
            UserDataDAO.getInstance().insert(registrationDTO);                                  //データベースに登録
            
            UserDataDTO loginDTO = UserDataDAO.getInstance().logincheck(registrationDTO);       //登録したデータを元にすべての値を受け取る。
            
            hs.setAttribute("loginDTO", loginDTO);                                              //resultDTOを"loginDTO"としてセッションに保存
            
            if(hs.getAttribute("cartID")!=null){//cartIDが設定されている場合
                if(hs.getAttribute("cartID").toString().equals("guest")){                           //"guest"としてカートに物を入れていた場合                  
                    cartbeans = (CartBeans)hs.getAttribute(hs.getAttribute("cartID").toString());   //CartBeansにguestで登録したデータを追加
                    hs.setAttribute("cartID",String.valueOf(loginDTO.getUserID()));                 //"cartID"にuserIDを上書き("guest"→userIDへ上書き)
                    hs.setAttribute(hs.getAttribute("cartID").toString(),cartbeans);                //"cartID"に"guest"で登録したCartBeansデータを追加する
                }
            }
            
            request.setAttribute("udb", userdatabeans);                                         //(UserDataBeans)udbのデータを"udb"に保存
            
            //registrationcomplete.jspへ移動
            request.getRequestDispatcher("/registrationcomplete.jsp").forward(request, response);
            
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
