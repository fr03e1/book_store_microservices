-- liquibase formatted sql

-- changeset a.bocharov:V1707024883_create_table_attribute_values
CREATE TABLE attribute_values
(
    id                  SERIAL          NOT NULL PRIMARY KEY,
    inventory_item_id   INT             NOT NULL,
    attribute_id        INT             NOT NULL,
    value               TEXT            NOT NULL DEFAULT '',

    CONSTRAINT fk_attribute_values_to_inventory_item FOREIGN KEY (inventory_item_id) REFERENCES inventory_items (id)
        ON DELETE CASCADE,

    CONSTRAINT fk_attribute_values_to_attribute_id FOREIGN KEY (attribute_id) REFERENCES attributes (id)
        ON DELETE CASCADE
);
