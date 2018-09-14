package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import kagoyume.UserDataDTO;
import kagoyume.UserDataBeans;
import kagoyume.KagoyumeHelper;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    HttpSession hs = request.getSession();                                          //セッションスコープの取得
    KagoyumeHelper k_helper = KagoyumeHelper.getInstance();                         //KagoyumeHelperをインスタンス化
    UserDataDTO loginDTO = null;                                                    //UserDataDTO初期化
    boolean login = k_helper.logincheck((UserDataDTO)hs.getAttribute("loginDTO"));  //ログインチェック、ログイン済みの場合"login"にtrueを返却
    if(login){loginDTO = (UserDataDTO)hs.getAttribute("loginDTO");}                 //ログインされている場合、UserDataDTO(loginDTO)にユーザー情報を格納

      out.write("        \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\"> \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/EcCss.css\" rel=\"stylesheet\" type=\"text/css\"/>      \n");
      out.write("        <title>かごゆめTOP PAGE</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"margin:20px; padding:0px;\">\n");
      out.write("        <center>\n");
      out.write("            ");
if(login){
      out.write(" \n");
      out.write("                ");
      out.print(k_helper.logout());
      out.write(" \n");
      out.write("            ");
}else{
      out.write("\n");
      out.write("                ");
      out.print(k_helper.login());
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            <img src=\"image/logo-4.png\">");
      out.write("         \n");
      out.write("            <br>\n");
      out.write("            <font size=\"4\" color=\"#54d1a7\" face='ヒラギノ丸ゴ Pro W4'>このサイトは架空で買い物ができるサイトです。</font>\n");
      out.write("            <br>\n");
      out.write("            <br>");
if(login){out.print("ようこそ" + loginDTO.getName() + "さん");}
      out.write("<br> ");
      out.write("\n");
      out.write("            <br>                      \n");
      out.write("            <form action=\"Search\" method=\"get\" name=\"search\"> ");
      out.write("\n");
      out.write("                <div class=\"mx-auto\" style=\"width: 200px;\">\n");
      out.write("                    <div class=\"form-row align-items-center\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"Search\">商品名検索</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" maxlength='100' name=\"search_word\"> ");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div> \n");
      out.write("                </div>     \n");
      out.write("                <a href=\"javascript:document.search.submit()\" class=\"cp_btn\">検索</a>\n");
      out.write("            </form>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            ");
if(login){
      out.write("\n");
      out.write("            <br><form action=\"MyData\" method=\"POST\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-outline-success btn-lg\">ユーザー情報</button>\n");
      out.write("                    <input type=\"hidden\" name=\"User_ac\" value=");
      out.print((int)(Math.random() * 1000));
      out.write('>');
      out.write(' ');
      out.write("\n");
      out.write("                </form>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            <br><form action=\"Cart\" method=\"POST\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-outline-primary btn-lg\">買い物カゴ</button>\n");
      out.write("                    <input type=\"hidden\" name=\"Cart_ac\" value=");
      out.print((int)(Math.random() * 1000));
      out.write("><br> ");
      out.write("\n");
      out.write("                </form>            \n");
      out.write("        </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
