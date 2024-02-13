package com.ReservationArtisanaux.demoReservationArtisanaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Reservation;

@Repository
public interface ReservationRepository  extends  JpaRepository<Reservation, Long>{

}
