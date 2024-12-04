--liquibase formatted sql

--changeset owl:v6-create-clothingItem

-- DROP TABLE IF EXISTS "clothing_items";

-- CREATE TABLE clothing_items (
--                                 id BIGSERIAL PRIMARY KEY,               -- Уникальний ідентифікатор товару
--                                 name VARCHAR(255) NOT NULL,             -- Назва товару
--                                 size VARCHAR(50) NOT NULL,              -- Розмір товару (зберігається як рядок)
--                                 price DECIMAL(10, 2) NOT NULL,          -- Ціна товару
--                                 brand VARCHAR(50) NOT NULL,             -- Бренд товару (зберігається як рядок)
--                                 type VARCHAR(50) NOT NULL               -- Тип товару (зберігається як рядок)
-- );
--
--
-- INSERT INTO clothing_items (name, size, price, brand, type) VALUES
--                                                                 ('T-Shirt', 'M', 19.99, 'NIKE', 'SHIRT'),    -- Футболка за 19.99
--                                                                 ('Jeans', 'L', 49.99, 'ADIDAS', 'PANTS'),    -- Джинси за 49.99
--                                                                 ('Jacket', 'M', 89.99, 'PUMA', 'JACKET'),     -- Куртка за 89.99
--                                                                 ('Sweater', 'S', 39.99, 'UNDER_ARMOUR', 'SHIRT'), -- Светр за 39.99
--                                                                 ('Cargo Pants', 'L', 59.99, 'NIKE', 'PANTS');  -- Кюлоты за 59.99
--
