package dev.test_jpa.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.LoggerFactory;

import dev.test_jpa.banque.entite.Adresse;
import dev.test_jpa.banque.entite.Banque;
import dev.test_jpa.banque.entite.Client;
import dev.test_jpa.banque.entite.Compte;
import dev.test_jpa.banque.entite.Operation;

public class TestBanque {

	public static void main(String[] args) {
		final org.slf4j.Logger LOG = LoggerFactory.getLogger("logger1");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		/* Inserer une banque */
		Banque banque = new Banque();
		banque.setNom("CMB");
		
		/* inserer une adresse */
		Adresse adresse = new Adresse();
		adresse.setNumero(1);
		adresse.setRue("rue des capucines");
		adresse.setCodePostal(44800);
		adresse.setVille("Saint-Herblain");
		
		/* inserer un client */
		Client client = new Client();
		client.setNom("Cesar");
		client.setPrenom("Jules");
		LocalDate dateNaissance = LocalDate.of(1980, 12, 25);
		client.setDateNaissance(dateNaissance);
		client.setAdresse(adresse);
		client.setBanque(banque);
		
		banque.getClients().add(client);
		
		/* inserer un compte */
		Compte compte = new Compte();
		compte.getClients().add(client);
		compte.setNumero(1);
		compte.setSolde(15000.75);
		
		
		client.getComptes().add(compte);
		
		/* inserer une operation */
		Operation operation = new Operation();
		operation.setCompte(compte);
		LocalDateTime dateTime = LocalDateTime.now();
		operation.setDate(dateTime);
		operation.setMontant(100.00);
		operation.setMotif("virement");
		
		compte.getOperations().add(operation);
		
		entityManager.persist(banque);
		entityManager.persist(client);
		entityManager.persist(compte);
		entityManager.persist(operation);
		
		entityTransaction.commit();

	}

}
