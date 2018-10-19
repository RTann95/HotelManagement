package com.hotel.hotelmanagement.service;

import com.google.common.collect.ImmutableList;
import com.hotel.hotelmanagement.model.Guest;
import com.hotel.hotelmanagement.model.Reservation;
import com.hotel.hotelmanagement.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class HotelManagementService {

    private static Logger LOG = Logger.getLogger(HotelManagementService.class.getName());

    @Autowired
    private ReservationRepository reservationRepository;

    public void initializeReservations() {
        Reservation reservation = new Reservation(100, ImmutableList.of(new Guest("Ross", "Tannenbaum")), 2);
        LOG.info(String.format("Adding initial reservation to DB: %s", reservation));
        reservationRepository.save(reservation);
    }

    public Iterable<Reservation> getReservations() {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        LOG.info(String.format("Reservations: %s", reservations));
        return reservations;
    }

    public Reservation createReservation(Reservation reservation) {
        LOG.info(String.format("Adding reservation: %s", reservation));
        return reservationRepository.save(reservation);
    }
}
