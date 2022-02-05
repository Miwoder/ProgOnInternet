package classes;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class Sex extends TagSupport {
    static String in = "<label>Sex&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp</label>"
            + "<input name =\"sex\" type = \"radio\" width = \"150\" maxlength= \"30\" value=\"male\" checked=\"checked\" />male"
            + "<input name =\"sex\" type = \"radio\" width = \"150\" maxlength= \"30\" value=\"female\" />female";

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(in);
        } catch (IOException e) {
            System.out.println("stafftag.classes.Sex: " + e);
        }
        return SKIP_BODY;
    }
}