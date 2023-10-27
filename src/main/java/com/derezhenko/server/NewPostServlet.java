package com.derezhenko.server;

import com.derezhenko.dao.impl.PostDao;
import com.derezhenko.model.Post;
import com.derezhenko.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

@WebServlet(urlPatterns = "/new-post")
public class NewPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("newPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        HttpSession session = req.getSession();
        int userId = Integer.parseInt((String) session.getAttribute("userId"));
        Date date = new Date();
        String dateStr = date.toString();

        Post post = new Post(title, text, dateStr, userId);
        PostDao postDao = new PostDao();
        postDao.save(post);
        resp.sendRedirect("/home");
    }
}
