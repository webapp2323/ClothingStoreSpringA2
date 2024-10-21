CREATE TYPE sleeve_type AS ENUM ('SHORT', 'LONG', 'SLEEVELESS');

--changeset author:create_table_shirt
CREATE TABLE shirt (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       brand VARCHAR(255) NOT NULL,
                       price DECIMAL NOT NULL,
                       size VARCHAR(50) NOT NULL,
                       material VARCHAR(50) NOT NULL,
                       sleeve_type VARCHAR(50) NOT NULL  -- Столбец для типа рукава
);
