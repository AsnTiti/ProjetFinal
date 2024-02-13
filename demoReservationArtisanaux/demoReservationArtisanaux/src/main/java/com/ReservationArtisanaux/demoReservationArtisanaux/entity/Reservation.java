package com.ReservationArtisanaux.demoReservationArtisanaux.entity;

import java.util.Date;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Réservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reservation_ID")
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "Atelier_ID")
    private Atelier atelier;

    @ManyToOne
    @JoinColumn(name = "Participant_ID")
    private Participant participant;

    @Column(name = "Date_Reservation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReservation ;


    @Transient
    private String dateReservationString;
	/**
	 * @return the reservationId
	 */
	public Long getReservationId() {
		return reservationId;
	}

	/**
	 * @param reservationId the reservationId to set
	 */
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * @return the atelier
	 */
	public Atelier getAtelier() {
		return atelier;
	}

	/**
	 * @param atelier the atelier to set
	 */
	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}

	/**
	 * @return the participant
	 */
	public Participant getParticipant() {
		return participant;
	}

	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	

	/**
	 * @return the dateReservationString
	 */
	public String getDateReservationString() {
		return dateReservationString;
	}

	/**
	 * @param dateReservationString the dateReservationString to set
	 */
	public void setDateReservationString(String dateReservationString) {
		this.dateReservationString = dateReservationString;
	}

	/**
	 * @return the dateReservation
	 */
	public Date getDateReservation() {
		return dateReservation;
	}

	/**
	 * @param dateReservation the dateReservation to set
	 */
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	/**
	 * 
	 */
	public Reservation() {
		super();
	}

	/**
	 * @param atelier
	 * @param participant
	 * @param dateReservation
	 */
	public Reservation(Atelier atelier, Participant participant, Date dateReservation) {
		super();
		this.atelier = atelier;
		this.participant = participant;
		this.dateReservation = dateReservation;
	}

    // Constructeurs, getters, setters, etc.
    
}