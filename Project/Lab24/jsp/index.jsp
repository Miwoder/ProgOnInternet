
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Links, java.sql.*" %>
<%@ page import="pack.JdbcConnection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.LocalDate" %>
<!Doctype html>
<html>
<head>
    <title>-UWSR-</title>
    <link rel="stylesheet" href="css/main.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
<header>
    <h1>--UWSR--</h1>
    <div id="Search">
        <form method="post" action="Search">
            <input type="text" width="200px" name="find" placeholder="Type here to search" style="border: none; border-radius: 6px;">
            <input class="button" type="submit" value="Search" style="border: none; border-radius: 6px">
        </form>
    </div>
</header>
<main>
    <% if (request.getParameter("admin")!=null){ %>
    <div id="FormAddLink">
        <form method="POST" action="AddLink">
            <table>
                <tr>
                    <td>Link:</td><td><input style="border: none; border-radius: 6px; " placeholder="Place here new link" type="text" width="150px" name="Ref"></td>
                </tr>
                <tr>
                    <td>Key words:</td></td><td><input style="border: none; border-radius: 6px;" placeholder="Type here some keys" type="text" width="150px" name="DescriptionLink"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Add new link" style="border: none; border-radius: 6px" width="150px" align="center"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <%}%>
    <p><h2 align="center" class="Top1">Search result</h2></p>
    <div id="FindedLinks" class="table1">
        <%  HttpSession ses = request.getSession();
            if(ses.getAttribute("findedLinks") != null){
                ArrayList<Model.Links> findedLinks = (ArrayList<Model.Links>) ses.getAttribute("findedLinks");

                for(Model.Links link: findedLinks){
        %>
        <div class="Link" style="border-bottom: 2px solid black">
            <a href=<%=link.get_Ref()%>><h2 class="s1"><%=link.get_DescriptionLink()%></h2></a>
            <div class="btns">
                <a href="AddLink?Id=<%=link.get_id()%>&action=true">Like</a>
                <a href="AddLink?Id=<%=link.get_id()%>&action=false">Dislike</a>
                <a href="Comment.jsp?Id=<%=link.get_id()%>" target="_blank">View comments</a>
                <span class="Useful"><%=link.get_IsUseful()%></span>
                <span class="Useless"><%=link.get_IsUseless()%></span>
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
                    if (UserName != null && UserName.equals(p)){
                %>
                <% if (request.getParameter("admin")!=null){ %>
                <a href="EditLink.jsp?Id=<%=link.get_id()%>&action=edit" >Edit link</a>
                <a href="DeleteLink?Id=<%=link.get_id()%>">Delete link</a>
                <%}%>
                <%}%>
            </div>
        </div>
        <%}}%>
    </div>
    <p align="center"><h2 align="center" class="Top2">Links</h2></p>
    <div Id="ListOfLinks" class="table2">
        <%
            try {
                Connection connection = JdbcConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet listOfLinks = statement.executeQuery("SELECT * FROM Links");
                ArrayList<Model.Links> links = new ArrayList<Model.Links>();

                while(listOfLinks.next()){
                    Model.Links link = new Model.Links(listOfLinks.getInt(1),listOfLinks.getString(2), listOfLinks.getString(3),
                            listOfLinks.getInt(4), listOfLinks.getInt(5));
                    links.add(link);
                }

                for(Model.Links link: links){

        %>
        <div class="Link" style="border-bottom: 2px solid black">
            <a href=<%=link.get_Ref()%>><h2><%=link.get_DescriptionLink()%></h2></a>
            <div class="btns">
                <a href="AddLink?Id=<%=link.get_id()%>&action=true">&nbsp;&nbsp;Like</a>
                <a href="AddLink?Id=<%=link.get_id()%>&action=false">&nbsp;&nbsp;Dislike</a>
                <a href="Comment.jsp?Id=<%=link.get_id()%>" target="_blank">&nbsp;&nbsp;View comments</a>
                <% if (request.getParameter("admin")!=null){ %>
                <a href="EditLink.jsp?Id=<%=link.get_id()%>&action=edit" >&nbsp;&nbsp;Edit link</a>
                <a href="DeleteLink?Id=<%=link.get_id()%>">&nbsp;&nbsp;Delete link</a>
                <%}%>
                <span class="Useful"><%=link.get_IsUseful()%></span>
                <span class="Useless"><%=link.get_IsUseless()%></span>
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
                    if (UserName != null && UserName.equals(p)){
                %>
                <a href="DeleteLink?Id=<%=link.get_id()%>">&nbsp;&nbsp;Delete link</a>
                <%}%>
            </div>
        </div>
        <%}
        }catch(SQLException e){
            e.printStackTrace();
        }%>
    </div>
</main>
</body>
</html>
