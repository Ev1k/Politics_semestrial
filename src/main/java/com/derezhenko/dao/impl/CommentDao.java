package com.derezhenko.dao.impl;

import com.derezhenko.dao.Dao;
import com.derezhenko.model.Comment;
import com.derezhenko.model.CommentDto;
import com.derezhenko.model.User;
import com.derezhenko.server.PostServlet;
import com.derezhenko.util.DatabaseConnectionUtil;
import com.sun.net.httpserver.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao implements Dao<CommentDto> {

    private volatile static CommentDao INSTANCE;
    private static Object lock = new Object();

    public static CommentDao getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            synchronized (lock) {
                INSTANCE = new CommentDao();
                return INSTANCE;
            }
        }
    }

    private final Connection connection;
    private CommentDao(){
        this.connection = DatabaseConnectionUtil.getConnection();
    }
    @Override
    public CommentDto get(int id) {
        return null;
    }

    @Override
    public List<CommentDto> getAll() {
        return null;
//        int postId =
//        List<CommentDto> comments = new ArrayList<>();
//        String sql = "SELECT c.id, id_post, id_author, text, date, u.name, u.photo FROM comments c inner join users u on u.id = c.id_author WHERE id_post=?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)){
//            statement.setInt(1, P);
//            ResultSet resultSet = statement.executeQuery(sql);
//            if (resultSet != null) {
//                while (resultSet.next()) {
//                    comments.add(
//                        new CommentDto(
//                            resultSet.getInt("id"),
//                            resultSet.getInt("id_post"),
//                            resultSet.getInt("id_author"),
//                            resultSet.getString("text"),
//                            resultSet.getString("name"),
//                            resultSet.getString("photo"),
//                            resultSet.getString("date")
//                        )
//                    );
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return comments;
    }

    @Override
    public void save(CommentDto commentDto) {
        String sql = "insert into comments (id_post, id_author, text, date) values (?, ?, ?, ?);";
        try {
            System.out.println("start data updating");
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, commentDto.getIdPost());
                preparedStatement.setInt(2, commentDto.getIdAuthor());
                preparedStatement.setString(3, commentDto.getText());
                preparedStatement.setString(4, commentDto.getDate());
                System.out.println("datas updating end");

                int affectedRows = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
