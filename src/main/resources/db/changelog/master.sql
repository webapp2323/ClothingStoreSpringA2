--liquibase formatted sql


--changeset Owl:create_enum_types
CREATE TYPE sleeve_type_enum AS ENUM ('SHORT', 'LONG', 'SLEEVELESS');

CREATE TYPE size_enum AS ENUM ('S', 'M', 'L', 'XL');

CREATE TYPE material_enum AS ENUM ('COTTON', 'LEATHER', 'POLYESTER', 'NYLON', 'DENIM', 'WOOL', 'FLEECE', 'SUEDE', 'LINEN', 'VINYL');


--changeset Owl:create_table_shirt
--include file="db/changelog/sql/20241009_create_table_shirt.sql"

--changeset Owl:create_table_pants
--include file="db/changelog/sql/20241009_create_table_pants.sql"

--changeset Owl:create_table_jacket
--include file="db/changelog/sql/20241009_create_table_jacket.sql"