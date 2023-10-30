package com.derezhenko.server;

import com.derezhenko.dao.impl.CommentDao;
import com.derezhenko.model.CommentDto;
import com.derezhenko.model.PostDto;
import com.derezhenko.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/post")
public class PostServlet extends HttpServlet {
    int postId = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get post
        postId = Integer.parseInt(req.getParameter("id"));
        String sql = "SELECT title, text, date, u.name, u.photo, author_id FROM posts p  inner join users u on u.id = p.author_id WHERE p.id = ?";
        PostDto postDto = null;
        Connection connection = DatabaseConnectionUtil.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, postId);
            ResultSet resultSet = statement.executeQuery(); // выполнение запроса и получение результата
            if (resultSet.next()) {
                postDto = new PostDto(postId,
                        resultSet.getString("title"),
                        resultSet.getString("text"),
                        resultSet.getString("date"),
                        resultSet.getString("name"),
                        resultSet.getString("photo"),
                        resultSet.getInt("author_id"));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("post", postDto);

        //get comments
        CommentDao commentDao = new CommentDao();
        List<CommentDto> comments = commentDao.getAll();
        req.setAttribute("comments", comments);

        req.getRequestDispatcher("post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        int postId = Integer.parseInt(req.getParameter("id"));
        int authorId = Integer.parseInt((String) session.getAttribute("userId"));
        String text = req.getParameter("text");
        Date date = new Date();
        String dateStr = date.toString();
        CommentDto commentDto = new CommentDto(postId, authorId, text, dateStr);
        CommentDao commentDao = new CommentDao();
        commentDao.save(commentDto);
//        resp.sendRedirect("/post?id="+postId);
    }
}
