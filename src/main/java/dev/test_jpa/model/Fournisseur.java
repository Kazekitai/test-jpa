package dev.test_jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dev.test_jpa.utils.StringUtils;
import dev.test_jpa.utils.ToString;

/**
 * POJO Class Fournisseur
 * 
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name="fournisseur")
public class Fournisseur {
	/* ATTRIBUTES */
	@ToString(separator = " - Fournisseur: ")
	@Id
	int id;
	
	@ToString(separator = " - Articles: ")
	@Column(name = "NOM")
	String nom;
	
	@ToString(separator = " - Bons: ")
	@OneToMany(mappedBy="fournisseur")
	Set<Article> articles;
	
	

	@ToString
	@OneToMany(mappedBy="fou")
	Set<BonCommande> commandes;

	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Fournisseur() {
		articles = new HashSet<Article>();

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
	 * @return the articles
	 */
	public Set<Article> getArticles() {
		return articles;
	}

	/**
	 * @param articles the articles to set
	 */
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
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
