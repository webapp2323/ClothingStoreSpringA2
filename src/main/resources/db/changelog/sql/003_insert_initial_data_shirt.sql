--liquibase formatted sql

--changeset author:insert_initial_data_shirt

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

INSERT INTO shirt (brand, material, name, price, size, sleeve_type)
VALUES (?, ?, ?, ?, ?, 'LONG'::sleeve_type_enum) RETURNING id;