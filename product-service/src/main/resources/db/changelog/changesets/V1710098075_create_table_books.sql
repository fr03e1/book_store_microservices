-- liquibase formatted sql

-- changeset a.bocharov:V1710098075_create_table_books
CREATE TABLE books
(
    id                  SERIAL          NOT NULL PRIMARY KEY,
    title               VARCHAR(255)    NOT NULL,
    isbn                VARCHAR(20)     NOT NULL,
    publication_year    INTEGER         NOT NULL,
    price               DECIMAL(10, 2)  NOT NULL,

    created_at          TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at          TIMESTAMP          DEFAULT NULL
);
