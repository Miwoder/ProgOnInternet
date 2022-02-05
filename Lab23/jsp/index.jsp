<%@ page language="java"   contentType="text/html;charset=ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab_23</title>
</head>
<a>index.jsp</a>
    <br/>
<br/>
<a href="files.jsp">Files</a>
<form method="POST" action="upload" enctype="multipart/form-data" >
    File:
    <input type="file" name="file" id="file" />
    <input type="submit" value="Upload" name="upload" id="upload" />
</form>

</body>
</html>