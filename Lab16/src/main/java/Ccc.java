import pack.CBean;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

public class Ccc extends HttpServlet implements Servlet {
    public Ccc() {
        super();
        System.out.println("Ccc:constructor");
    }
    public CBean cb;
    public void init() throws ServletException {
        super.init();
        cb = new CBean();
        System.out.println("Ccc:init");
        ServletContext sc = getServletContext();
        sc.setAttribute("atrCBean", cb);
    }
    public void destroy() {
        super.destroy();
        System.out.println("Ccc:destroy");
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        ServletContext sc = getServletContext();
        PrintWriter pw = rs.getWriter();
        if("old".equals(rq.getParameter("CBean"))) {
            cb =(CBean)sc.getAttribute("atrCBean");
        } else {
            cb = new CBean();
        }

        if(!rq.getParameter("Value1").isEmpty()) {
            cb.setValue1(rq.getParameter("Value1"));
        }

        if(!rq.getParameter("Value2").isEmpty()) {
            cb.setValue2(rq.getParameter("Value2"));
        }

        if(!rq.getParameter("Value3").isEmpty()) {
            cb.setValue3(rq.getParameter("Value3"));
        }

        sc.setAttribute("atrCBean",cb);
        rq.getRequestDispatcher("/Ccc.jsp").forward(rq,rs);
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
//        System.out.println("Ccc:doGet");
//        if("1".equals(rq.getParameter("urln")))
//        {
//            rs.sendRedirect(rq.getServletContext().getInitParameter("URL1"));
//        }
//        else if("2".equals(rq.getParameter("urln")))
//        {
//            rs.sendRedirect(rq.getServletContext().getInitParameter("URL2"));
//        }
//        else
//        {
//            rs.setContentType("text/html");
//            PrintWriter pw = rs.getWriter();
//            pw.println("parameter URLn not found");
//            pw.close();
//        }
    }
}