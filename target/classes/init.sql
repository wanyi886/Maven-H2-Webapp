CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(2545) NOT NULL
);

INSERT INTO users (email, password) VALUES ('test', 'abc123');
INSERT INTO users (email, password) VALUES ('ABCUUU', '***');
INSERT INTO users (email, password) VALUES ('helloworld', 'helloworld');