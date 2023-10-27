package com.derezhenko.server;

import com.derezhenko.dao.impl.UserDaoImpl;
import com.derezhenko.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/*")
public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] uri = req.getRequestURI().split("/");
        System.out.println(req.getRequestURI());
        int userId = Integer.parseInt(uri[uri.length - 1]);
        System.out.println(userId);
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.get(userId);
        System.out.println(user.getName());
//        if(user == null) {
//            req.getRequestDispatcher("404.jsp").forward(req, resp);
//            return;
//        }


        req.getRequestDispatcher("profile.jsp").forward(req, resp);
        return;
    }
}
