--liquibase formatted sql

--changeset Owl:test-old-payments



INSERT INTO payments (order_id, amount, method, payment_date) VALUES
                                                                  (1, 100.00, 'Credit Card', '2022-11-01 10:00:00'),
                                                                  (2, 200.00, 'PayPal', '2022-12-15 15:30:00'),
                                                                  (3, 150.00, 'Bank Transfer', '2022-01-20 12:45:00'),
                                                                  (4, 250.00, 'Cash', '2022-09-10 09:00:00');