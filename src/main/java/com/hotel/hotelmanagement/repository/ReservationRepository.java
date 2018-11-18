package com.hotel.hotelmanagement.repository;

import com.hotel.hotelmanagement.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Do not need all the offerings of JpaRepository, so extending CrudRepository instead.
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {}
