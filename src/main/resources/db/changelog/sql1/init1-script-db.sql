-- CREATE TABLE IF NOT EXISTS orders (
--                                       id BIGSERIAL PRIMARY KEY,
--                                       customer_name VARCHAR(255) NOT NULL,
--                                       total_amount DECIMAL(10, 2) NOT NULL,
--                                       status VARCHAR(50) NOT NULL -- Зберігає статус як рядок
-- );
-- INSERT INTO orders (customer_name, total_amount, status) VALUES
--                                                              ('John Doe', 100.50, 'PENDING'),
--                                                              ('Jane Smith', 250.00, 'COMPLETED'),
--                                                              ('Alice Johnson', 75.25, 'PENDING'),
--                                                              ('Bob Brown', 300.00, 'SHIPPED'),
--                                                              ('Charlie Black', 150.75, 'PENDING');



-- CREATE TABLE IF NOT EXISTS payments (
--                                         id BIGSERIAL PRIMARY KEY,
--                                         order_id BIGINT NOT NULL,
--                                         amount DECIMAL(10, 2) NOT NULL,
--                                         method VARCHAR(50) NOT NULL,
--                                         payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--                                         FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
-- );
--
-- INSERT INTO payments (order_id, amount, method) VALUES
--                                                     (1, 100.50, 'CREDIT_CARD'),
--                                                     (2, 250.00, 'PAYPAL'),
--                                                     (3, 75.25, 'BANK_TRANSFER'),
--                                                     (4, 300.00, 'DEBIT_CARD'),
--                                                     (5, 150.75, 'CASH');                                                  (5, 150.75, 'CASH');