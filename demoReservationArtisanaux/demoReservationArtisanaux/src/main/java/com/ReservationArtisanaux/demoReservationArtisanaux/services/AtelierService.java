package com.ReservationArtisanaux.demoReservationArtisanaux.services;

import java.util.List;
import java.util.Optional;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Atelier;

public interface AtelierService {
	List<Atelier> getAllAteliers();
	Atelier getAtelierById(Long id);
	Atelier createAtelier(Atelier atelier);
	Atelier updateAtelier(Long id, Atelier updatedAtelier);
	 void deleteAtelier(Long id);

}
