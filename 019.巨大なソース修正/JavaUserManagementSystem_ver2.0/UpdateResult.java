package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        
        try{
            request.setCharacterEncoding("UTF-8");
            
            UserDataBeans udb = new UserDataBeans();
            String kazu2 = session.getAttribute("sekazu").toString();
            System.out.print(kazu2);
            //UserDataBeansに値を格納させる。
            udb.setUserID(kazu2); 
            udb.setName(request.getParameter("name2"));
            udb.setYear(request.getParameter("year2"));
            udb.setMonth(request.getParameter("month2"));
            udb.setDay(request.getParameter("day2"));
            udb.setType(request.getParameter("type2"));
            udb.setTell(request.getParameter("tell2"));
            udb.setComment(request.getParameter("comment2"));
            
            //DB専用のパラメータに変換させる処理
            UserDataDTO userdata = new UserDataDTO();
            udb.UD2DTOMapping(userdata);
            
            //DBへデータの挿入
            UserDataDAO .getInstance().update(userdata);  //DAOのupdateメソッドを行う
            
            //udbを返す処理
            request.setAttribute("udb", udb);
            
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
        }catch(Exception e){
            
            request.setAttribute("error", e.getMessage());
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
