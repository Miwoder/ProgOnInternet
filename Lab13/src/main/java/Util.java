import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class Util {
    public static String showRequest(HttpServletRequest request)
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
