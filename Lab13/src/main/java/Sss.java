import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Sss extends HttpServlet implements Servlet {
    private HttpClient client;

    public Sss() {
        super();
        System.out.println("Sss: ctor");
    }

    public void init(ServletConfig config) throws ServletException {
        super.init();
        System.out.println("Sss: init");
    }

    public void destroy() {
        super.destroy();
        System.out.println("Sss: destroy");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        client = new HttpClient();
        System.out.println("Sss: service: " + request.getMethod());
        PrintWriter writer = response.getWriter();
        writer.write("Sss: service: " + request.getMethod() + "\n");
        writer.write("Server name: " + request.getServerName() + "\n");
        writer.write("Addr: " + request.getRemoteAddr() + " Port: " + request.getRemotePort() + "\n\n");
        super.service(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;
        GetMethod getMethod;

        System.out.println("Sss: doGet");
        PrintWriter writer = response.getWriter();
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String redirectDest = request.getParameter("destination");
        String action = request.getParameter("action");


        String uri = "http://localhost:8085/lab13/Ggg?firstname=" + firstName + "&lastname=" + lastName
                + "&destination=" + redirectDest;

        writer.write("Sss: doGet\n");
        writer.write("firstname: " + firstName + " lastname: " + lastName + " action: " + action + "\n");

        getMethod = new GetMethod(uri);
        if (action.equals("redefine")) {
            dispatcher = request.getRequestDispatcher("/Ggg");
            dispatcher.forward(request, response);
        } else if (action.equals("redirect")) {
            response.sendRedirect("http://localhost:8085/lab13/Ggg?firstname=" + firstName + "&lastname=" + lastName
                    + "&destination=" + redirectDest);
        } if (action.equals("request")) {
            client.executeMethod(getMethod);
            writer.write(getMethod.getResponseBodyAsString());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;
        PostMethod postMethod;
        
        System.out.println("Sss: doPost");
        PrintWriter writer = response.getWriter();

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String action = request.getParameter("action");
        String redirectDest = request.getParameter("destination");

        String uri = "http://localhost:8085/lab13/Ggg?firstname=" + firstName + "&lastname=" + lastName
                + "&destination=" + redirectDest + "&action=" + action;

        writer.write("Sss: doPost\n");
        writer.write("firstname: " + firstName + " lastname: " + lastName + " action: " + action + "\n");

        postMethod = new PostMethod(uri);
        
        if (action.equals("redefine")) {
            dispatcher = request.getRequestDispatcher("/Ggg");
            dispatcher.forward(request, response);
        } else if (action.equals("redirect")) {
            response.sendRedirect("http://localhost:8085/lab13/Ggg?firstname=" + firstName + "&lastname=" + lastName
                    + "&destination=" + redirectDest);
        } if (action.equals("request")) {
            client.executeMethod(postMethod);
            writer.write(postMethod.getResponseBodyAsString());
        }
    }
}
