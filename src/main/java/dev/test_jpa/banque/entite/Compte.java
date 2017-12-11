package dev.test_jpa.banque.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import dev.test_jpa.utils.ToString;

/**
 *An Account
 * 
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "compte")
public class Compte {
	
	/* ATTRIBUTES */
	@ToString(separator = " - Numéro: ")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "numero")
	@ToString(separator = " - Solde: ")
	private int numero;
	
	@Column(name = "solde")
	@ToString
	private double solde;
	
	@ToString
	@ManyToMany
	@JoinTable(name="compo",
			joinColumns=@JoinColumn(name="id_compte",referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="id_client",referencedColumnName="ID")
	)
	private Set<Client> clients;
	
	@ToString
	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;
	
	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Compte() {
		clients = new HashSet<Client>();
		operations = new HashSet<Operation>();
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
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
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

	/**
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	
	
	
	
	

}
