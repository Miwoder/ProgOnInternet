<%@ page language="java"   contentType="text/html;charset=ISO-8859-1" import= "pack.CBean" import= "java.util.*" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lab_16</title>

</head>
<body>
<% ServletContext sc = getServletContext();
    CBean cb = (CBean)sc.getAttribute("atrCBean");%>
<br><%=request.getParameter("CBean")%> Value1 = <%=cb.getValue1()%>
<br><%=request.getParameter("CBean")%> Value2 = <%=cb.getValue2()%>
<br><%=request.getParameter("CBean")%> Value3 = <%=cb.getValue3()%>

</body>
</html>