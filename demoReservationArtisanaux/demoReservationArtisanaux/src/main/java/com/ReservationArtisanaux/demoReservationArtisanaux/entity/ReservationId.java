package com.ReservationArtisanaux.demoReservationArtisanaux.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ReservationId {
	
	@Column(name = "Atelier_ID")
    private int Atelier_ID;

    @Column(name = "Participant_ID")
    private int Participant_ID;


}
