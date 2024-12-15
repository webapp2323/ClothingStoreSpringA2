--liquibase formatted sql

--changeset Owl:v4-create-order-items

CREATE TABLE clothing_items (
                                id BIGSERIAL PRIMARY KEY,               -- Уникальний ідентифікатор товару
                                name VARCHAR(255) NOT NULL,             -- Назва товару
                                size VARCHAR(50) NOT NULL,              -- Розмір товару (зберігається як рядок)
                                price DECIMAL(10, 2) NOT NULL,          -- Ціна товару
                                brand VARCHAR(50) NOT NULL,             -- Бренд товару (зберігається як рядок)
                                type VARCHAR(50) NOT NULL               -- Тип товару (зберігається як рядок)
);


INSERT INTO clothing_items (name, size, price, brand, type) VALUES
                                                                ('T-Shirt', 'M', 19.99, 'NIKE', 'SHIRT'),    -- Футболка за 19.99
                                                                ('Jeans', 'L', 49.99, 'ADIDAS', 'PANTS'),    -- Джинси за 49.99
                                                                ('Jacket', 'M', 89.99, 'PUMA', 'JACKET'),     -- Куртка за 89.99
                                                                ('Sweater', 'S', 39.99, 'UNDER_ARMOUR', 'SHIRT'), -- Светр за 39.99
                                                                ('Cargo Pants', 'L', 59.99, 'NIKE', 'PANTS');  -- Кюлоты за 59.99



CREATE TABLE order_items (
                             id BIGSERIAL PRIMARY KEY,
                             order_id BIGINT,
                             clothing_item_id BIGINT,
                             quantity INT NOT NULL,
                             unit_price DECIMAL(10, 2) NOT NULL,
                             created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             status VARCHAR(50) NOT NULL DEFAULT 'PENDING',  -- Доданий стовпець
                             FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
                             FOREIGN KEY (clothing_item_id) REFERENCES clothing_items(id) ON DELETE CASCADE
);

INSERT INTO order_items (order_id, clothing_item_id, quantity, unit_price, created_date) VALUES
                                                                                             (1, 1, 2, 29.99, '2024-12-14 23:57:55'),  -- Зазначення дати створення
                                                                                             (1, 2, 1, 49.99, '2024-12-14 23:57:55'),
                                                                                             (2, 1, 3, 29.99, '2024-12-14 23:57:55'),
                                                                                             (2, 3, 1, 39.99, '2024-12-14 23:57:55');  -- Додати 1 одиницю товару з id 3 до замовлення з id 2 за ціною 39.99

-- SELECT * FROM order_items WHERE id = 1;
-- SELECT column_name FROM information_schema.columns WHERE table_name = 'order_items';