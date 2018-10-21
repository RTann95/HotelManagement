CREATE DATABASE IF NOT EXISTS hotelmanagement;

-- TODO: This is only needed for Cockroach < 2.1.x
CREATE SEQUENCE IF NOT EXISTS hotelmanagement.reservations_id_seq;

CREATE TABLE IF NOT EXISTS hotelmanagement.reservations (
    --id SERIAL PRIMARY KEY,
    id INT PRIMARY KEY DEFAULT nextval('hotelmanagement.reservations_id_seq'),
    room_number INT4 NOT NULL,
    num_nights INT4 NOT NULL
);

CREATE TABLE IF NOT EXISTS hotelmanagement.reservation_guests (
    reservation_id INT REFERENCES hotelmanagement.reservations (id) ON DELETE CASCADE,
    first_name STRING NOT NULL,
    last_name STRING NOT NULL,
    INDEX (reservation_id)
);
