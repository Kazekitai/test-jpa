package dev.test_jpa.banque.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import dev.test_jpa.utils.StringUtils;
import dev.test_jpa.utils.ToString;

/**
 * An Account : Livret A
 * 
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "livretA")
public class LivretA extends Compte {

	/* ATTRIBUTES */
	/**
	 * the identification
	 */
	@ToString
	@Transient
	private int idLivretA;

	/**
	 * the rate
	 */
	@Column(name = "taux")
	@ToString(separator = " (Taux) ")
	private double taux;

	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public LivretA() {
	}
	
	/* METHODS */
	/**
	 * Method to return String value of article object
	 */
	public String toString() {
		return " Livret A : ["  + "Numéro: " + super.getNumero() + " - Solde: " + super.getSolde() + " - " +  StringUtils.getStringValue(this) + "]";
	}


	/* GETTERS AND SETTERS */

	/**
	 * @return the idLivretA
	 */
	public int getIdLivretA() {
		return idLivretA;
	}

	/**
	 * @param idLivretA
	 *            the idLivretA to set
	 */
	public void setIdLivretA(int idLivretA) {
		this.idLivretA = idLivretA;
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
