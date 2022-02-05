import pack.JdbcConnection;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/EditComment"})
public class EditComment extends HttpServlet {
    public EditComment() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String Id = request.getParameter("Id");
        String action = request.getParameter("action");
        if (action.equals("del")) {
            try {
                Connection connection = JdbcConnection.getConnection();
                Statement statement = connection.createStatement();
                Model.Commentarii comment = Model.Commentarii.getCommentFromDb(Integer.parseInt(request.getParameter("Id")));
                statement.execute("DELETE FROM commentarii WHERE Com_ID = " + Id);
                response.sendRedirect("Comment.jsp?Id=" + comment.get_LinkId());
            } catch (ClassNotFoundException | IOException | SQLException var9) {
                var9.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Id = request.getParameter("Id");
        String CommentText = request.getParameter("comment");
        Model.Commentarii comment = null;

        try {
            comment = Model.Commentarii.getCommentFromDb(Integer.parseInt(request.getParameter("Id")));
        } catch (SQLException var11) {
            var11.printStackTrace();
        } catch (ClassNotFoundException var12) {
            var12.printStackTrace();
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException var10) {
            var10.printStackTrace();
        }

        try {
            Connection connection = JdbcConnection.getConnection();
            connection.setAutoCommit(false);
            System.out.println("PODKL DB");

            Savepoint savepointOne = connection.setSavepoint("SavepointOne");
            Statement statement = connection.createStatement();
            System.out.println("NACHALO");
            try {
                String editLinks = "UPDATE commentarii SET comtext = \'" + CommentText + "\' WHERE Com_ID = " + Id;
                PreparedStatement stmt = connection.prepareStatement(editLinks);
                stmt.executeUpdate();
                statement.executeUpdate(editLinks);
                connection.commit();
                System.out.println("EDIT COMMIT");
            }
            catch (SQLException var143) {
                System.out.println(var143);
                connection.rollback(savepointOne);
            }
        }
        catch (SQLException var90) {
            var90.printStackTrace();
        }

        response.sendRedirect("Comment.jsp?Id=" + comment.get_LinkId());
    }
}
