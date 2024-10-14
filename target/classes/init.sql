CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(2545) NOT NULL
);

-- H2 doesn't support INSERT IF NOT EXISTS

INSERT INTO users (email, password)
SELECT 'test', 'abc123'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'test');

INSERT INTO users (email, password)
SELECT 'ABCUUU', '***'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'ABCUUU');

INSERT INTO users (email, password)
SELECT 'helloworld', 'helloworld'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'helloworld');