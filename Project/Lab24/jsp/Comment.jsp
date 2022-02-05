<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Commentarii"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.time.LocalDate" %>
<html>
<head>
    <title>Comments</title>
    <link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
<div id="comments">
    <div id="FormComment">
        <form method="post" action="AddComment">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" width="150px" style="border: none; border-radius: 6px" placeholder="Enter your name here"></td>
                </tr>
                <tr>
                    <td>Comment:</td>
                    <td>
                        <textarea cols="20" rows="2" name="comment" style="border: none; border-radius: 6px" placeholder="Enter your comment here"></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="text" value="<%=request.getParameter("Id")%>" style="display: none;" name="Id">
                        <input type="submit" value="Submit">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="ListOfComments">
        <%
            ArrayList<Model.Commentarii> comments = null;
            try {
                comments = Model.Commentarii.getCommentsFromDb(Integer.parseInt(request.getParameter("Id")));
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
                e.printStackTrace();
            }
            for(Model.Commentarii comment: comments){
        %>

        <div class="Comment">
            <p>
                <span><b><%=comment.getAuthor()%></b></span><br>
                <span><i><%=comment.getStamp().toString()%></i></span>
            <p><%=comment.getComtext()%></p>
            <%
                Cookie[] cookies = request.getCookies();
                String UserName = null;
                String cookieName = "UserName";
                LocalDate date = LocalDate.now();
                String p = String.valueOf(date.getMonthValue() + date.getDayOfMonth() + date.getYear());
                for(Cookie cookie: cookies){
                    if (cookieName.equals(cookie.getName())) {
                        UserName = cookie.getValue();
                        break;
                    }
                }
                if (UserName.equals(comment.getAuthor()) || UserName.equals(p) || request.getParameter("admin")!=null){
            %>
            <a href="EditComment.jsp?Id=<%=comment.getCom_ID()%>">Edit comment</a>
            <a href="EditComment?Id=<%=comment.getCom_ID()%>&action=del">Delete comment</a>
            <%}%>
            </p>
        </div>
        <%}%>
    </div>
</div>
</body>
</html>
