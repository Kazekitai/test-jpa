package dev.test_jpa.banque.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import dev.test_jpa.utils.StringUtils;
import dev.test_jpa.utils.ToString;

/**
 * An Account : life insurance
 * 
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "AssuranceVie")
public class AssuranceVie extends Compte {

	/* ATTRIBUTES */
	/**
	 * the identification
	 */
	@ToString
	@Transient
	private int idAssVie;

	/**
	 * the end date
	 */
	@Column(name = "dateFin")
	@ToString(separator = " (Date de fin) - Taux: ")
	private LocalDate dateFin;

	/**
	 * the rate
	 */
	@Column(name = "taux")
	@ToString
	private double taux;

	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public AssuranceVie() {
	}
	
	/* METHODS */
	/**
	 * Method to return String value of article object
	 */
	public String toString() {
		return " Assurance vie: [" + "Numéro: " + super.getNumero() + " - Solde: " + super.getSolde() + " - " + StringUtils.getStringValue(this) + "]";
	}


	/* GETTERS AND SETTERS */
	/**
	 * @return the idAssVie
	 */
	public int getIdAssVie() {
		return idAssVie;
	}

	/**
	 * @param idAssVie
	 *            the idAssVie to set
	 */
	public void setIdAssVie(int idAssVie) {
		this.idAssVie = idAssVie;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin
	 *            the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux
	 *            the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

}
