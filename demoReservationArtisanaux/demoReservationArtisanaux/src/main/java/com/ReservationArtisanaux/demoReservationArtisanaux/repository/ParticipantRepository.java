package com.ReservationArtisanaux.demoReservationArtisanaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Participant;

@Repository
public interface ParticipantRepository extends  JpaRepository<Participant, Long>{

}
