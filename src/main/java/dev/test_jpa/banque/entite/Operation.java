package dev.test_jpa.banque.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.test_jpa.utils.ToString;

/**
 *An Operation
 * 
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "operation")
public class Operation {
	
	/* ATTRIBUTES */
	@ToString(separator = " - Date: ")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date")
	@ToString(separator = " - Montant: ")
	private LocalDateTime date;
	
	@Column(name = "montant")
	@ToString(separator = " - Motif: ")
	private double montant;
	
	@Column(name = "motif")
	@ToString(separator = " - Compte: ")
	private String motif;
	
	@ToString
	@ManyToOne
	@JoinColumn(name = "id_compte")
	Compte compte;
	
	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Operation() {
	}

	/* GETTERS AND SETTERS */
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
