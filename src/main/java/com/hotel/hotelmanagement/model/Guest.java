package com.hotel.hotelmanagement.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class Guest {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private Guest() {}

    public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Guest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Guest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
