package com.hotel.hotelmanagement.controller;

import com.google.common.collect.ImmutableList;
import com.hotel.hotelmanagement.model.Reservation;
import com.hotel.hotelmanagement.service.HotelManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HotelManagementController {

    @Autowired
    private HotelManagementService hotelManagementService;

    @GetMapping("/")
    public String index() {
        return "Hello, World!\n";
    }

    @PostMapping("/reservations/init")
    public void initializeReservations() {
        hotelManagementService.initializeReservations();
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservations() {
        return ResponseEntity.ok(ImmutableList.copyOf(hotelManagementService.getReservations()));
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
        Reservation reserved = hotelManagementService.createReservation(reservation);
        return ResponseEntity.created(null).body(reserved);
    }
}
