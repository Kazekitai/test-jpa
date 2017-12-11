package dev.test_jpa.banque.entite;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import dev.test_jpa.utils.ToString;

/**
 *A Client
 * 
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "client")
public class Client {
	
	/* ATTRIBUTES */
	@ToString(separator = " - Nom: ")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nom")
	@ToString(separator = " - Prénom: ")
	private String nom;
	
	@Column(name = "prenom")
	@ToString(separator = " - Date de naissance: ")
	private String prenom;
	
	@Column(name = "dateNaissance")
	@ToString(separator = " - Adresse: ")
	private LocalDate dateNaissance;
	
	@ToString(separator = " - Banque: ")
	@Embedded
	@Column(name = "adresse")
	Adresse adresse;
	
	@ToString(separator = " - Comptes: ")
	@ManyToOne
	@JoinColumn(name = "id_banque")
	Banque banque;
		
	@ManyToMany(mappedBy="clients")
	private Set<Compte> comptes;


	
	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Client() {
		comptes = new HashSet<Compte>();
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
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	
	

}
