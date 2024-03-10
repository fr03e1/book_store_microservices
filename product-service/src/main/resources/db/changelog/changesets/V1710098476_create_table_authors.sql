-- liquibase formatted sql

-- changeset a.bocharov:V1710098476_create_table_authors
CREATE TABLE authors
(
    id       SERIAL       PRIMARY KEY,
    name     VARCHAR(255) NOT NULL
);
