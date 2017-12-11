package dev.test_jpa.banque.entite;

import javax.persistence.Embeddable;


import dev.test_jpa.utils.ToString;

/**
 *An Address
 * 
 * @author Sandra Le Thiec
 *
 */
@Embeddable
public class Adresse {
	
	/* ATTRIBUTES */
	@ToString(separator = " - Numéro: ")
	private int idAdress;
	
	@ToString(separator = " - Rue: ")
	private int numero;
	
	@ToString(separator = " - Code postal: ")
	private String rue;
	
	@ToString(separator = " - Ville: ")
	private int codePostal;
	
	@ToString(separator = " - Client: ")
	private String ville;


	
	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Adresse() {
	}


	/* GETTERS AND SETTERS */


	/**
	 * @return the id
	 */
	public int getId() {
		return idAdress;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.idAdress = id;
	}


	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}



	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}


	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}


	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}


	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}


	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	
	
	

}
