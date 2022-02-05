package classes;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class Submit extends TagSupport {
    static String in = "<label>Submit&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp</label>"
            + "<input name =\"press\" type = \"submit\" value =\"OK\" size =\"20\"/>&nbsp"
            + "<input name =\"press\" type = \"submit\" value =\"Cancel\" size =\"20\"/>";

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(in);
        } catch (IOException e) {
            System.out.println("stafftag.classes.Submit: " + e);
        }
        return SKIP_BODY;
    }
}