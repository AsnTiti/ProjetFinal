package com.ReservationArtisanaux.demoReservationArtisanaux.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Participant_ID")
    private Long participantId;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Telephone", nullable = false)
    private String telephone;

	/**
	 * 
	 */
	public Participant() {
		super();
	}

	/**
	 * @param nom
	 * @param email
	 * @param telephone
	 */
	public Participant(String nom, String email, String telephone) {
		super();
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
	}

	/**
	 * @return the participantId
	 */
	public Long getParticipantId() {
		return participantId;
	}

	/**
	 * @param participantId the participantId to set
	 */
	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

    // Constructeurs, getters, setters, etc.
    
}