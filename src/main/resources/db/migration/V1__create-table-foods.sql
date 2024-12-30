CREATE TABLE foods (
       id SERIAL PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       image TEXT NOT NULL,
       type VARCHAR(255) NOT NULL,
       description VARCHAR(255) NOT NULL,
       price FLOAT NOT NULL
);