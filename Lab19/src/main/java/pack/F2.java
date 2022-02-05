package pack;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class F2 implements Filter {
    public void init(FilterConfig cfg) throws ServletException {
        System.out.println("F2:init");
    }
    public void destroy() {
        System.out.println("F2:destroy");
    }

    public void doFilter(ServletRequest rq,   ServletResponse rs,   FilterChain ch)  throws IOException, ServletException {
        FltRequest frq = new FltRequest((HttpServletRequest)rq);
        frq.SetAA("Hello from F2");
        PrintWriter pw = rs.getWriter();
//        System.out.println("F2:blocking resource"); // блокировка
//        pw.println("Ccc.jsp is blocked by filter F2");
        System.out.println("F2:doFilter");
        ch.doFilter(frq, rs);
    }
}