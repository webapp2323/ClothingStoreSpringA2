--liquibase formatted sql

--changeset author:insert_initial_data_jacket
INSERT INTO Jacket (name, size, color, price, material, hasHood) VALUES
                                                                     ('Light Jacket', 'M', 'Black', 89.99, 'POLYESTER', false),
                                                                     ('Winter Jacket', 'L', 'Navy', 129.99, 'COTTON', true),
                                                                     ('Leather Jacket', 'S', 'Brown', 199.99, 'LEATHER', false),
                                                                     ('Windbreaker', 'XL', 'Red', 59.99, 'NYLON', true),
                                                                     ('Denim Jacket', 'M', 'Blue', 79.99, 'DENIM', false);