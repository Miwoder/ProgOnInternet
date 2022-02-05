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

public class Ccc1 extends HttpServlet implements Servlet {
    public Ccc1() {
        super();
        System.out.println("Ccc:constructor");
    }
    public CBean cb;
    public void init() throws ServletException {
        super.init();
    }
    public void destroy() {
        super.destroy();
        System.out.println("Ccc:destroy");
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
//        cb = new CBean();
//        rq.setAttribute("atrCBean", cb);
        PrintWriter pw = rs.getWriter();
        if("old".equals(rq.getParameter("CBean"))) {
            cb =(CBean)rq.getAttribute("atrCBean");
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

        rq.setAttribute("atrCBean", cb);
        rq.getRequestDispatcher("/Ccc1.jsp").forward(rq,rs);
    }

}