package com.derezhenko.model;

import com.derezhenko.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    int id;
    private String name;
    private String email;
    private String phone_number;
    private String password;
    private String photo = "26806.jpg";

    public User(String name, String email, String phone_number, String password) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }

    public User(int id, String name, String email, String phone_number, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }

    public User(int id, String name, String email, String phone_number, String password, String photo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        Connection connection = DatabaseConnectionUtil.getConnection();
        //получение фото из бд
        String sqlGet = "SELECT photo FROM users WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlGet);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                photo = resultSet.getString("photo");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;

    }
}
