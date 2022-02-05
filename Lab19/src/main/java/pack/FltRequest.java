package pack;
import javax.servlet.http.*;

public class FltRequest extends HttpServletRequestWrapper implements HttpServletRequest {
    protected String AA = null;
    protected String BB = null;
    protected String CC = null;
    public FltRequest(HttpServletRequest request) {
        super(request);
        if (request.getClass().getName().equals("flt.FltRequest")){
            this.AA = ((FltRequest)request).GetAA();
            this.BB = ((FltRequest)request).GetBB();
            this.CC = ((FltRequest)request).GetCC();
        }
    }
    public FltRequest(FltRequest request) {
        super((HttpServletRequest)request);
        this.AA = request.GetAA();
        this.BB = request.GetBB();
        this.CC = request.GetCC();
    }
    public void SetAA(String aa) {
        this.AA = aa;
    }

    public String GetAA() {
        return this.AA;
    }
    public void SetBB(String bb) {
        this.BB = bb;
    }
    public String GetBB() {
        return this.BB;
    }
    public void SetCC(String cc) {
        this.CC = cc;
    }

    public String GetCC() {
        return this.CC;
    }
}