--liquibase formatted sql

--changeset Owl:create_jacket_table
CREATE TABLE IF NOT EXISTS Jacket (
                                      id SERIAL PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
    size VARCHAR(50) NOT NULL,
    color VARCHAR(50),
    price NUMERIC(10, 2) NOT NULL,
    material VARCHAR(50) NOT NULL,
    hasHood BOOLEAN NOT NULL
    );

INSERT INTO Jacket (name, size, color, price, material, hasHood) VALUES
                                                                     ('Light Jacket', 'M', 'Black', 89.99, 'POLYESTER', false),
                                                                     ('Winter Jacket', 'L', 'Navy', 129.99, 'COTTON', true),
                                                                     ('Leather Jacket', 'S', 'Brown', 199.99, 'LEATHER', false),
                                                                     ('Windbreaker', 'XL', 'Red', 59.99, 'NYLON', true),
                                                                     ('Denim Jacket', 'M', 'Blue', 79.99, 'DENIM', false);