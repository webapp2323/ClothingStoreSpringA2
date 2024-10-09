--liquibase formatted sql

--changeset author:insert_initial_data_pants
INSERT INTO Pants (name, brand, price, size, material) VALUES
                                                           ('Casual Pants', 'Brand A', 39.99, 'M', 'COTTON'),
                                                           ('Formal Pants', 'Brand B', 59.99, 'L', 'POLYESTER'),
                                                           ('Sport Pants', 'Brand C', 49.99, 'S', 'DENIM'),
                                                           ('Winter Pants', 'Brand D', 79.99, 'XL', 'COTTON'),
                                                           ('Chino Pants', 'Brand E', 45.00, 'M', 'COTTON');