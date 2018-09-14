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
public class BuyComplete extends HttpServlet {

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
                
        
        try{            
            //アクセスチェック
            String accesscheck = request.getParameter("Cart_ac");   
            if(accesscheck==null || !hs.getAttribute("Cart_ac").toString().equals(accesscheck)){
                throw new Exception("不正なアクセスです");
            }
            //ArrayList化したCartBeansのデータを格納
            ArrayList<CartBeans> cartbeans_Array = (ArrayList<CartBeans>)hs.getAttribute("CartData");   
            
            ArrayList<BuyDTO> buyDTOArray = new ArrayList<>();          //buyDTOのデータを追加する為のArrayListを作成
            for(int i=0;i<cartbeans_Array.size();i++){                  //CartBeansの情報分、buyDTOのArrayListに追加する。
            BuyDTO buydto = new BuyDTO();                               //BuyDTOをインスタンス化
            buydto.setItemCode(cartbeans_Array.get(i).getItemCode());   //buyDTOにcartbeans内のitemcode情報を格納する。
            buyDTOArray.add(buydto);                                    //BuyDTOの情報をBuyDTOのArrayListに格納する。
            }

            buyDTOArray.get(0).setUserID(loginDTO.getUserID());                                 //ArrayListの1番目の情報にuserIDのデータを追加
            buyDTOArray.get(0).setType(Integer.parseInt(request.getParameter("type")));         //ArrayListの2番目の情報にtypeのデータを追加
            UserDataDAO.getInstance().Cartbuy(buyDTOArray);                                     //SQLに商品コードや値段などの情報を追加
            
            //登録できたら↓
            
            loginDTO.setTotal(loginDTO.getTotal() + cartbeans_Array.get(0).getTotal());          //loginDTOのtotal金額に今回の購入金額を＋させる
            
            UserDataDAO.getInstance().updata(loginDTO);                                          // データ更新
            
            hs.setAttribute("loginDTO", loginDTO);                                               //loginDTOのデータも更新
            
            CartBeans cb = new CartBeans();                                                      //カートの中身を初期化させる。
            hs.setAttribute(String.valueOf(loginDTO.getUserID()),cb);
         
            request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);         //buycomplete.jspに移動する。
            
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
