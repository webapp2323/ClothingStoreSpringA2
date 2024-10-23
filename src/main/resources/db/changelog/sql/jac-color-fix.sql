--liquibase formatted sql

--changeset Owl:jac_color_fix

ALTER TABLE jac
    RENAME COLUMN color123 TO color;