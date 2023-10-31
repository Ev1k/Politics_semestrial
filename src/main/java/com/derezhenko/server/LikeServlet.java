package com.derezhenko.server;

import com.derezhenko.dao.impl.LikeDao;
import com.derezhenko.model.Like;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/like")
public class LikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPost = Integer.parseInt(req.getParameter("id_post"));
        int userId = Integer.parseInt((String) req.getSession().getAttribute("userId"));
        System.out.println(idPost + " like");
        Like like = new Like(userId, idPost);
        LikeDao likeDao = new LikeDao();
        likeDao.save(like);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPost = Integer.parseInt(req.getParameter("id_post"));
        int userId = Integer.parseInt((String)req.getSession().getAttribute("userId"));

        System.out.println(idPost + " dislike");
        Like like = new Like(userId, idPost);
        LikeDao likeDao = new LikeDao();
        likeDao.remove(like);
    }
}
