package com.ReservationArtisanaux.demoReservationArtisanaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Atelier;

@Repository
public interface AtelierRepository extends JpaRepository<Atelier, Long>{

}
