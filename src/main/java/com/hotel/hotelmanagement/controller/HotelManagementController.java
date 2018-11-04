package com.hotel.hotelmanagement.controller;

import com.google.common.collect.ImmutableList;
import com.hotel.hotelmanagement.model.Reservation;
import com.hotel.hotelmanagement.service.HotelManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class HotelManagementController {

    @Autowired
    private HotelManagementService hotelManagementService;

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello, World!");
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservations() {
        return ResponseEntity.ok(ImmutableList.copyOf(hotelManagementService.getReservations()));
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
        Reservation reserved = hotelManagementService.createReservation(reservation);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reserved.getId())
                .toUri();
        return ResponseEntity.created(location).body(reserved);
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> getReserationById(@PathVariable Long id) {
        return hotelManagementService.getReservationById(id)
                .map(ResponseEntity::ok)
                // TODO: Custom error responses.
                .orElse(ResponseEntity.notFound().build());
    }
}
