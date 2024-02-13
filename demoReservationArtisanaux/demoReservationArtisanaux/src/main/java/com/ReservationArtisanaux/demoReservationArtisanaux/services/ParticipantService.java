package com.ReservationArtisanaux.demoReservationArtisanaux.services;

import java.util.List;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Artisan;
import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Participant;

public interface ParticipantService  {
	void deleteParticipant(Long id);
	Participant updateParticipant(Long id, Participant updatedParticipant);
	Participant createParticipant(Participant participant);
	Participant getParticipantById(Long id);
	List<Participant> getAllParticipants();
	
}
