package com.hotel.hotelmanagement.repository;

import com.hotel.hotelmanagement.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {}
