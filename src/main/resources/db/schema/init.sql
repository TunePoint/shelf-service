CREATE SCHEMA if NOT EXISTS shelf;

-- DOMAIN OBJECTS
CREATE TABLE shelf.audios
(
    id           BIGINT PRIMARY KEY,
    is_private   BOOLEAN DEFAULT FALSE,
    interactions BIGINT  DEFAULT 0
);

CREATE TABLE shelf.playlists
(
    id           BIGINT PRIMARY KEY,
    is_private   BOOLEAN DEFAULT FALSE,
    interactions BIGINT  DEFAULT 0
);

CREATE TABLE shelf.users
(
    id           BIGINT PRIMARY KEY,
    interactions BIGINT DEFAULT 0
);

--- SHELVES
CREATE TABLE shelf.audio_shelf
(
    id SERIAL PRIMARY KEY,

    CONSTRAINT audio_shelf_fk FOREIGN KEY (id) REFERENCES shelf.audios (id) ON DELETE CASCADE
);

CREATE TABLE shelf.audio_shelf_element
(
    shelf_id BIGINT REFERENCES shelf.audio_shelf (id),
    audio_id BIGINT REFERENCES shelf.audios (id),

    CONSTRAINT audio_shelf_element_pk PRIMARY KEY (shelf_id, audio_id)
);

CREATE TABLE shelf.playlist_shelf
(
    id SERIAL PRIMARY KEY,

    CONSTRAINT playlist_shelf_fk FOREIGN KEY (id) REFERENCES shelf.playlists (id) ON DELETE CASCADE
);

CREATE TABLE shelf.playlist_shelf_element
(
    shelf_id    BIGINT REFERENCES shelf.playlist_shelf (id),
    playlist_id BIGINT REFERENCES shelf.playlists (id),

    CONSTRAINT playlist_shelf_element_pk PRIMARY KEY (shelf_id, playlist_id)
);

CREATE TABLE shelf.author_shelf
(
    id SERIAL PRIMARY KEY,

    CONSTRAINT author_shelf_fk FOREIGN KEY (id) REFERENCES shelf.users (id) ON DELETE CASCADE
);

CREATE TABLE shelf.author_shelf_element
(
    shelf_id  BIGINT REFERENCES shelf.author_shelf (id),
    author_id BIGINT REFERENCES shelf.users (id),

    CONSTRAINT author_shelf_element_pk PRIMARY KEY (shelf_id, author_id)
);

CREATE FUNCTION create_shelves() RETURNS trigger AS $$
BEGIN
INSERT INTO shelf.author_shelf(id)
VALUES (new.id);
INSERT INTO shelf.playlist_shelf(id)
VALUES (new.id);
INSERT INTO shelf.audio_shelf(id)
VALUES (new.id);
RETURN new;
END $$
LANGUAGE plpgsql;

CREATE TRIGGER user_created
    AFTER INSERT
    ON shelf.users
    FOR EACH ROW EXECUTE procedure create_shelves();