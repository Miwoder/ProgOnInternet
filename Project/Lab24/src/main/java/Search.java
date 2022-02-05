import pack.JdbcConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Search extends HttpServlet {
    public Search() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String find = req.getParameter("find");

        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet listOfLinks = statement.executeQuery("SELECT * FROM links WHERE Description LIKE \'%" + find + "%\'");
            ArrayList findedLinks = new ArrayList();

            while(listOfLinks.next()) {
                new Model.Links();
                Model.Links link = new Model.Links(listOfLinks.getInt(1), listOfLinks.getString(2),
                        listOfLinks.getString(3), listOfLinks.getInt(4), listOfLinks.getInt(5));
                findedLinks.add(link);
            }

            System.out.println(findedLinks.size());
            HttpSession session = req.getSession();
            session.setAttribute("findedLinks", findedLinks);
            resp.sendRedirect("http://localhost:8085/Lab24/index.jsp");
        } catch ( SQLException var10) {
            var10.printStackTrace();
        }

    }
}
