package com.derezhenko.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
//        session.removeAttribute("username");
//        req.removeAttribute("username");
//        session = null;
        req.getRequestDispatcher("login.ftl").forward(req, resp);
////        resp.sendRedirect("login.ftl");
    }
}
