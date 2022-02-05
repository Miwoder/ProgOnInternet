<%@ page import="classes.CBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"
         import= "java.util.*" %>
<%@ page import="java.io.PrintWriter" %>

<html>
<head>
    <title></title>
</head>
<body>
<%
    CBean cb = null;
    ServletContext sc = request.getServletContext();
    Enumeration en = sc.getAttributeNames();
    String x;
    PrintWriter pw = response.getWriter();

    while (en.hasMoreElements()) {

        x = (String) en.nextElement();

        if(x.equals("artCBean")) {
            cb=(CBean) sc.getAttribute(x);
        }
    }

    String v1 = cb.getVal1();
    String v2 = cb.getVal2();
    String v3 = cb.getVal3();
    %>
<br> getVal1 = <%=v1%>
<br> getVal2 = <%=v2%>
<br> getVal3 = <%=v3%>

</body>
</html>
