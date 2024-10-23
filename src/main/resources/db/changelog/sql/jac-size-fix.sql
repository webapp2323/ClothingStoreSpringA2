--liquibase formatted sql

--changeset Owl:jac_size_fix

ALTER TABLE jac ALTER COLUMN size SET NOT NULL;




