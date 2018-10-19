-- TODO: The sequence is only needed for CockroachDB versions < 2.1.x
CREATE SEQUENCE reservations_id_seq;

CREATE TABLE IF NOT EXISTS reservations (
    --id SERIAL PRIMARY KEY,
    id INT PRIMARY KEY DEFAULT nextval('reservations_id_seq'),
    room_number INT4 NOT NULL,
    num_nights INT4 NOT NULL
);

CREATE TABLE IF NOT EXISTS reservation_guests (
    reservation_id INT REFERENCES reservations (id) ON DELETE CASCADE,
    first_name STRING NOT NULL,
    last_name STRING NOT NULL,
    INDEX (reservation_id)
);