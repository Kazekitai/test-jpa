package dev.test_jpa.banque.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dev.test_jpa.utils.StringUtils;
import dev.test_jpa.utils.ToString;

/**
 * A bank
 * 
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "banque")
public class Banque {
	
	/* ATTRIBUTES */
	@ToString(separator = " - Nom: ")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom")
	@ToString
	private String nom;

	@OneToMany(mappedBy = "banque")
	private Set<Client> clients;


	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Banque() {
		clients = new HashSet<Client>();
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
	 * @param id
	 *            the id to set
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
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
