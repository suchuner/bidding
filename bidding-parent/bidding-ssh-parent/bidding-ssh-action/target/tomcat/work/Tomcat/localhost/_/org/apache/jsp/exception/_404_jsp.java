/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-03-03 14:59:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.exception;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _404_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write(" <html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"eng\" lang=\"eng\">\r\n");
      out.write("  <head> \r\n");
      out.write("  <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("  <meta name=\"author\" content=\"Yigit Yigit Ce.[pulyavserdce.com]\" />\r\n");
      out.write("  <meta name=\"description\" content=\"Site description\" />\r\n");
      out.write("  <meta name=\"keywords\" content=\"keywords, keyword, seo, google\" /> \r\n");
      out.write("  <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" /> \r\n");
      out.write("  <meta name=\"apple-mobile-web-app-capable\" content=\"yes\" /> \r\n");
      out.write("  <title>404:页面不存在</title>\r\n");
      out.write("   <link rel=\"stylesheet\" media=\"screen\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" type=\"text/css\" />\r\n");
      out.write("   </head> \r\n");
      out.write("   <body> \r\n");
      out.write("   <div class=\"controller\">\r\n");
      out.write("    <div class=\"objects\"> \r\n");
      out.write("    <!-- text area -->\r\n");
      out.write("    <div class=\"text-area rotate\">\r\n");
      out.write("    <p class=\"error\">ERROR 404</p>\r\n");
      out.write("    <p class=\"details\">There was a problem<br /><br />The page you are looking for is not here or moved.</p> \r\n");
      out.write("    </div> \r\n");
      out.write("    <!-- text area -->\r\n");
      out.write("    <!-- home page --> \r\n");
      out.write("    <div class=\"copyrights\">Collect from <a href=\"http://www.cssmoban.com/\" >Website Template</a></div>\r\n");
      out.write("    <div class=\"homepage rotate\">\r\n");
      out.write("    <a href=\"#\">Back to homepage</a> \r\n");
      out.write("    </div> <!-- home page --> \r\n");
      out.write("    </div> <!-- social-icons --> \r\n");
      out.write("    <div class=\"social\">\r\n");
      out.write("    <ul class=\"social-icons\">\r\n");
      out.write("    </ul> \r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
