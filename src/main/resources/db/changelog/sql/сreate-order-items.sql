--liquibase formatted sql

--changeset Owl:create-clothing_items-order-items

CREATE TABLE clothing_items (
                                id BIGSERIAL PRIMARY KEY,
                                name VARCHAR(255) NOT NULL,      -- Назва товару
                                price DECIMAL(10, 2) NOT NULL    -- Ціна товару
);
INSERT INTO clothing_items (name, price) VALUES
                                             ('T-Shirt', 19.99),   -- Футболка за 19.99
                                             ('Jeans', 49.99),     -- Джинси за 49.99
                                             ('Jacket', 89.99),    -- Куртка за 89.99
                                             ('Sweater', 39.99),   -- Светр за 39.99
                                             ('Shoes', 59.99);      -- Черевики за 59.99


CREATE TABLE order_items (
                             id BIGSERIAL PRIMARY KEY,
                             order_id BIGINT,
                             clothing_item_id BIGINT,
                             quantity INT NOT NULL,
                             unit_price DECIMAL(10, 2) NOT NULL,
                             FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
                             FOREIGN KEY (clothing_item_id) REFERENCES clothing_items(id) ON DELETE CASCADE
);

INSERT INTO order_items (order_id, clothing_item_id, quantity, unit_price) VALUES
                                                                               (1, 1, 2, 29.99),  -- Додати 2 одиниці товару з id 1 до замовлення з id 1 за ціною 29.99
                                                                               (1, 2, 1, 49.99),  -- Додати 1 одиницю товару з id 2 до замовлення з id 1 за ціною 49.99
                                                                               (2, 1, 3, 29.99),  -- Додати 3 одиниці товару з id 1 до замовлення з id 2 за ціною 29.99
                                                                               (2, 3, 1, 39.99);  -- Додати 1 одиницю товару з id 3 до замовлення з id 2 за ціною 39.99