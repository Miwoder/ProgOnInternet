import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Ggg  extends HttpServlet implements Servlet {
    public Ggg() {
        super();
        System.out.println("Ggg: ctor");
    }

    public void init(ServletConfig config) throws ServletException {
        super.init();
        System.out.println("Ggg: init");
    }

    public void destroy() {
        super.destroy();
        System.out.println("Ggg: destroy");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Ggg: service: " + request.getMethod());
        PrintWriter writer = response.getWriter();
        writer.write("Ggg: service: " + request.getMethod() + "\n");
        writer.write("Server name: " + request.getServerName() + "\n");
        writer.write("Addr: " + request.getRemoteAddr() + " Port: " + request.getRemotePort() + "\n\n");
        writer.write(Util.showRequest(request) + "\n");
        super.service(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;

        System.out.println("Ggg: doGet");
        PrintWriter writer = response.getWriter();
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String redirectDest = request.getParameter("destination");

        writer.write("Ggg: doGet\n");
        writer.write("firstname: " + firstName + " lastname: " + lastName + " destination: " + redirectDest + "\n");

        if (redirectDest.equals("html")) {
            writer.write("Redirect\n");
            dispatcher = request.getRequestDispatcher("/newpage.html");
            dispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Ggg: doPost");
        PrintWriter writer = response.getWriter();

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String action = request.getParameter("action");
        String redirectDest = request.getParameter("destination");

        writer.write("Ggg: doPost\n");
        writer.write("firstname: " + firstName + " lastname: " + lastName + " action: " + action + "\n");
    }
}
