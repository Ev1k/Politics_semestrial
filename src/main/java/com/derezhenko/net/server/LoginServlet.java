package com.derezhenko.net.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("login") && password.equals("qwerty")) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("main.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
//    public static final String  LOGIN = "login";
//    public static final String PASSWORD = "qwerty123";
//    public boolean rememberMe = false;
////    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("login.html");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String login = req.getParameter("login");
//        req.setAttribute("login", login);
//        String password = req.getParameter("password");
//        rememberMe = Boolean.parseBoolean(req.getParameter("rememberMe"));
//        if (LOGIN.equalsIgnoreCase(login) && PASSWORD.equals(password)) {
//            if (rememberMe){
//                Cookie cookie = new Cookie("username", login);
//                cookie.setMaxAge(24*60*60);
//                resp.addCookie(cookie);
//            }
//            HttpSession httpSession = req.getSession();
//            httpSession.setAttribute("username", login);
//            httpSession.setMaxInactiveInterval(60 * 60);
//            resp.sendRedirect("main.jsp");
//        } else {
//            resp.sendRedirect("/login");
//        }
//    }
}

