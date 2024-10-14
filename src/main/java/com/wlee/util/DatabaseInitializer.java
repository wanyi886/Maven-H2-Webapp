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
