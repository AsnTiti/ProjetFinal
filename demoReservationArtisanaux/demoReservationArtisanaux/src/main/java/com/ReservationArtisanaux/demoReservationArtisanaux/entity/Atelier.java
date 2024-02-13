package com.ReservationArtisanaux.demoReservationArtisanaux.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Atelier")
public class Atelier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Atelier_ID")
    private Long atelierId;

    @ManyToOne
    @JoinColumn(name = "Artisan_ID")
    private Artisan artisan;

    @Column(name = "Nom", nullable = false, length = 255)
    private String nom;

    @Column(name = "date_Atelier")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAtelier;

    @Transient
    private String dateAtelierString;

    /**
	 * @return the dateAtelierString
	 */
	public String getDateAtelierString() {
		return dateAtelierString;
	}

	/**
	 * @param dateAtelierString the dateAtelierString to set
	 */
	public void setDateAtelierString(String dateAtelierString) {
		this.dateAtelierString = dateAtelierString;
	}

	@Column(name = "Lieu", length = 255)
    private String lieu;

	/**
	 * @return the atelierId
	 */
    
	public Long getAtelierId() {
		return atelierId;
	}

	/**
	 * 
	 */
	public Atelier() {
		super();
	}

	/**
	 * @param artisan
	 * @param nom
	 * @param dateAtelier
	 * @param lieu
	 */
	public Atelier(Artisan artisan, String nom, Date dateAtelier, String lieu) {
		super();
		this.artisan = artisan;
		this.nom = nom;
		this.dateAtelier = dateAtelier;
		this.lieu = lieu;
	}

	/**
	 * @param atelierId the atelierId to set
	 */
	public void setAtelierId(Long atelierId) {
		this.atelierId = atelierId;
	}

	/**
	 * @return the artisan
	 */
	public Artisan getArtisan() {
		return artisan;
	}

	/**
	 * @param artisan the artisan to set
	 */
	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
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
	 * @return the dateAtelier
	 */
	public Date getDateAtelier() {
		return dateAtelier;
	}

	/**
	 * @param dateAtelier the dateAtelier to set
	 */
	public void setDateAtelier(Date dateAtelier) {
		this.dateAtelier = dateAtelier;
	}

	/**
	 * @return the lieu
	 */
	public String getLieu() {
		return lieu;
	}

	/**
	 * @param lieu the lieu to set
	 */
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
    

    // Constructeurs, getters, setters, etc.
    
}