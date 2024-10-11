package com.wlee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wlee.model.User;

public class UserDAO {
    public User findByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, sql);
            ResultSet resultS = pStatement.executeQuery();

            if (resultS.next()) {
                User user = new User(resultS.getString("email"), resultS.getString("password"));

                resultS.close();
                pStatement.close();
                conn.close();

                return user;
            }

            resultS.close();
            pStatement.close();
            conn.close();
            
        } catch( SQLException e) {
            System.err.println("Error finding user: " + e.getMessage());
            throw e;
        } 

        return null;
    }

    public void save(User user) throws SQLException {
        String sql = "INSERT INTO users (email, password) VALUES(?, ?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, user.getEmail());
            pStatement.setString(2, user.getPassword());
            pStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error saving user: " + e.getMessage());
            throw e;
        }
    }
}
