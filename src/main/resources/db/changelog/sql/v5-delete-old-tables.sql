--liquibase formatted sql

--changeset owl:v5-delete-tables
DROP TABLE IF EXISTS "shirt";
DROP TABLE IF EXISTS "pants";
DROP TABLE IF EXISTS "jacket";