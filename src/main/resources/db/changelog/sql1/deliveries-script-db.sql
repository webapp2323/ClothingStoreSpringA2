--liquibase formatted sql

--changeset Owl:added deliveries


CREATE TABLE IF NOT EXISTS deliveries (
                                          id SERIAL PRIMARY KEY,
                                          order_id INT NOT NULL,
                                          delivery_address VARCHAR(255),
    delivery_date DATE,
    delivery_type VARCHAR(50),
    status VARCHAR(50),
    FOREIGN KEY (order_id) REFERENCES "orders"(id)
    );

INSERT INTO deliveries (order_id, delivery_address, delivery_date, delivery_type, status) VALUES
                                                                                              (1, '123 Main St, Cityville', '2024-10-23', 'STANDARD', 'PENDING'),
                                                                                              (2, '456 Elm St, Townsville', '2024-10-24', 'EXPRESS', 'IN_TRANSIT'),
                                                                                              (3, '789 Maple St, Villagetown', '2024-10-25', 'STANDARD', 'DELIVERED');
