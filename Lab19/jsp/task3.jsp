<%@ page language="java"   contentType="text/html;charset=ISO-8859-1" import= "java.util.*" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lab_16</title>

</head>
<body>
<% ServletContext sc = getServletContext();
    Enumeration en = sc.getInitParameterNames();
    String x;
    while (en.hasMoreElements()) {
        x = (String) en.nextElement(); %>
<br>
<%=x+"="%><%=sc.getInitParameter(x)%>
<%}%>
</body>
</html>