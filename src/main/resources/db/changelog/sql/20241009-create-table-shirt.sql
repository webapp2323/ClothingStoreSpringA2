

--changeset Owl:create_enum_types
CREATE TYPE sleeve_type_enum AS ENUM ('SHORT', 'LONG', 'SLEEVELESS');
CREATE TYPE size_enum AS ENUM ('S', 'M', 'L', 'XL');
CREATE TYPE material_enum AS ENUM ('COTTON', 'LEATHER', 'POLYESTER', 'NYLON', 'DENIM', 'WOOL', 'FLEECE', 'SUEDE', 'LINEN', 'VINYL');


--changeset Owl:create_table_shirt
CREATE TABLE IF NOT EXISTS shirt  (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       brand VARCHAR(255) NOT NULL,
                       price DECIMAL NOT NULL,
                       size size_enum NOT NULL,
                       material material_enum NOT NULL,
                       sleeve_type sleeve_type_enum NOT NULL
);

--liquibase update

--liquibase formatted sql

--changeset Owl:insert_initial_data_shirt
INSERT INTO Shirt (name, brand, price, sleeve_type, size, material) VALUES
                                                                        ('Casual Shirt', 'Brand A', 29.99, 'LONG', 'M', 'COTTON'),
                                                                        ('Formal Shirt', 'Brand B', 49.99, 'SHORT', 'L', 'POLYESTER'),
                                                                        ('T-Shirt', 'Brand C', 19.99, 'SLEEVELESS', 'S', 'NYLON'),
                                                                        ('Polo Shirt', 'Brand D', 35.00, 'SHORT', 'XL', 'DENIM'),
                                                                        ('Dress Shirt', 'Brand E', 59.99, 'LONG', 'M', 'WOOL');

--changeset author:insert_initial_data_shirt
INSERT INTO Shirt (name, brand, price, sleeve_type, size, material) VALUES
                                                                        ('Lightweight Shirt', 'Brand F', 24.99, 'LONG', 'S', 'LINEN'),
                                                                        ('Business Casual Shirt', 'Brand G', 45.00, 'SHORT', 'M', 'COTTON'),
                                                                        ('Graphic Tee', 'Brand H', 15.99, 'SLEEVELESS', 'L', 'COTTON'),
                                                                        ('Classic Polo', 'Brand I', 32.50, 'SHORT', 'XL', 'POLYESTER'),
                                                                        ('Evening Dress Shirt', 'Brand J', 67.49, 'LONG', 'L', 'VINYL');

SELECT column_name, data_type
FROM information_schema.columns
WHERE table_name = 'shirt';



INSERT INTO shirt (brand, material, name, price, size, sleeve_type) VALUES
                                                                        ('Brand A', 'COTTON', 'Casual Shirt', 29.99, 'M', 'LONG'),
                                                                        ('Brand B', 'POLYESTER', 'Formal Shirt', 49.99, 'L', 'SHORT'),
                                                                        ('Brand C', 'NYLON', 'T-Shirt', 19.99, 'S', 'SLEEVELESS'),
                                                                        ('Brand D', 'DENIM', 'Polo Shirt', 35.00, 'XL', 'SHORT'),
                                                                        ('Brand E', 'WOOL', 'Dress Shirt', 59.99, 'M', 'LONG');

INSERT INTO shirt (brand, material, name, price, size, sleeve_type) VALUES
                                                                        ('Brand A', 'COTTON', 'Casual Shirt', 29.99, 'M', 'LONG'),
                                                                        ('Brand B', 'POLYESTER', 'Formal Shirt', 49.99, 'L', 'SHORT'),
                                                                        ('Brand C', 'NYLON', 'T-Shirt', 19.99, 'S', 'SLEEVELESS'),
                                                                        ('Brand D', 'DENIM', 'Polo Shirt', 35.00, 'XL', 'SHORT'),
                                                                        ('Brand E', 'WOOL', 'Dress Shirt', 59.99, 'M', 'LONG');
