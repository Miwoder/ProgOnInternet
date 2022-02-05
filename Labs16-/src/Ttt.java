import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class Ttt extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        if(request.getParameter("URLn").equals("1")) {
            response.sendRedirect(request.getServletContext().getInitParameter("URL1"));
        } else if(request.getParameter("URLn").equals("2")) {
            response.sendRedirect(request.getServletContext().getInitParameter("URL2"));
        } else {
            pw.println("parameter URLn not found");
        }
        pw.close();
    }
}
