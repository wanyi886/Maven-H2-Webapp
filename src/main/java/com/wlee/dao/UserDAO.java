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
            pStatement.setString(1, email);
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

    public void add(User user) throws SQLException {
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

    public void updatePWD(String email, String newPWD) throws SQLException {
        String sql = "UPDATE users SET password = ? WHERE email = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, newPWD);
            pStatement.setString(2, email);
            
            int rowsAffected = pStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("No user found with email: " + email);
            }

        } catch (SQLException e) {
            System.err.println("Error updating Password" +  e.getMessage());
            throw e;
        }
    }
}
