package com.hotel.hotelmanagement.service;

import com.hotel.hotelmanagement.model.Reservation;
import com.hotel.hotelmanagement.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class HotelManagementService {

    private static Logger LOG = Logger.getLogger(HotelManagementService.class.getName());

    @Autowired
    private ReservationRepository reservationRepository;

    public Iterable<Reservation> getReservations() {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        LOG.info(String.format("Reservations: %s", reservations));
        return reservations;
    }

    public Reservation createReservation(Reservation reservation) {
        LOG.info(String.format("Adding reservation: %s", reservation));
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }
}
