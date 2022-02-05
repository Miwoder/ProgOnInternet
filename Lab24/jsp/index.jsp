<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab24</title>
</head>
<body>
<form action="Sss" method="POST">
	<p>Directory<input name="dir" type="text"/>
	<input name="add" value="Create Directory" type="submit" size="10" maxlength="10"/></p>
</form>
<br><br>
<form method="POST" action="Sss" >
    File:
    <input type="file" name="dir" id="dir" />
    <input type="submit" value="Upload" name="add" />
</form>
<br><br>
<form method="POST" action="Sss" >
	File:
	<input name="dir" type="text"/>
	<input type="submit" value="Download" name="add" />
</form>
<br><br>
<form method="POST" action="Sss" >
	File:
	<input name="dir" type="text"/>
	Directory:
	<input name="todir" type="text"/>
	<input type="submit" value="Copy" name="add" />
</form>
<br><br>
<form action="Sss" method="POST">
	<p>Directory<input name="dir" type="text" />
	<input name="add" value="Delete" type="submit"/></p>
</form>
<br><br>
<form action="Sss" method="POST">
	<p>File name<input name="dir" type="text" />
		<input name="add" value="Delete" type="submit"/></p>
</form>
</body>
</html>