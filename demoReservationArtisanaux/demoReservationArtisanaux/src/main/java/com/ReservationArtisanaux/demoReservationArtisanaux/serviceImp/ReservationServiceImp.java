package com.ReservationArtisanaux.demoReservationArtisanaux.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Reservation;
import com.ReservationArtisanaux.demoReservationArtisanaux.repository.ReservationRepository;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.ReservationService;

@Service
public class ReservationServiceImp implements ReservationService{
	@Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation != null) {
            // Mettez à jour les propriétés nécessaires
            existingReservation.setAtelier(updatedReservation.getAtelier());
            existingReservation.setParticipant(updatedReservation.getParticipant());
            existingReservation.setDateReservation(updatedReservation.getDateReservation());

            return reservationRepository.save(existingReservation);
        }
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

}
