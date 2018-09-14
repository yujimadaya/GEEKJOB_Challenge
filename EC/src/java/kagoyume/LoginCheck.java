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
public class LoginCheck extends HttpServlet {

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
            
            UserDataDTO searchDTO = new UserDataDTO();
            
            if(!(request.getParameter("mail").equals("") || request.getParameter("password").equals(""))){ //login画面でuser名とパスワードどちらも入力していたら
            
                searchDTO.setMail(request.getParameter("mail"));                        //UserDataDTOのmailに"mail"のデータをつめる
                searchDTO.setPass(request.getParameter("password"));                    //UserDataDTOのpasswordに"password"をつめる
                UserDataDTO resultDTO = UserDataDAO.getInstance().logincheck(searchDTO);//DAOにてログインチェック→要素がある場合resultDTOにつめる
            
                if(resultDTO.getMail()!=null && resultDTO.getPass()!=null){//resultDTOにmailとpasswordがつめられている場合
                
                    if(resultDTO.getDeleteFlg()==0){//デリートフラグが0の場合（デリートされていない場合）
                                
                        hs.setAttribute("loginDTO", resultDTO);                         //resultDTOを"loginDTO"としてセッションに保存
                        UserDataDTO loginDTO =(UserDataDTO)hs.getAttribute("loginDTO"); //loginDTO(loginDto)にログイン時の情報を格納する
                        CartBeans cartbeans;                                            //CartBeansクラスの設定
 
                        if(hs.getAttribute("cartID") != null && hs.getAttribute("cartID").toString().equals("guest")){//"gest"としてカートに物を入れていた場合
                     
                            if(hs.getAttribute(String.valueOf(loginDTO.getUserID()))==null){//一度もログイン時に買い物をしたことが無い場合
                        
                                cartbeans = (CartBeans)hs.getAttribute(hs.getAttribute("cartID").toString());           //CartBeansにguestで登録したデータを追加
                                hs.setAttribute("cartID",String.valueOf(loginDTO.getUserID()));                         //"cartID"にuserIDを上書き("guest"→userIDへ上書き)
                                hs.setAttribute(hs.getAttribute("cartID").toString(),cartbeans);                        //"cartID"に"guest"で登録したCartBeansデータを追加する            
                            }else{//ログイン時に買い物をしたことがある場合↓
                                cartbeans = (CartBeans)hs.getAttribute(String.valueOf(loginDTO.getUserID()));           //ログイン時登録していたデータをcb(CartBeans)にセット
                                CartBeans guest = (CartBeans)hs.getAttribute(hs.getAttribute("cartID").toString());     //gest時登録したデータをguest(CartBeans)にセット
                                cartbeans.CartAll(cartbeans, guest);                                                    //ログイン時のデータにguest時のデータを追加する
                                hs.setAttribute("cartID",String.valueOf(loginDTO.getUserID()));                         //"cartID"にuserIDを上書き("guest"→userIDへ上書き)
                                hs.setAttribute(hs.getAttribute("cartID").toString(),cartbeans);                        //cartIDにcbのデータをセッションとして登録する。
                            }
                        }else if(hs.getAttribute("cartID")==null && (CartBeans)hs.getAttribute(String.valueOf(loginDTO.getUserID()))!=null){//1度でも買い物をしたことがあり、カートに商品情報が残っている場合
                        
                            hs.setAttribute("cartID", String.valueOf(loginDTO.getUserID()));    //セッション名:"cartID"をuserIDの数字としてセッションに登録
                        }
                        //カート画面からログイン処理をしている場合、アクセスチェックの番号をセットする。
                        if(request.getParameter("Cart_ac")!=null){
                            request.setAttribute("Cart_ac", request.getParameter("Cart_ac"));
                        }
                    
                        //ログイン処理をする前にいたページまで戻る。
                        request.getRequestDispatcher(request.getParameter("pageid")).forward(request, response);
                
                    }else{//deleteFlgが0ではない場合(deleteされている場合)
                        throw new Exception("このユーザーはすでに削除されています。<br>"); //エラー文を送る        
                    }
                
                }else{//resultDTOにmailとpasswordがつめられていない場合
                    request.setAttribute("pageid", request.getParameter("pageid"));         //移動してきた先のpageidを"pageid"としてrequestに設定する。
                    request.setAttribute("loginmiss","LoginMiss");                          //requestにLoginMissという文を"loginmiss"という値に設定する。
                
                    if(request.getParameter("pageid").equals("Cart")){//"Cart"から遷移してきた場合
                    
                        request.setAttribute("Cart_ac", request.getParameter("Cart_ac"));   //Cartで設定したアクセスチェックの値をリクエストに設定する  
                    }
                    throw new Exception("ユーザー名またはパスワードが間違っています。<br>");        //error文"ユーザー名またはパスワードが間違っています。<br>"を送る。
                }
 
            }else{//メールアドレスまたはパスワードが未入力の場合
                String notInput = "";                                               //格納用String変数notInputの作成
                if(request.getParameter("mail").equals("")){                        //メールアドレスが未入力の場合
                    notInput += "メールアドレスが未入力です。<br>";                      //エラー内容を変数notInputに格納                      
                }
                if(request.getParameter("password").equals("")){                    //パスワードが未入力の場合
                    notInput += "パスワードが未入力です。<br>" ;                         //エラー内容を変数notInputに格納
                }
                    request.setAttribute("loginmiss","LoginMiss");                  //requestにLoginMissという文を"loginmiss"という値に設定する
                    request.setAttribute("pageid", request.getParameter("pageid")); //移動してきた先のpageidを"pageid"としてrequestに設定する。
                    throw new Exception(notInput);                                  //変数notInputをExceptionで送る
            }

        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            if(request.getAttribute("pageid")==null){
                request.setAttribute("pageid", "top.jsp");
            }
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
