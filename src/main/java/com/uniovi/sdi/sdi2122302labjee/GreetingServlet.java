package com.uniovi.sdi.sdi2122302labjee;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GreetingServlet", value = "/GreetingServlet") public class GreetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int contador = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello World!</TITLE></HEAD>");
        out.println("<BODY>");
        String name = request.getParameter("name");
        if (name != null) {
            out.println("Hello " + name + "<br>");
        }
        out.println("</BODY></HTML>");
        /* 2.1 Los Servlets son multihilo */
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
        }
        out.println("Thread ID: " + Thread.currentThread().getId() + "<br>");
        contador++;
        out.println("Visits:" + contador + "<br>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}