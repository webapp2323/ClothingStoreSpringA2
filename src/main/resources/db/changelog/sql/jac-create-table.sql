--liquibase formatted sql

--changeset Owl:jac_create_table
--preconditions onFail:MARK_RAN
--precondition-sql-check expectedResult:0 SELECT count(*) FROM information_schema.tables WHERE table_name = 'jac';

CREATE TABLE IF NOT EXISTS jac (
 id SERIAL PRIMARY KEY,
 name VARCHAR(255) NOT NULL,
    size VARCHAR(100) NOT NULL,
    color123 VARCHAR(50),
    price NUMERIC(10, 2) NOT NULL,
    material VARCHAR(50) NOT NULL,
    hasHood BOOLEAN NOT NULL
    );



INSERT INTO jac (name, size, color123, price, material, hasHood) VALUES
                                                                     ('Hooded Jacket', 'M', 'Red', 79.99, 'Polyester', TRUE),
                                                                     ('Denim Jacket', 'L', 'Blue', 89.99, 'Denim', FALSE),
                                                                     ('Leather Jacket', 'S', 'Black', 129.99, 'Leather', TRUE),
                                                                     ('Windbreaker', 'XL', 'Green', 49.99, 'Nylon', FALSE);