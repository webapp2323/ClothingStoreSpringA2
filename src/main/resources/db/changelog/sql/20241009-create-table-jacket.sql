--liquibase formatted sql

--changeset Owl:create_jacket_table
CREATE TABLE IF NOT EXISTS jacket (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
                                        size VARCHAR(50) NOT NULL,
                                        color VARCHAR(50),
                                        price NUMERIC(10, 2) NOT NULL,
                                        material VARCHAR(50) NOT NULL,
                                        hasHood BOOLEAN NOT NULL
);

--changeset Owl:insert_jacket_data
INSERT INTO jacket (name, size, color, price, material, hasHood) VALUES
                                                                     ('Light Jacket', 'M', 'Blue', 89.99, 'POLYESTER', false),
                                                                     ('Winter Jacket', 'L', 'Black', 4129.99, 'COTTON', true),
                                                                     ('Leather Jacket', 'S', 'Brown', 4343.00, 'LEATHER', false),
                                                                     ('Windbreaker', 'XL', 'Red', 59.99, 'NYLON', true),
                                                                     ('Denim Jacket', 'M', 'Dark Blue', 79.99, 'DENIM', false);