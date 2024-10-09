--liquibase formatted sql

--changeset author:insert_initial_data_shirt
--changeset author:insert_initial_data_shirt
INSERT INTO Shirt (name, brand, price, sleeve_type, size, material) VALUES
                                                                        ('Casual Shirt', 'Brand A', 29.99, 'LONG', 'M', 'COTTON'),
                                                                        ('Formal Shirt', 'Brand B', 49.99, 'SHORT', 'L', 'POLYESTER'),
                                                                        ('T-Shirt', 'Brand C', 19.99, 'SLEEVELESS', 'S', 'NYLON'),
                                                                        ('Polo Shirt', 'Brand D', 35.00, 'SHORT', 'XL', 'DENIM'),
                                                                        ('Dress Shirt', 'Brand E', 59.99, 'LONG', 'M', 'WOOL');