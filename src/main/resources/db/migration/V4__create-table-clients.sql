CREATE TABLE clients (
     id SERIAL PRIMARY KEY,
     email VARCHAR(150) NOT NULL UNIQUE,
     order_details TEXT NOT NULL,
     total_price DECIMAL(10, 2) NOT NULL,
     address VARCHAR(200) NOT NULL,
     order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

