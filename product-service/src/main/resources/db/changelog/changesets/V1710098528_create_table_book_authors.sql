-- liquibase formatted sql

-- changeset a.bocharov:V1710098528_create_table_book_authors
CREATE TABLE book_author (
    book_id          INTEGER,
    author_id        INTEGER,
    PRIMARY KEY (book_id, author_id),

    CONSTRAINT fk_book_authors_to_books FOREIGN KEY (book_id) REFERENCES books (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_book_authors_to_authors FOREIGN KEY (author_id) REFERENCES authors (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
