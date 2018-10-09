package ru.work.vladimirs.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//Аннотация значит что сервлет доступен по адресу <URL>/s
@WebServlet("/s")
public class MyServlet extends HttpServlet {

    //В данном случае страничку отображает jsp
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String varTextA = "Hello World!";
        req.setAttribute("textA", varTextA);
        String varTextB = "It JSP.";
        req.setAttribute("textB", varTextB);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    //В данном случае сообщение отображает сам сервлет
    /*    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Hello world");
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
