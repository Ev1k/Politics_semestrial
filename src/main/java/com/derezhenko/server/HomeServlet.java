package com.derezhenko.server;

import com.derezhenko.dao.impl.PostDao;
import com.derezhenko.model.Post;
import com.derezhenko.model.PostDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("userId"));
        HttpSession session = LoginServlet.getSession();
        int userId = Integer.parseInt((String) session.getAttribute("userId"));

        PostDao postDao = new PostDao();
        List<PostDto> posts = postDao.getAllDto();
        req.setAttribute("posts", posts);

        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
