import classes.CBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class Ccc extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        initContext();
    }

    private void initContext(){
        CBean cb = new CBean();
        ServletContext sc = getServletContext();
        sc.setAttribute("val1",cb.getVal1());
        sc.setAttribute("val2",cb.getVal2());
        sc.setAttribute("val3",cb.getVal3());
        sc.setAttribute("artCBean", cb);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        PrintWriter pw = response.getWriter();

        CBean cb;

        if(request.getParameter("URLn").equals("old")) {
            cb =(CBean)sc.getAttribute("artCBean");
        } else {
            cb = new CBean();
        }

        if(!request.getParameter("val1").isEmpty()) {
            cb.setVal1(request.getParameter("val1"));
            sc.setAttribute("val1",request.getParameter("val1"));
        }  else {
            cb.setVal1(cb.getVal1());
        }

        if(!request.getParameter("val2").isEmpty()){
            cb.setVal2(request.getParameter("val2"));
            sc.setAttribute("val2",request.getParameter("val2"));
        } else {
            cb.setVal2(cb.getVal2());
        }

        if(!request.getParameter("val3").isEmpty()){
            cb.setVal3(request.getParameter("val3"));
            sc.setAttribute("val3",request.getParameter("val3"));
        } else {
            cb.setVal3(cb.getVal3());
        }

        sc.setAttribute("artCBean",cb);
        Enumeration en = sc.getAttributeNames();
        String x;

        while (en.hasMoreElements()) {
            x = (String) en.nextElement();
            pw.println("<br />"+x + "= " + sc.getAttribute(x));
        }

        request.setAttribute("V1", cb.getVal1());
        request.setAttribute("V2", cb.getVal2());
        request.setAttribute("V3", cb.getVal3());
        request.getRequestDispatcher("/Ccc.jsp").forward(request,response);
    }
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        initContext();
//    }
//
//    private void initContext(){
//        CBean cb = new CBean();
//        ServletContext sc = getServletContext();
//        sc.setAttribute("val1",cb.getVal1());
//        sc.setAttribute("val2",cb.getVal2());
//        sc.setAttribute("val3",cb.getVal3());
//        sc.setAttribute("artCBean", cb);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletContext sc = getServletContext();
//        PrintWriter pw = response.getWriter();
//
//        CBean cb;
//
//        if(request.getParameter("URLn").equals("old")) {
//            cb =(CBean)sc.getAttribute("artCBean");
//        } else {
//            cb = new CBean();
//        }
//
//        if(!request.getParameter("val1").isEmpty()) {
//            cb.setVal1(request.getParameter("val1"));
//            sc.setAttribute("val1",request.getParameter("val1"));
//        }  else {
//            cb.setVal1((String) sc.getAttribute("val1"));
//        }
//
//        if(!request.getParameter("val2").isEmpty()){
//            cb.setVal2(request.getParameter("val2"));
//            sc.setAttribute("val2",request.getParameter("val2"));
//        } else {
//            cb.setVal2((String) sc.getAttribute("val2"));
//        }
//
//        if(!request.getParameter("val3").isEmpty()){
//            cb.setVal3(request.getParameter("val3"));
//            sc.setAttribute("val3",request.getParameter("val3"));
//        } else {
//            cb.setVal3((String) sc.getAttribute("val3"));
//        }
//
//        sc.setAttribute("artCBean",cb);
//        Enumeration en = sc.getAttributeNames();
//        String x;
//
//        while (en.hasMoreElements()) {
//            x = (String) en.nextElement();
//            pw.println("<br />"+x + "= " + sc.getAttribute(x));
//        }
//
//        request.setAttribute("V1", cb.getVal1());
//        request.setAttribute("V2", cb.getVal2());
//        request.setAttribute("V3", cb.getVal3());
//        request.getRequestDispatcher("/Ccc.jsp").forward(request,response);
//    }


}
