package com.ReservationArtisanaux.demoReservationArtisanaux.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Artisan;
@Service
public interface ArtisanService {
	void deleteArtisan(Long id);
	Artisan updateArtisan(Long id, Artisan updatedArtisan);
	 Artisan createArtisan(Artisan artisan);
	 Artisan getArtisanById(Long id) ;
	 List<Artisan> getAllArtisans();}
