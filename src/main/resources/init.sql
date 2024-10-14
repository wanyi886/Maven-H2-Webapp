DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- H2 doesn't support INSERT IF NOT EXISTS

MERGE INTO users (email, password) KEY(email) VALUES ('user1@test.com', 'abc123');
MERGE INTO users (email, password) KEY(email) VALUES ('user2@test.com', '***');
MERGE INTO users (email, password) KEY(email) VALUES ('user3@test.com', 'helloworld');
