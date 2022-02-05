package pack;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class F3 implements Filter {
    public void init(FilterConfig cfg) throws ServletException {
        System.out.println("F3:init");
    }
    public void destroy() {
        System.out.println("F3:destroy");
    }

    public void doFilter(ServletRequest rq,   ServletResponse rs,   FilterChain ch)  throws IOException, ServletException {
        FltRequest frq = new FltRequest((HttpServletRequest)rq);
        frq.SetAA("Hello from F3");
        PrintWriter pw = rs.getWriter();
        System.out.println("F3:blocking resource");
        pw.println("Servlet Ccc is blocked by filter F3");
        System.out.println("F3:doFilter");
        ch.doFilter(frq, rs);
    }
}