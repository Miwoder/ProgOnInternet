package com.example.Lab21;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Sss_Header", value = "/sss_header")
public class Sss_Header extends javax.servlet.http.HttpServlet
        implements  javax.servlet.Servlet {
    public Sss_Header() {
        super();
    }
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss:doGet");
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss:doPost");
        System.out.println(rq.getHeader("Value-X"));
        System.out.println(rq.getHeader("Value-Y"));
        Float x = new Float(rq.getHeader("Value-X"));
        Float y = new Float(rq.getHeader("Value-Y"));
        Float z = x + y;
        System.out.println(z.toString());
        rs.setHeader("Value-Z", z.toString());
        try {
            Thread.sleep(10000);
        } catch(Exception e) {

        }
    }
}

