<%@ page import="java.sql.Connection" %>
<%@ page import="Model.Links" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit comment</title>
    <link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
<div class="FormEditComment">
    <%
        Model.Links link = null;
        try {
            link = Model.Links.getLinkFromDb(Integer.parseInt(request.getParameter("Id")));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    %>
    <form method="post" action="EditLink">
        <span>Your link:</span>
        <textarea cols="25" rows="1" name="Link" style="border: none; border-radius: 6px"><%=link.get_Ref()%></textarea>
        <textarea cols="25" rows="1" name="Desc" style="border: none; border-radius: 6px"><%=link.get_DescriptionLink()%></textarea>
        <input type="text" value="<%=request.getParameter("Id")%>" style="display: none;" name="Id" style="border: none; border-radius: 6px">
        <input type="submit" value="Edit" style="border: none; border-radius: 6px">
    </form>
</div>
</body>
</html>
