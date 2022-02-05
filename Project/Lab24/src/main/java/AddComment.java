import pack.JdbcConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddComment extends HttpServlet {
    public AddComment() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        Cookie cookie = new Cookie("UserName", name);
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
        String comment = req.getParameter("comment");
        String Id = req.getParameter("Id");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException var11) {
            System.out.println(var11);
            var11.printStackTrace();
        }

        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();

            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            Date date = calendar.getTime();
            int day = calendar.get(Calendar.DATE);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);
            System.out.println(Id);
            statement.execute(String.format("INSERT INTO commentarii(Link_ID, author, stamp, comtext)" +
                    "VALUES (\'%s\',\'%s\',  \'%s-%s-%s\',  \'%s\')", Id, name,
                    day,month, year ,  comment));

            statement.close();
            connection.close();
        } catch (SQLException var10) {
            System.out.println(var10+ "ERROR ADD COMMENT");
            var10.printStackTrace();
        }

        resp.sendRedirect("Comment.jsp?Id=" + Id);
    }
}