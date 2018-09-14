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
public class Registrationconfirm extends HttpServlet {

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
            //アクセスチェック↓
            String accesscheck = request.getParameter("Insert_ac");
            if(accesscheck==null || !hs.getAttribute("Insert_ac").toString().equals(accesscheck)){
                throw new Exception("不正なアクセスです");
            }        
            //UserDataBeansに値を格納↓
            UserDataBeans userdatabeans = new UserDataBeans();       
                userdatabeans.setName(request.getParameter("name"));          
                userdatabeans.setPass(request.getParameter("pass"));
                userdatabeans.setPassConfirm(request.getParameter("passconfirm"));
                userdatabeans.setMail(request.getParameter("mail"));
                userdatabeans.setAddress(request.getParameter("address"));
            //セッションにudbのデータを保存↓    
            hs.setAttribute("udb", userdatabeans); 
            //registrationconfirm.jspへ移動↓
            request.getRequestDispatcher("/registrationconfirm.jsp").forward(request, response);

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
