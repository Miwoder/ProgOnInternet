import jspclass.Regimex;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Jjj extends HttpServlet implements Servlet {


    protected void service(HttpServletRequest rq, HttpServletResponse rs) throws IOException {


        Regimex r = new Regimex();
        Integer n = r.GetHOUR();

        if ((n >= 6) && (n <= 11))
            rs.sendRedirect("morning.jsp");
        else if ((n > 11) && (n <= 16))
            rs.sendRedirect("afternoon.jsp");
        else if ((n > 16) && (n <= 23))
            rs.sendRedirect("evening.jsp");
        else
            rs.sendRedirect("night.jsp");
    }



    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        rs.sendRedirect("morning.jsp");
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        rs.sendRedirect("evening.jsp");
    }
}
