package com.wlee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:h2:./data/mydb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            // load the JDBC driver for the H2 database into memory
            // Class.forName() is a static method in Java that loads a class by its fully qualified name
            // this registers the driver with the Drivemanager;
            Class.forName("org.h2.driver");

        } catch (ClassNotFoundException e) {
            throw new SQLException("H2 JDBC Driver not found.", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
