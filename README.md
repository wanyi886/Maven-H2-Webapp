Practice project - Java Web Application with H2 Database
- User authentication(login/ register)
- Logged in user can change password
- H2 Database
- Servlet interface

To run the app locally:
mvn clean install
mvn jetty:run

Check database:
Run the app
Go to http://localhost:8080/h2-console
JDBC url: jdbc:h2:./data/mydb
Username: sa
Password: "" (leave it empty)

Click Connect

