package com.derezhenko.server;

import com.derezhenko.model.User;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = getUserFromDatabase(username); // получение объекта User из базы данных по логину
        if (user != null) {
            int userId = user.getId(); // получение айди пользователя из объекта User
            req.setAttribute("userID", userId);
            if (user.getPassword().equals(password) && username.equals(user.getName())) {
                // session
                session = req.getSession();
                session.setAttribute("userId", String.valueOf(userId));
                session.setAttribute("username", username);
                if(user.getPhoto() == null){
                    session.setAttribute("image-user", "26806.jpg");
                } else {
                    session.setAttribute("image-user", user.getPhoto());
                }

                System.out.println(user.getPhoto());
//                session.setMaxInactiveInterval(60 * 60);


//                String sql = "UPDATE users SET photo = ? WHERE id = ?";
//                try{
//                    PreparedStatement statement = connection.prepareStatement(sql);
//                    statement.setString(1, "26806.jpg");
//                    statement.setInt(2, userId);
//
//                    int rowsAffected = statement.executeUpdate();
//
//                    statement.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }

                // cookie
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(cookie);

                resp.sendRedirect("/home");
            } else {
                resp.sendRedirect("/login");
            }
        } else {
//            resp.sendRedirect("/login");
        }
    }


    private User getUserFromDatabase(String name) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE name = ?");
            statement.setString(1, name); // установка значения параметра запроса
            ResultSet resultSet = statement.executeQuery(); // выполнение запроса и получение результата
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String phone_number = resultSet.getString("phone_number");
                user = new User(id, name, email, phone_number, password); // создание объекта User на основе полученных данных
            }
            resultSet.close();
            statement.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static HttpSession getSession(){
        return session;
    }
}

