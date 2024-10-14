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

-- -- Enable logging
-- SET TRACE_LEVEL_SYSTEM_OUT 3;

-- -- Log start of script execution
-- SELECT 'Executing init.sql script' FROM DUAL;

-- DROP TABLE IF EXISTS users;

-- SELECT 'Table dropped if existed' FROM DUAL;

-- CREATE TABLE IF NOT EXISTS users (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     email VARCHAR(50) NOT NULL UNIQUE,
--     password VARCHAR(255) NOT NULL
-- );

-- SELECT 'Table created' FROM DUAL;

-- -- H2 doesn't support INSERT IF NOT EXISTS, using MERGE instead

-- MERGE INTO users (email, password) KEY(email) VALUES ('user1@test.com', 'abc123');
-- SELECT 'Merged user1@test.com' FROM DUAL;

-- MERGE INTO users (email, password) KEY(email) VALUES ('user2@test.com', '***');
-- SELECT 'Merged user2@test.com' FROM DUAL;

-- MERGE INTO users (email, password) KEY(email) VALUES ('user3@test.com', 'helloworld');
-- SELECT 'Merged user3@test.com' FROM DUAL;

-- -- Log end of script execution
-- SELECT 'init.sql script execution completed' FROM DUAL;

-- -- Display final table contents
-- SELECT * FROM users;