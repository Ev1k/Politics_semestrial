package com.derezhenko.server;

import com.derezhenko.dao.impl.UserDaoImpl;
import com.derezhenko.model.User;
import com.derezhenko.util.DatabaseConnectionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
//    public static final String DRIVER = "org.postgresql.Driver";
//    public static final String URL = "jdbc:postgresql://localhost:5432/politics";
//    public static final String USER = "postgres";
//    public static final String PASSWORD = "rfrfirf12";

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("name");
        String uemail = req.getParameter("email");
        String upass = req.getParameter("pass");
        String uphone = req.getParameter("contact");
        req.setAttribute("uname", uname);
        req.setAttribute("uemail", uemail);
        req.setAttribute("upass", upass);
        req.setAttribute("uphone", uphone);
        User user = new User(uname, uemail, uphone, upass);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.save(user);

        int userId = user.getId();
        String sql = "UPDATE users SET photo = ? WHERE id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "26806.jpg");
            statement.setInt(2, userId);

            int rowsAffected = statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
