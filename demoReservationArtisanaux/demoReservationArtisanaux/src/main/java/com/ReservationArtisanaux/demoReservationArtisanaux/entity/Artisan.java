package com.ReservationArtisanaux.demoReservationArtisanaux.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Artisan")
public class Artisan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Artisan_ID")
    private Long artisanId;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Telephone", nullable = false)
    private String telephone;
    
    @OneToMany(mappedBy = "artisan", cascade = CascadeType.ALL)
    private List<Atelier> ateliers;

	/**
	 * @return the artisanId
	 */
	public Long getArtisanId() {
		return artisanId;
	}

	/**
	 * @param artisanId the artisanId to set
	 */
	public void setArtisanId(Long artisanId) {
		this.artisanId = artisanId;
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
	

	/**
	 * 
	 */
	public Artisan() {
		super();
	}

	/**
	 * @param nom
	 * @param email
	 * @param telephone
	 */
	public Artisan(String nom, String email, String telephone) {
		super();
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
	}

    // Constructeurs, getters, setters, etc.
    
}

   


