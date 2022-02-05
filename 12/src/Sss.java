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
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;


public class Sss extends HttpServlet {

    public Sss() {
        System.out.println("Sss: constructor");
    }

    public void init(ServletConfig config) throws ServletException {
        super.init();
        System.out.println("Sss: init");
    }

    public void destroy(){
        System.out.println("Sss: destroy");
        super.destroy();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Sss: service: " + request.getMethod());
        PrintWriter writer = response.getWriter();
        writer.write("Sss: service: " + request.getMethod() + "\n");
        writer.write("Server name: " + request.getServerName() + "\n");
        writer.write("Addr: " + request.getRemoteAddr() + " Port: " + request.getRemotePort() + "\n\n");
        writer.write(showRequest(request) + "\n");
        super.service(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("Sss: doGet");
//        PrintWriter writer = response.getWriter();
//        String firstName = request.getParameter("firstname");
//        String lastName = request.getParameter("lastname");
//        writer.write("Sss: doGet\n");
//        writer.write("firstname: " + firstName + " lastname: " + lastName + "\n");


//        RequestDispatcher requestDispatcher;
//        requestDispatcher=request.getRequestDispatcher("/Ggg");
//        requestDispatcher.forward(request,response);

//        response.sendRedirect("https://metanit.com/");


        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String press = request.getParameter("press");
        HttpClient hc = new HttpClient();
        GetMethod gm;
        String uri = "http://localhost:8080" + request.getContextPath();
        if (press.equalsIgnoreCase("OK")) {
            String parmstr = "firstname=" + firstname + "&"
                    + "lastname=" + lastname;

            if (sex.equalsIgnoreCase("male"))
                uri += "/Mmm?" + parmstr;
            else if (sex.equalsIgnoreCase("female"))
                uri += "/Ggg?" + parmstr;
        } else
            uri += "/index.html";
        hc.executeMethod(gm = new GetMethod(uri));
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println(gm.getResponseBodyAsString());
        pw.flush();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("Sss: doPost");
//        PrintWriter writer = response.getWriter();
//        String firstName = request.getParameter("firstname");
//        String lastName = request.getParameter("lastname");
//        writer.write("Sss: doPost\n");
//        writer.write("firstname: " + firstName + " lastname: " + lastName + "\n");
        HttpClient hc = new HttpClient(); // 1
        PostMethod pm = new PostMethod("http://localhost:8080" // 2
                + request.getContextPath() + "/PostExample?press=OK"); // 3
        NameValuePair[] parms = { new NameValuePair("firstname", "Gurin"),// 4
                new NameValuePair("lastname", "Nik"), // 5
                new NameValuePair("sex", "male") }; // 6
        pm.addParameters(parms); // 7
        hc.executeMethod(pm); // 8
        if (pm.getStatusCode() == HttpStatus.SC_OK) { // 9
            InOutServlet inout = new InOutServlet(response.getOutputStream(), // 10
                    pm.getResponseBodyAsStream()); // 11
            inout.perform(); // 12
        } else // 13
            System.out.println("Sss:service:getStatusCode()=" // 14
                    + pm.getStatusCode());

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
