package com.derezhenko.server;

import com.derezhenko.dao.impl.UserDaoImpl;
import com.derezhenko.model.PostDto;
import com.derezhenko.model.User;
import com.derezhenko.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/user")
public class UserProfileServlet extends HttpServlet {

    private final UserDaoImpl userDao;

    public UserProfileServlet() {
        this.userDao = UserDaoImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id  = req.getParameter("id");
            int userId = Integer.parseInt(id);
            System.out.println(userId);

            User user = userDao.get(userId);
            System.out.println(user.getName());
            req.setAttribute("user", user);

            try {
                Connection connection = DatabaseConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT p.id, title, text, date, u.name, u.photo, author_id FROM posts p  inner join users u on u.id = p.author_id WHERE p.author_id = ?;");
                statement.setInt(1, userId);
                ResultSet resultSet = statement.executeQuery(); // выполнение запроса и получение результата
                List<PostDto> posts = new ArrayList<>();
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String text = resultSet.getString("text");
                    String date = resultSet.getString("date");
                    String authorName = resultSet.getString("name");
                    String photo = resultSet.getString("photo");
                    int authorId = resultSet.getInt("author_id");
                    int idPost = resultSet.getInt("id");
                    PostDto post = new PostDto(idPost, title, text, date, authorName, photo, authorId); // создание объекта User на основе полученных данных
                    posts.add(post);
                }
                req.setAttribute("posts", posts);
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            req.getRequestDispatcher("profile.jsp").forward(req, resp);
        } catch (NullPointerException ex) {
            req.getRequestDispatcher("404.jsp").forward(req, resp);
        }
    }
}
