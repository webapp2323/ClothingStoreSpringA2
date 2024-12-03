--liquibase formatted sql

--changeset zhenya:delete-odd

DROP TABLE IF EXISTS "shirt";
DROP TABLE IF EXISTS "pants"