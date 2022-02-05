<%@ page language="java"   contentType="text/html;charset=ISO-8859-1" import= "pack.CBean" import= "java.util.*" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lab_16</title>

</head>
<body>
<% CBean Cb = (CBean)request.getAttribute("atrCBean");%>
<br><%=request.getParameter("CBean")%> Value1 = <%=Cb.getValue1()%>
<br><%=request.getParameter("CBean")%> Value2 = <%=Cb.getValue2()%>
<br><%=request.getParameter("CBean")%> Value3 = <%=Cb.getValue2()%>
</body>
</html>