package com.mic.luxemain.service;

import com.mic.luxemain.Repository.ReservationRepository;
import com.mic.luxemain.domain.Reservation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository repository;


    public void update(long id , Reservation newRes) throws NotFoundException {

        Optional<Reservation> fetchedRes = repository.findById(id);
        if(!fetchedRes.isPresent()){
            throw new NotFoundException("Sorry");
        }
        fetchedRes.get().setFirstName(newRes.getFirstName());
        fetchedRes.get().setLastName(newRes.getLastName());
        fetchedRes.get().setGuests(newRes.getGuests());
        fetchedRes.get().setReservedDate(newRes.getReservedDate());
        fetchedRes.get().setEmail(newRes.getEmail());




        repository.save(fetchedRes.get());
    }
}
