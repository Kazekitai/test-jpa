package dev.test_jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.test_jpa.utils.ToString;
import dev.test_jpa.utils.StringUtils;;

@Entity
@Table(name="article")
public class Article {
	
	/* ATTRIBUTES */
	@ToString(separator = " - ")
	@Id
	int id;
	@ToString(separator = " - ")
	@Column(name="REF")
	String ref;
	@ToString(separator = " - ")
	@Column(name="DESIGNATION")
	String designation;
	@ToString(separator = " € - ")
	@Column(name="PRIX")
	double prix;
	@ToString
	@Column(name="ID_FOU")
	int id_fou;
	
	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Article(){
		
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
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}
	/**
	 * @param ref the ref to set
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
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
	/**
	 * @return the id_fou
	 */
	public int getId_fou() {
		return id_fou;
	}
	/**
	 * @param id_fou the id_fou to set
	 */
	public void setId_fou(int id_fou) {
		this.id_fou = id_fou;
	}

}
