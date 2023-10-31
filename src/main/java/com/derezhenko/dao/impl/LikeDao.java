package com.derezhenko.dao.impl;

import com.derezhenko.dao.Dao;
import com.derezhenko.model.Like;
import com.derezhenko.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class LikeDao implements Dao<Like> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Like get(int id) {
        return null;
    }

    @Override
    public List<Like> getAll() {
        return null;
    }

    @Override
    public void save(Like like) {
        System.out.println("start saving...");
        String sql = "insert into likes (id_user, id_post) values (?, ?);";

        try {
            System.out.println("start data updating");
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, like.getUserId());
                preparedStatement.setInt(1, like.getPostId());
                System.out.println("datas updating end");

                int affectedRows = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean remove(Like like) {
        boolean flag = false;
        String sql = "delete from likes  WHERE id_user=? and id_post=?;";
        try {
            System.out.println("start data delete updating");
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, like.getUserId());
                preparedStatement.setInt(1, like.getPostId());
                System.out.println("datas delete updating end");

                int affectedRows = preparedStatement.executeUpdate();
                flag = true;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return flag;
    }
}
