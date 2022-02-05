import java.io.*;
import javax.servlet.*;

public class InOutServlet {
    protected InputStream ist;
    protected ServletOutputStream ost;
    public InOutServlet( ServletOutputStream ost, InputStream ist){
        this.ist = ist;
        this.ost = ost;
    }
    public void perform()throws IOException{
        int buf;
        while ((buf = this.ist.read()) > 0)
            this.ost.write(buf);
        this.ost.flush();
    }
} 