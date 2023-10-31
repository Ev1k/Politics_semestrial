package com.derezhenko.dao.impl;

import com.derezhenko.dao.Dao;
import com.derezhenko.model.Post;
import com.derezhenko.model.PostDto;
import com.derezhenko.model.PostLikes;
import com.derezhenko.model.User;
import com.derezhenko.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao implements Dao<Post> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Post get(int id) {
        return null;
    }

    @Override
    public List<Post> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from posts";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Post> posts = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    posts.add(
                            new Post(resultSet.getInt("id"),
                                    resultSet.getString("title"),
                                    resultSet.getString("text"),
                                    resultSet.getString("date"),
                                    resultSet.getInt("author_id"))
                    );
                }
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PostDto> getAllDto() {
        String sql = "SELECT p.id, title, text, date, u.name, u.photo, author_id FROM posts p  inner join users u on u.id = p.author_id";
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            List<PostDto> posts = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    posts.add(
                            new PostDto(resultSet.getInt("id"),
                                    resultSet.getString("title"),
                                    resultSet.getString("text"),
                                    resultSet.getString("date"),
                                    resultSet.getString("name"),
                                    resultSet.getString("photo"),
                                    resultSet.getInt("author_id"))
                    );
                }
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Post post) {
        System.out.println("start saving...");
        String sql = "insert into posts (title, text, date, author_id) values (?, ?, ?, ?);";

        try {
            System.out.println("start data updating");
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, post.getTitle());
                preparedStatement.setString(2, post.getText());
                preparedStatement.setString(3, post.getDate());
                preparedStatement.setInt(4, post.getAuthorId());
                System.out.println("datas updating end");

                int affectedRows = preparedStatement.executeUpdate();
//
//                if (affectedRows != 1) {
//                    throw new SQLException("Cannot insert course");
//                }
//                try (ResultSet generatedIds = preparedStatement.getGeneratedKeys()){
//                    if (generatedIds.next()) {
//                        post.setId(generatedIds.getInt("id"));
//                    } else {
//                        throw new SQLException("Cannot retrieve id");
//                    }
//                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public List<PostLikes> getListPostLikes(int userId) {
        String sql = "SELECT p.id, title, text, date, author_id, u.photo, u.name, (SELECT count(*) from comments c WHERE p.id = c.id_post) as count_comment,\n" +
                "       (SELECT count(*) FROM  likes l where p.id = l.id_post) as count_like,\n" +
                "       (SELECT 1\n" +
                "        from likes l\n" +
                "        WHERE p.id = l.id_post and l.id_user= ? ) as has_like\n" +
                " from posts p inner join users u on u.id = p.author_id";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            List<PostLikes> posts = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    posts.add(
                            new PostLikes(resultSet.getInt("id"),
                                    resultSet.getString("title"),
                                    resultSet.getString("text"),
                                    resultSet.getString("date"),
                                    resultSet.getInt("author_id"),
                                    resultSet.getString("photo"),
                                    resultSet.getString("name"),
                                    resultSet.getInt("count_comment"),
                                    resultSet.getInt("count_like"),
                                    resultSet.getInt("has_like"))
                    );
                }
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
