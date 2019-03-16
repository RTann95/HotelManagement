CREATE DATABASE IF NOT EXISTS hotelmanagement;

CREATE TABLE IF NOT EXISTS hotelmanagement.reservations (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    room_number INT4 NOT NULL,
    num_nights INT4 NOT NULL
);

CREATE TABLE IF NOT EXISTS hotelmanagement.reservation_guests (
    reservation_id INT REFERENCES hotelmanagement.reservations (id) ON DELETE CASCADE,
    first_name STRING NOT NULL,
    last_name STRING NOT NULL,
    INDEX (reservation_id)
);
