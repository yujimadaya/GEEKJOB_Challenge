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
public class MyUpdateresult extends HttpServlet {

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
        KagoyumeHelper  k_helper = KagoyumeHelper.getInstance();
        

            try{  
                    
                request.setCharacterEncoding("UTF-8");
                    
                String accesscheck = request.getParameter("User_ac");
                if(accesscheck==null || !hs.getAttribute("User_ac").toString().equals(accesscheck)){
                    throw new Exception("不正なアクセスです");
                }    
                //udbに入力された文字を格納↓
                UserDataBeans userdatabeans = new UserDataBeans();    
                userdatabeans.setName(request.getParameter("name"));
                userdatabeans.setPass(request.getParameter("pass"));
                userdatabeans.setPassConfirm(request.getParameter("passconfirm"));
                userdatabeans.setMail(request.getParameter("mail"));
                userdatabeans.setAddress(request.getParameter("address"));
            
                if(!userdatabeans.checkfour().isEmpty()){                       //入力チェック、（入力が空か文字数オーバー、または２つのパスワードの値が一致しなかった時）
                String error =  k_helper.checkip(userdatabeans.checkfour());    //特定のエラー文をString変数errorに格納
                request.setAttribute("error", error);                           //requestにerror文を追加
                request.setAttribute("pageid", "MyUpdate");                     //pageidにMyUpdateを追加
                //eeror.jspへ移動する
                request.getRequestDispatcher("/error.jsp").forward(request, response);
                
            }else{
            
                UserDataDTO loginDTO = (UserDataDTO)hs.getAttribute("loginDTO");
                userdatabeans.mapDTO(loginDTO);                                     //udbのデータをDTOに格納
                
                UserDataDAO.getInstance().updata(loginDTO);                         //更新処理   
                
                //更新が完了した後↓
                request.setAttribute("udb", userdatabeans);                         //変更したudbをrequestで送る。
                hs.setAttribute("loginDTO", loginDTO);                              //"loginDTO"のデータを更新
                //myupdateresult.jspへ移動
                request.getRequestDispatcher("/myupdateresult.jsp").forward(request, response);
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
