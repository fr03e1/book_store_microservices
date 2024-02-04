-- liquibase formatted sql

-- changeset a.bocharov:V1707024283_create_table_inventory_items
CREATE TABLE inventory_items
(
    id                  SERIAL          NOT NULL PRIMARY KEY,
    product_id          VARCHAR(255)    NOT NULL UNIQUE,
    product_name        VARCHAR(255)    NOT NULL,
    category            VARCHAR(50)     NOT NULL,
    available_quantity  INT             NOT NULL  DEFAULT  1,
    total_quantity      INT             NOT NULL  DEFAULT 1,
    reserved_quantity   INT             NOT NULL  DEFAULT 0,
    price               DECIMAL(10, 2)  NOT NULL,

    created_at          TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at          TIMESTAMP          DEFAULT NULL
);
