package com.derezhenko.server;

import com.derezhenko.dao.impl.UserDaoImpl;
import com.derezhenko.model.User;
import com.derezhenko.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private final UserDaoImpl userDao;

    public RegistrationServlet() {
        this.userDao = UserDaoImpl.getInstance();
    }

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

        userDao.save(user);

        resp.sendRedirect("/login");
    }
}
