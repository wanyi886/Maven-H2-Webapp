Practice project - Java Web Application with H2 Database
- User authentication(login)
- Logged in user can change password
- H2 Database
- Servlet interface

To run the app locally, run the command below:
- mvn clean install
- mvn jetty:run
- Go to http://localhost:8080/login

Check database:
- Run the app
- Go to http://localhost:8080/h2-console
- JDBC url: jdbc:h2:./data/mydb
- Username: sa
- Password: "" (leave it empty)
- Click Connect


To run the app with docker:
- mvn clean package
- docker build . -t maven-h2-webapp
- docker run -p 5012:5012 maven-h2-webapp
