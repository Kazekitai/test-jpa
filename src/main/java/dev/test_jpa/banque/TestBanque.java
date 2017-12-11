package dev.test_jpa.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.LoggerFactory;

import dev.test_jpa.banque.entite.Adresse;
import dev.test_jpa.banque.entite.AssuranceVie;
import dev.test_jpa.banque.entite.Banque;
import dev.test_jpa.banque.entite.Client;
import dev.test_jpa.banque.entite.Compte;
import dev.test_jpa.banque.entite.LivretA;
import dev.test_jpa.banque.entite.Operation;
import dev.test_jpa.banque.entite.Virement;
import dev.test_jpa.model.BonCommande;

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
		
		Banque banquePost = new Banque();
		banquePost.setNom("La banque postale");
		
		/* inserer une adresse */
		Adresse adresse = new Adresse();
		adresse.setNumero(1);
		adresse.setRue("rue des capucines");
		adresse.setCodePostal(44800);
		adresse.setVille("Saint-Herblain");
		
		Adresse adresseclient1 = new Adresse();
		adresseclient1.setNumero(7);
		adresseclient1.setRue("rue de la liberté");
		adresseclient1.setCodePostal(00000);
		adresseclient1.setVille("Le Paradis");
		
		/* inserer un client */
		Client client = new Client();
		client.setNom("Cesar");
		client.setPrenom("Jules");
		LocalDate dateNaissance = LocalDate.of(1980, 12, 25);
		client.setDateNaissance(dateNaissance);
		client.setAdresse(adresse);
		client.setBanque(banque);
		
		Client client1 = new Client();
		client1.setNom("Bono");
		client1.setPrenom("Jean");
		LocalDate dateNaissanceclient1 = LocalDate.of(1985, 05, 25);
		client1.setDateNaissance(dateNaissanceclient1);
		client1.setAdresse(adresseclient1);
		client1.setBanque(banque);
		
		banque.getClients().add(client);
		banque.getClients().add(client1);
		
		/* inserer un livret A */
		LivretA livretA = new LivretA();
		livretA.getClients().add(client);
		livretA.setNumero(1);
		livretA.setSolde(15000.75);
		livretA.setTaux(2.5);
		
		LivretA livretAclient1 = new LivretA();
		livretAclient1.getClients().add(client1);
		livretAclient1.setNumero(1012547);
		livretAclient1.setSolde(105000.75);
		livretAclient1.setTaux(0.5);
		
		/* inserer une assurance vie */
		AssuranceVie assVie = new AssuranceVie();
		assVie.getClients().add(client);
		assVie.setNumero(1);
		assVie.setSolde(2000);
		LocalDate dateFin = LocalDate.of(2080, 12, 31);
		assVie.setDateFin(dateFin);
		assVie.setTaux(0.5);
		
		
		client.getComptes().add(livretA);
		client.getComptes().add(assVie);
		client1.getComptes().add(livretAclient1);
		
		/* inserer un virement */
		Virement virement = new Virement();
		virement.setCompte(assVie);
		LocalDateTime dateTime = LocalDateTime.now();
		virement.setDate(dateTime);
		virement.setMontant(100.00);
		virement.setMotif("virement du livret A sur l'assurance vie ");
		virement.setBeneficiaire("Jules Cesar");
		
		Virement virementclient1 = new Virement();
		virementclient1.setCompte(livretAclient1);
		LocalDateTime dateTime1 = LocalDateTime.now();
		virementclient1.setDate(dateTime1);
		virementclient1.setMontant(1000.00);
		virementclient1.setMotif("virement du livret A  de Jean Bono sur celui de Jules Cesar");
		virementclient1.setBeneficiaire("Jules Cesar");
		
		
		assVie.getOperations().add(virement);
		livretAclient1.getOperations().add(virement);
		
		entityManager.persist(banque);
		entityManager.persist(banquePost);
		entityManager.persist(client);
		entityManager.persist(client1);
		entityManager.persist(assVie);
		entityManager.persist(livretA);
		entityManager.persist(livretAclient1);
		entityManager.persist(virement);
		entityManager.persist(virementclient1);
		
		entityTransaction.commit();
		
		/* Extraction d'un client ses comptes */
		LOG.trace(" \n /* Extraction d'un client */");
		TypedQuery<Client> querySelectClient = entityManager.createQuery("select c from Client c where c.id=:id", Client.class);
		querySelectClient.setParameter("id", 1);
		List<Client> clients = querySelectClient.getResultList();
		if (!clients.isEmpty()) {
			Client selectedClient = clients.get(0);
			 LOG.trace(selectedClient.toString());
		}
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
