import pack.JdbcConnection;

import java.io.IOException;
import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteLink extends HttpServlet {
    public DeleteLink() {
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        String Id = rq.getParameter("Id");

        try {
            Connection connection = JdbcConnection.getConnection();
            connection.setAutoCommit(false);
            System.out.println("PODKL DB");

            Savepoint savepointOne = connection.setSavepoint("SavepointOne");
            Statement statement = connection.createStatement();
            System.out.println("NACHALO");
            try {
                String deleteLinks = "DELETE FROM commentarii WHERE Link_ID ="+Id;
                PreparedStatement stmt = connection.prepareStatement(deleteLinks);
                stmt.executeUpdate();

                //statement.executeUpdate(deleteLinks);
                System.out.println("1 otrabotal");

                deleteLinks = "DELETE FROM Links WHERE Link_ID =" + Id;
                statement.executeUpdate(deleteLinks);
                System.out.println("2 otrabotal");

                connection.commit();
                }
                catch (SQLException var112) {
                    System.out.println(var112);
                    connection.rollback(savepointOne);
                }
            //statement.execute(String.format("DELETE FROM Links WHERE Link_ID = %s", Id));

            //statement.execute("DELETE FROM Links WHERE Link_Id = " + Id);

            rs.sendRedirect("http://localhost:8085/Lab24/index.jsp");
            connection.close();
        } catch (IOException | SQLException var12) {
            System.out.println(var12);
        }

    }
}