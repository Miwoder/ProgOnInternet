package jspclass;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Regimex {
    protected String R = null;
    Calendar C;
    protected Date d = new Date();
    SimpleDateFormat sFormat = new SimpleDateFormat("dd.MM.yyyy");
    public Regimex(Calendar c) {
        this.C = c;
    }
    public Regimex() {
        this.C = Calendar.getInstance();
    }

    public Integer GetHOUR() {
        return ((Integer)C.get(Calendar.HOUR_OF_DAY));
    }
    public Integer GetDAY() { return  ((Integer)C.get(Calendar.DAY_OF_WEEK)); }
    public String GetDATE() { return sFormat.format(d.getTime()); }

    public String Salutation(Integer h) {
        String rc = "Good ";
        if ((h > 0) && (h <= 5))
            rc += "night";
        else if ((h > 5) && (h <= 12))
            rc += "morning";
        else if ((h > 12) && (h <= 17))
            rc += "afternoon";
        else
            rc += "evening";
        rc += "\n\n";
        return rc;
    }

    public Integer GetDayOfWeek() {
        int var1 = this.C.get(Calendar.DAY_OF_WEEK) - 1;
        return var1 == 0 ? 7 : this.C.get(7) - 1;
    }

    public String AddDay(Integer inc) {
        this.C.add(Calendar.DAY_OF_YEAR, inc);
        return this.sFormat.format(this.C.getTime());
    }

}