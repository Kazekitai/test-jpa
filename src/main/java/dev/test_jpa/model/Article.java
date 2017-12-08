package dev.test_jpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO Class Article
 * 
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "article")
public class Article {

	/* ATTRIBUTES */
	@Id
	int id;

	@Column(name = "REF")
	String ref;

	@Column(name = "DESIGNATION")
	String designation;

	@Column(name = "PRIX")
	double prix;


	@ManyToOne
	@JoinColumn(name = "ID_FOU")
	Fournisseur fournisseur;
	
	@ManyToMany(mappedBy="articles")
	private Set<BonCommande> commandes;
	

	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Article() {

	}

	/* METHODS */
	/**
	 * Method to return String value of article object
	 */
	public String toString() {
		return id + " - Référence: " + ref + " - Désignation:  " + designation +  "- Prix: " + prix + " € - Fournisseur: " + fournisseur.getNom();
	}

	/* GETTERS AND SETTERS */

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * @param ref
	 *            the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the fournisseur
	 */
	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	/**
	 * @param fournisseur
	 *            the fournisseur to set
	 */
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	/**
	 * @return the commandes
	 */
	public Set<BonCommande> getCommandes() {
		return commandes;
	}

	/**
	 * @param commandes the commandes to set
	 */
	public void setCommandes(Set<BonCommande> commandes) {
		this.commandes = commandes;
	}
}
