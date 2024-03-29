package com.derezhenko.server;

import com.derezhenko.model.User;
import com.derezhenko.server.seevice.UserService;
import com.derezhenko.util.DatabaseConnectionUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();
    public static HttpSession session = null;

    private final UserService userService;

    public LoginServlet() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.getUserFromDatabase(username) != null) {
            User user = userService.getUserFromDatabase(username); // получение объекта User из базы данных по логину
            int userId = user.getId(); // получение айди пользователя из объекта User
            req.setAttribute("userId", userId);
            if (user.getPassword().equals(password) && username.equals(user.getName())) {
                // session
                session = req.getSession();
                req.setAttribute("username", user.getName());
                session.setAttribute("userId", String.valueOf(userId));
                session.setAttribute("username", username);
                session.setAttribute("email", user.getEmail());
                session.setAttribute("phone", user.getPhone_number());
                session.setAttribute("password", password);
                if(user.getPhoto() == null){
                    session.setAttribute("image-user", "26806.jpg");
                } else {
                    session.setAttribute("image-user", user.getPhoto());
                }

                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(cookie);

                resp.sendRedirect("/home");
            } else {
                resp.sendRedirect("/login");
            }
        } else {
//            req.getRequestDispatcher("home.jsp").forward(req, resp);
            resp.sendRedirect("/home");
        }
    }



    public static HttpSession getSession(){
        return session;
    }
}

