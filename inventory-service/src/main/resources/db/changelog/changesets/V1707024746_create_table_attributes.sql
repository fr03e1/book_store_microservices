-- liquibase formatted sql

-- changeset a.bocharov:V1707024746_create_table_attributes
CREATE TABLE attributes
(
    id            SERIAL          NOT NULL PRIMARY KEY,
    name          VARCHAR(255)    NOT NULL UNIQUE
);
