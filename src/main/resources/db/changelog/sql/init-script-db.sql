--liquibase formatted sql

--changeset Owl:init_script_DB
--preconditions onFail:MARK_RAN

--precondition-sql-check expectedResult:0 SELECT count(*) FROM information_schema.tables WHERE table_name = 'jacket';

CREATE TABLE IF NOT EXISTS jacket (
                                      id SERIAL PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,  -- Добавлен столбец brand
    size VARCHAR(50) NOT NULL,
    color VARCHAR(50),
    price NUMERIC(10, 2) NOT NULL,
    material VARCHAR(50) NOT NULL,
    has_Hood BOOLEAN NOT NULL
    );

INSERT INTO jacket (name, brand, size, color, price, material, has_Hood) VALUES
                                                                            ('Light Jacket', 'BrandA', 'M', 'Blue', 89.99, 'POLYESTER', false),
                                                                            ('Winter Jacket', 'BrandB', 'L', 'Black', 129.99, 'COTTON', true),
                                                                            ('Leather Jacket', 'BrandC', 'S', 'Brown', 343.00, 'LEATHER', false),
                                                                            ('Windbreaker', 'BrandD', 'XL', 'Red', 59.99, 'NYLON', true),
                                                                            ('Denim Jacket', 'BrandE', 'M', 'Dark Blue', 79.99, 'DENIM', false);

CREATE TABLE IF NOT EXISTS pants (
                                     id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     brand VARCHAR(255) NOT NULL,
                                     price NUMERIC(10, 2) NOT NULL,
                                     size VARCHAR(50) NOT NULL,
                                     color VARCHAR(50) NOT NULL,
                                     material VARCHAR(50) NOT NULL
);

INSERT INTO pants (name, brand, price, size, color,material) VALUES
('Casual Pants', 'Brand A', 39.99, 'M','RED',  'COTTON'),         ('Formal Pants', 'Brand B', 59.99, 'L','BLUE', 'POLYESTER'),     ('Sport Pants', 'Brand C', 49.99, 'S', 'GREEN', 'DENIM'),
('Winter Pants', 'Brand D', 79.99, 'XL', 'YELLOW', 'COTTON'),        ('Chino Pants', 'Brand E', 45.00, 'M','BLACK', 'COTTON');

CREATE TABLE IF NOT EXISTS shirt (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     brand VARCHAR(255) NOT NULL,
                                     price NUMERIC(10, 2) NOT NULL,
                                     size VARCHAR(20) NOT NULL,
                                     color VARCHAR(50) NOT NULL,
                                     material VARCHAR(255) NOT NULL,
                                     sleeve_type VARCHAR(100) NOT NULL
);

INSERT INTO shirt (name, brand, price, sleeve_type, size, material,color) VALUES
('Casual Shirt', 'Brand A', 29.99, 'LONG', 'M', 'COTTON', 'GRAY'), ('Formal Shirt', 'Brand B', 49.99, 'SHORT', 'L', 'POLYESTER', 'RED'), ('T-Shirt', 'Brand C', 19.99, 'SLEEVELESS', 'S', 'NYLON', 'BLUE'),('Polo Shirt', 'Brand D', 35.00, 'SHORT', 'XL', 'DENIM','GREEN'),            ('Dress Shirt', 'Brand E', 59.99, 'LONG', 'M', 'WOOL','YELLOW'),('Lightweight Shirt', 'Brand F', 24.99, 'LONG', 'S', 'LINEN','BLACK'),                                            ('Business Casual Shirt', 'Brand G', 45.00, 'SHORT', 'M', 'COTTON','WHITE'),('Graphic Tee', 'Brand H', 15.99, 'SLEEVELESS', 'L', 'COTTON',' ORANGE'),('Classic Polo', 'Brand I', 32.50, 'SHORT', 'XL', 'POLYESTER','PURPLE'),                     ('Evening Dress Shirt', 'Brand J', 67.49, 'LONG', 'L', 'VINYL','PINK');


CREATE TABLE IF NOT EXISTS store (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL UNIQUE,
                                     location VARCHAR(255) NOT NULL,
                                     contact_email VARCHAR(255) NOT NULL UNIQUE,
                                     established_date DATE CHECK (established_date <= CURRENT_DATE)
);

CREATE TABLE IF NOT EXISTS users (
                                      id SERIAL PRIMARY KEY,
                                      username VARCHAR(255) NOT NULL UNIQUE,
                                      password VARCHAR(255) NOT NULL,
                                      email VARCHAR(255) NOT NULL UNIQUE,
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS role (
                                    id SERIAL PRIMARY KEY,
                                    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS user_role (
                                         user_id INTEGER NOT NULL,
                                         role_id INTEGER NOT NULL,
                                         PRIMARY KEY (user_id, role_id),
                                         FOREIGN KEY (user_id) REFERENCES users(id),
                                         FOREIGN KEY (role_id) REFERENCES role(id)
);



INSERT INTO store (name, location, contact_email, established_date) VALUES
('Fashion Hub', 'Київ, вул. Хрещатик, 1', 'contact@fashionhub.ua', '2010-05-15'),('Style Point', 'Львів, пр. Свободи, 25', 'info@stylepoint.ua', '2015-08-22'),('Urban Wear', 'Одеса, вул. Дерибасівська, 10', 'sales@urbanwear.ua', '2018-11-30');

INSERT INTO users (username, password, email) VALUES
('ivan123', '$2a$10$yJougGA.V5UXeWMZ6qDQsep1ANpUuhOeloS3fqYDotN.ROY45/ihG', 'ivan@ua.example.com'),                                               ('maria456', '$2a$10$yJougGA.V5UXeWMZ6qDQsep1ANpUuhOeloS3fqYDotN.ROY45/ihG', 'maria@ua.example.com'),                                                   ('alex789', '$2a$10$yJougGA.V5UXeWMZ6qDQsep1ANpUuhOeloS3fqYDotN.ROY45/ihG', 'alex@ua.example.com');

-- пароль "test"
INSERT INTO role (name) VALUES
                            ('ROLE_USER'),
                            ('ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES
                                             (1, 1),
                                             (2, 1),
                                             (3, 2);





