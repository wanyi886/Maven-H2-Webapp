package com.wlee.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.wlee.dao.DatabaseConnection;

public class DatabaseInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        
            // Add this at the start to test passwords
            System.out.println("\n=====================================");
            System.out.println("Testing Password Hash");
            System.out.println("=====================================");
            
            // Test existing hash
            String existingHash = "$2a$12$LQv3c1yqBWVHxkd0LHAkCOYz6TtxMQJqhN8/LewqBasJ.j6ynipna";
            String password = "abc123";
            
            System.out.println("Testing existing hash in database:");
            boolean matches = PasswordUtils.checkPassword(password, existingHash);
            System.out.println("Password 'abc123' matches existing hash: " + matches);
            
            // Generate new hash
            System.out.println("\nGenerating new hash for 'abc123':");
            String newHash = PasswordUtils.hashPassword(password);
            System.out.println("New hash: " + newHash);
            
            // Test new hash
            boolean verifyNew = PasswordUtils.checkPassword(password, newHash);
            System.out.println("New hash verification: " + verifyNew);
            
            System.out.println("\nUse this SQL in your init.sql:");
            System.out.println("MERGE INTO users (email, password) KEY(email) VALUES ('user1@test.com', '" + newHash + "');");
            System.out.println("=====================================\n");




        
        try { 
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            
            String resourcePath = "/init.sql";

            // get the input stream from sql file
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);

            if (inputStream == null) {
                throw new IllegalStateException("Cannot find init.sql file at " + resourcePath );
            }

            // converts the byte stream to a character stream
            InputStreamReader streamReader = new InputStreamReader(inputStream);

            // wraps it in a BufferedReader
            BufferedReader reader = new BufferedReader(streamReader);

            String line;
            StringBuilder sBuilder = new StringBuilder();

            // reads the file line by line
            while( (line = reader.readLine()) != null) {
                
                line = line.trim();

                // skip empty lines and comments, to prevent sql execution error
                if (line.isEmpty() || line.startsWith("--")) {
                    continue;
                }


                sBuilder.append(line);

                if (line.endsWith(";")) {
                    statement.execute(sBuilder.toString());
                    sBuilder.setLength(0);
                }
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }
}
