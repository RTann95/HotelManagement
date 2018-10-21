package com.hotel.hotelmanagement.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "hotelmanagement", name = "reservations")
public class Reservation {

    private static final String ID = "id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String NUM_NIGHTS = "num_nights";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @PositiveOrZero
    @Column(name = ROOM_NUMBER)
    private Integer roomNumber;

    // TODO: Validate the elements as well via a custom validator.
    @NotEmpty
    @ElementCollection(targetClass = Guest.class)
    @CollectionTable(schema = "hotelmanagement", name = "reservation_guests", joinColumns = @JoinColumn(name = "reservation_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
    })
    private List<Guest> guests;

    @Positive
    @Column(name = NUM_NIGHTS)
    private Integer numNights;

    private Reservation() {}

    public Reservation(Integer roomNumber, List<Guest> guests, Integer numNights) {
        this.roomNumber = roomNumber;
        this.guests = guests;
        this.numNights = numNights;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Reservation setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public Reservation setGuests(List<Guest> guests) {
        this.guests = guests;
        return this;
    }

    public Integer getNumNights() {
        return numNights;
    }

    public Reservation setNumNights(Integer numNights) {
        this.numNights = numNights;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Reservation)) {
            return false;
        } else {
            Reservation that = (Reservation) other;
            return Objects.equals(id, that.id);
        }
    }

    public String toString() {
        return String.format("Room: %d Guests: %s Number of nights: %d", roomNumber, guests, numNights);
    }
}
