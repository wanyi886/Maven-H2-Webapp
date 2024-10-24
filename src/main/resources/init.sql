DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL
);

-- H2 doesn't support INSERT IF NOT EXISTS, so use MERGE INTO 

MERGE INTO users (email, password) KEY(email) VALUES (
    'user1@test.com', 
    '$2a$12$IuDQlGQqHqPYMpvqr2EEY.EP16YjLMlLwEk2zLU/wg3hS.4QCM4fS'
);

