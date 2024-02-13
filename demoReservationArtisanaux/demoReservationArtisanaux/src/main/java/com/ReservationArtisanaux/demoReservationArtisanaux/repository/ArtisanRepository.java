package com.ReservationArtisanaux.demoReservationArtisanaux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Artisan;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long> {

}
