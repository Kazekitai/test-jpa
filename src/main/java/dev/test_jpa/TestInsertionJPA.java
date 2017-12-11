package dev.test_jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.slf4j.LoggerFactory;
import dev.test_jpa.model.Article;
import dev.test_jpa.model.BonCommande;
import dev.test_jpa.model.Fournisseur;

public class TestInsertionJPA {

	public static void main(String[] args) {
		final org.slf4j.Logger LOG = LoggerFactory.getLogger("logger1");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		/* Récupérer un fournisseur */
		Fournisseur fournisseur = null;
		TypedQuery<Fournisseur> queryFou = entityManager.createQuery("select f from Fournisseur f where f.id = :id", Fournisseur.class);
		queryFou.setParameter("id", 3);
		List<Fournisseur> fournisseurs1 = queryFou.getResultList();
		if (!fournisseurs1.isEmpty()) {
			fournisseur = fournisseurs1.get(0);
			LOG.trace("\n id fournisseur : " + fournisseur.getId());
		}
		
		
		/* Insérer un bon de commande avec deux articles */
		Set<BonCommande> commandes = new HashSet<BonCommande>();
		LOG.trace("\n /* Insérer un bon de commande avec deux articles */");
		BonCommande bon = new BonCommande();
		bon.setId(8);
		bon.setNumero(8);
		LocalDate date = LocalDate.of(2017, 12, 11);
		LocalTime time = LocalTime.of(10, 41);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		bon.setDateCmde(dateTime);
		bon.setDelai(5);
		bon.setFou(fournisseur);
		commandes.add(bon);
			
		/* Insérer deux articles article */
		LOG.trace(" \n /* Insérer un premier article */");
		Article art1 = new Article();
		art1.setId(14);
		art1.setRef("B04");
		art1.setDesignation("Peinture jaune");
		art1.setPrix(5.90);
		art1.setFournisseur(fournisseur);
		art1.setCommandes(commandes);
		
		LOG.trace(" \n /* Insérer un deuxième article */");
		Article art2 = new Article();
		art2.setId(15);
		art2.setRef("B05");
		art2.setDesignation("Peinture rouge");
		art2.setPrix(5.90);
		art2.setFournisseur(fournisseur);
		art2.setCommandes(commandes);
		
		entityManager.persist(art1);
		entityManager.persist(art2);
		bon.getArticles().add(art1);
		bon.getArticles().add(art2);
		entityManager.persist(bon);
		
		entityTransaction.commit();
		
		
		
		
		
		
		
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
