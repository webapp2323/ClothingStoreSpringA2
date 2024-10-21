--liquibase formatted sql

--changeset author:create_jacket_table
CREATE TABLE IF NOT EXISTS Jacket (
                                      id SERIAL PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
    size VARCHAR(50) NOT NULL,
    color VARCHAR(50),
    price NUMERIC(10, 2) NOT NULL,
    material VARCHAR(50) NOT NULL,
    hasHood BOOLEAN NOT NULL
    );