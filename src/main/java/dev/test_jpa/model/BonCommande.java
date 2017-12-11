package dev.test_jpa.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import dev.test_jpa.utils.StringUtils;
import dev.test_jpa.utils.ToString;

/**
 * POJO Class BonCommande
 * 
 * @author Sandra Le Thiec
 *
 */
@Entity
@Table(name = "bon")
public class BonCommande {

	/* ATTRIBUTES */
	@ToString(separator = " - Numéro: ")
	@Id
	private int id;

	@ToString(separator = " - Date de commande: ")
	@Column(name = "NUMERO")
	private int numero;

	@ToString(separator = " - Délai: ")
	@Column(name = "DATE_CMDE")
	private LocalDateTime dateCmde;

	@ToString(separator = " jours - Articles: ")
	@Column(name = "DELAI")
	private int delai;

//	 @ToString
//	 @Column(name = "ID_FOU - Articles: ")
//	 private int idFou;

	
	@ManyToOne
	@JoinColumn(name = "ID_FOU")
	private Fournisseur fou;

	@ToString
	@ManyToMany
	@JoinTable(name="compo",
			joinColumns=@JoinColumn(name="ID_BON",referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_ART",referencedColumnName="ID")
	)
	private Set<Article> articles;

	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public BonCommande() {
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
	 * @param id
	 *            the id to set
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
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the dateCmde
	 */
	public LocalDateTime getDateCmde() {
		return (LocalDateTime) dateCmde;
	}

	/**
	 * @param dateCmde
	 *            the dateCmde to set
	 */
	public void setDateCmde(LocalDateTime dateCmde) {
		this.dateCmde = dateCmde;
	}

	/**
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}

	/**
	 * @param delai
	 *            the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}
	
	/**
	 * @return the fou
	 */
	public Fournisseur getFou() {
		return fou;
	}

	/**
	 * @param fou the fou to set
	 */
	public void setFou(Fournisseur fou) {
		this.fou = fou;
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

	// /**
	// * @return the idFou
	// */
	// public int getIdFou() {
	// return idFou;
	// }
	//
	// /**
	// * @param idFou the idFou to set
	// */
	// public void setIdFou(int idFou) {
	// this.idFou = idFou;
	// }

}
