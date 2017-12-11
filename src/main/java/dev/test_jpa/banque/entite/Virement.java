package dev.test_jpa.banque.entite;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import dev.test_jpa.utils.StringUtils;
import dev.test_jpa.utils.ToString;

/**
 * An Operation : transfer
 * 
 * @author Sandra Le Thiec
 *
 */
@Entity
@DiscriminatorValue("V")
@Table(name = "Virement")
public class Virement extends Operation {

	/* ATTRIBUTES */
	/**
	 * the identification
	 */
	@Transient
	private int idVirement;

	/**
	 * the beneficiary
	 */
	@Column(name = "beneficiaire")
	@ToString(separator = " (Beneficiaire) ")
	private String beneficiaire;

	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Virement() {
	}
	
	/* METHODS */
	/**
	 * Method to return String value of article object
	 */
	public String toString() {
		return StringUtils.getStringValue(this);
	}


	/* GETTERS AND SETTERS */

	/**
	 * @return the idVirement
	 */
	public int getIdVirement() {
		return idVirement;
	}

	/**
	 * @param idVirement
	 *            the idVirement to set
	 */
	public void setIdVirement(int idVirement) {
		this.idVirement = idVirement;
	}

	/**
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * @param beneficiaire
	 *            the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
