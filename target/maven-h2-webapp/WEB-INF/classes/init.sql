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
MERGE INTO users (email, password) KEY(email) VALUES (
    'user2@test.com', 
    '$2a$12$WuQxL5.3/ZFj3hqhv9Tt6.GEh8RRdwHZZ1wcHhW5QVrRJ/3fB7eYW'
);
MERGE INTO users (email, password) KEY(email) VALUES (
    'user3@test.com', 
    '$2a$12$12jFxBBqXPjF9Cwf1KJau.gw2YUcmUpTc8jBh/0FlMQQHXZmJJ2Cq'
);
