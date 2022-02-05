import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletUrl extends HttpServlet implements Servlet {
    public ServletUrl() {
        super();
        System.out.println("ServletUrl:constructor");
    }

    public void init(ServletConfig sc) throws ServletException {
        super.init();
        System.out.println("ServletUrl:init");
    }
    public void destroy() {
        super.destroy();
        System.out.println("ServletUrl:destroy");
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("ServletUrl:doGet");
        if("1".equals(rq.getParameter("urln")))
        {
            rs.sendRedirect(rq.getServletContext().getInitParameter("URL1"));
        }
        else if("2".equals(rq.getParameter("urln")))
        {
            rs.sendRedirect(rq.getServletContext().getInitParameter("URL2"));
        }
        else
        {
            rs.setContentType("text/html");
            PrintWriter pw = rs.getWriter();
            pw.println("parameter URLn not found");
            pw.close();
        }
    }
}