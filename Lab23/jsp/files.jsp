<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import= "others.*" %>
<%--???????????? ?????? ?????? (??????) ? jsp-????????--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab_23</title>
</head>
<body>
<%
	String d = (String) getServletContext().getInitParameter("doc-dir");
	ChoiseXXX ch = new ChoiseXXX(d, "docx");
	String ll = null; 
	for (int i = 0; i < ch.listxxx.length; i++) {
	   ll = ch.listxxx[i];	
%>
<br />
<a href="Sss?file=<%=ll%>"> <%=ll%> </a>
<%}%>
</body>
</html>
