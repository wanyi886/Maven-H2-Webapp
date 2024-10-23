# Need to use tomcat 9 instead of 10, cause we are using javax, not jakara
FROM tomcat:9.0

# Remove default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Add data directory
RUN mkdir -p /usr/local/tomcat/data && \
    chmod -R 777 /usr/local/tomcat/data

# Copy the WAR file into the container
COPY target/maven-h2-webapp.war /usr/local/tomcat/webapps/ROOT.war

# Make port 5012 available to the world outside this container
EXPOSE 5012

# Update server.xml to change the port to 5012
RUN sed -i 's/port="8080"/port="5012"/' /usr/local/tomcat/conf/server.xml

# Run Tomcat
CMD ["catalina.sh", "run"]