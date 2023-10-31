package com.derezhenko.server;

import com.derezhenko.dao.impl.PostDao;
import com.derezhenko.model.Post;
import com.derezhenko.model.PostDto;
import com.derezhenko.model.PostLikes;

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
        String href = "/home";
        HttpSession session = LoginServlet.getSession();
        if(session != null) {
            int userId = Integer.parseInt((String) session.getAttribute("userId"));

            href = "/new-post";
        }
        req.setAttribute("href", href);
//        req.setAttribute("user", user);
        PostDao postDao = new PostDao();
        List<PostLikes> posts = postDao.getListPostLikes(Integer.parseInt((String) session.getAttribute("userId")));
        req.setAttribute("posts", posts);

        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
