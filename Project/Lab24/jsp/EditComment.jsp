<%@ page import="java.sql.Connection" %>
<%@ page import="Model.Commentarii" %>
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
        Model.Commentarii comment = null;
        try {
            comment = Model.Commentarii.getCommentFromDb(Integer.parseInt(request.getParameter("Id")));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    %>
    <form method="post" action="EditComment">
        <span>Your comment:</span>
        <textarea cols="20" rows="2" name="comment" style="border: none; border-radius: 6px"><%=comment.getComtext()%></textarea>
        <input type="text" value="<%=request.getParameter("Id")%>" style="display: none;" name="Id" style="border: none; border-radius: 6px">
        <input type="submit" value="Edit" style="border: none; border-radius: 6px">
    </form>
</div>
</body>
</html>
