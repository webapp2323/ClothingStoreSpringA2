--liquibase formatted sql

--changeset Owl:init1_script_DB


CREATE TABLE IF NOT EXISTS orders (
                                      id BIGSERIAL PRIMARY KEY,
                                      customer_name VARCHAR(255) NOT NULL,
                                      total_amount DECIMAL(10, 2) NOT NULL,
                                      status VARCHAR(50) NOT NULL,
                                      order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      user_id INTEGER NOT NULL,
                                      store_id INTEGER,
                                      FOREIGN KEY (user_id) REFERENCES users(id),
                                      FOREIGN KEY (store_id) REFERENCES store(id)
);


INSERT INTO orders (customer_name, total_amount, status, user_id, store_id, order_date) VALUES
                                                                                            ('John Doe', 100.50, 'PENDING', 1, 1, '2024-10-23 10:00:00'),
                                                                                            ('Jane Smith', 250.00, 'COMPLETED', 2, 2, '2024-10-24 11:30:00'),
                                                                                            ('Alice Johnson', 75.25, 'PENDING', 1, 1, '2024-10-25 09:15:00'),
                                                                                            ('Bob Brown', 300.00, 'SHIPPED', 3, 3, '2024-10-26 14:45:00'),
                                                                                            ('Charlie Black', 150.75, 'PENDING', 2, 2, '2024-10-27 16:20:00');

CREATE TABLE IF NOT EXISTS payments (
                                        id BIGSERIAL PRIMARY KEY,
                                        order_id BIGINT NOT NULL,
                                        amount DECIMAL(10, 2) NOT NULL,
                                        method VARCHAR(50) NOT NULL,
                                        payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

INSERT INTO payments (order_id, amount, method) VALUES
                                                    (1, 100.50, 'CREDIT_CARD'),
                                                    (2, 250.00, 'PAYPAL'),
                                                    (3, 75.25, 'BANK_TRANSFER'),
                                                    (4, 300.00, 'DEBIT_CARD'),
                                                    (5, 150.75, 'CASH');