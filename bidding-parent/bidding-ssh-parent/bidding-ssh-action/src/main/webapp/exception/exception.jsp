<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="eng" lang="eng">
<head>
 <meta http-equiv="content-type" content="text/html; charset=utf-8" />
 <meta name="author" content="Yigit Yigit Ce.[pulyavserdce.com]" />
 <meta name="description" content="Site description" />
 <meta name="keywords" content="keywords, keyword, seo, google" />
 <meta name="apple-mobile-web-app-status-bar-style" content="black" />
 <meta name="apple-mobile-web-app-capable" content="yes" />
 <title>系统异常</title>
 <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
</head>
<body>
<div class="controller">
 <div class="objects">
  <!-- text area -->
  <div class="text-area rotate">
   <p class="error"><s:property value="exception.message"/></p>
   <p class="details">There was a problem<br /><br />The page you are looking for is not here or moved.</p>
  </div>
  <!-- text area -->
  <!-- home page -->
  <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >Website Template</a></div>
  <div class="homepage rotate">
   <a href="#">Back to homepage</a>
  </div> <!-- home page -->
 </div> <!-- social-icons -->
 <div class="social">
  <ul class="social-icons">
  </ul>
 </div>
</div>
</body>
</html>