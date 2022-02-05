<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"
         import= "java.util.*" %>
<html>
  <head>
    <title>----</title>
  </head>
  <body>
  <form method="get" action="Ttt">
    <input type="radio" name="URLn" value="1" checked="checked">To URL1
    <br>
    <input type="radio" name="URLn" value="2" >To URL2
      <br>
    <input type="submit" name="press" value="Send Get" size="20">
  </form>
  <%
    ServletContext sc = request.getServletContext();
    Enumeration en = sc.getInitParameterNames();
    String x;
    while (en.hasMoreElements()) {
        x = (String) en.nextElement();
  %>
  <br />
  <%= x + "=" %><%= sc.getInitParameter(x) %>
  <%
    }
  %>
  </body>
</html>