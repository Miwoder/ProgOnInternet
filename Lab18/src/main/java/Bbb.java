import pack.CBean;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bbb extends HttpServlet implements Servlet {
    public Bbb() {
        super();
        System.out.println("Bbb:constructor");
    }
    public CBean cb;
    public void init() throws ServletException {
        super.init();
        System.out.println("Bbb:init");
    }
    public void destroy() {
        super.destroy();
        System.out.println("Bbb:destroy");
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        PrintWriter pw = rs.getWriter();
        String s;
        rs.setContentType("text/html");
        rs.addHeader("BbbHeader1", "Value1");
        rs.addHeader("BbbHeader2", "Value2");
        pw.println("<br><h2>Headers from Aaa</h2>");
        Enumeration enh = rq.getHeaderNames();
        while (enh.hasMoreElements()) {
            s = (String) enh.nextElement();
            pw.println("<br />" + s + "= " + rq.getHeader(s));
        }
        enh = rq.getParameterNames();
        pw.println("<br><h2>Parameters from Aaa</h2>");
        while (enh.hasMoreElements()) {
            s = (String)enh.nextElement();
            pw.println("<br>" + s + " = ");
            String[] enhel = rq.getParameterValues(s);
            for(int i =0; i< enhel.length;i++)
                pw.print(enhel[i] + " ");
        }
    }
}