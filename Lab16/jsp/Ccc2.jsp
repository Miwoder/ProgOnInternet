<%@ page language="java"   contentType="text/html;charset=ISO-8859-1" import= "pack.CBean" import= "java.util.*" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lab_16</title>

</head>
<body>
<%  HttpSession ss = request.getSession();%>
<% if (ss.getAttribute(ss.getId()) == null) { %>
<h1>Object CBean not initialized</h1>
<%} else {%>
<%CBean Cb = (CBean)ss.getAttribute(ss.getId());%>
<br><%=request.getParameter("CBean")%> Value1 = <%=Cb.getValue1()%>
<br><%=request.getParameter("CBean")%> Value2 = <%=Cb.getValue2()%>
<br><%=request.getParameter("CBean")%> Value3 = <%=Cb.getValue3()%>
<%}%>
</body>
</html>