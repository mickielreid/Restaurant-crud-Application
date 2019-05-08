package com.mic.luxemain.Repository;

import com.mic.luxemain.domain.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation , Long> {

    List<Reservation> findAllByReservedDateIgnoreCase(String reservedDate);
}
