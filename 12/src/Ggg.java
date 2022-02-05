import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ggg extends HttpServlet {

    public Ggg() {
        System.out.println("Ggg: constructor");
    }

    public void init(ServletConfig config) throws ServletException {
        super.init();
        System.out.println("Ggg: init");
    }

    public void destroy(){
        System.out.println("Ggg: destroy");
        super.destroy();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Ggg: " + request.getMethod());
        String var3 = request.getParameter("firstname");
        String var4 = request.getParameter("lastname");
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html> <body> " + this.showRequest(request) + "<br><br>Ggg: " + request.getMethod()
                + "<br>Ggg:firstname = " + var3 + "<br>Ggg:lastname = " + var4 + "<br>Ggg:getServerName: "
                + request.getServerName() + "<br>Ggg:getRemoteAddr: " + request.getRemoteAddr() + "</body></html>");
        printWriter.flush();
    }

    private String showRequest(HttpServletRequest request)
            throws ServletException, IOException {

        StringBuilder requestString = new StringBuilder();

        requestString.append(request.getMethod() + " ");
        requestString.append(request.getRequestURL() + " ");
        requestString.append(request.getProtocol() + "\n");

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            requestString.append(headerName + ": " + request.getHeader(headerName) + "\n");
        }

        return requestString.toString();
    }

}
