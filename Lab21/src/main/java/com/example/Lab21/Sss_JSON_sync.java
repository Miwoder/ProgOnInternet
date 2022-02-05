package com.example.Lab21;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sss_JSON_sync extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    Integer n=null;
    private Random r = new Random();

    public Sss_JSON_sync() {
        super();
    }
    public Integer Get() {
        return (this.r.nextInt()%this.n);
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss_JSON_sync:doGet");
        n = new Integer(rq.getParameter("n"));
        System.out.println(n);
        rs.setContentType("text/xml");
        PrintWriter w = rs.getWriter();
        String s ="{\"X\":[" ;
        double ran = Math.random()*(10-4)+4;
        for (int i = 0; i < ran; i++)
        {
            s += ("{\"rand\":"+ Get().toString()+"}"+ ((i < ran-1)?",":" "));
        }
        s+="]}";
        System.out.println(s);
        w.println(s);
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss_JSON_sync:doPost");
        n = new Integer(rq.getHeader("XRand-N"));
        System.out.println(n);
        rs.setContentType("text/xml");
        PrintWriter w = rs.getWriter();
        String s ="{\"X\":[" ;
        double ran = Math.random()*(10-4)+4;
        for (int i = 0; i < ran; i++)
        {
            s += ("{\"rand\":"+ Get().toString()+"}"+ ((i < ran-1)?",":" "));
        }
        s+="]}";
        try {
            Thread.currentThread().sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        w.println(s);
    }

}
