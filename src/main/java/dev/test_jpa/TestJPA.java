package dev.test_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.slf4j.LoggerFactory;

import dev.test_jpa.model.Article;
import dev.test_jpa.model.BonCommande;
import dev.test_jpa.model.Fournisseur;

/**
 * TestJPA standalone application
 *
 */
public class TestJPA {
	public static void main(String[] args) {
		final org.slf4j.Logger LOG = LoggerFactory.getLogger("logger1");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		/* Récupération de tous les articles */
		LOG.trace(" \n /* Récupération de tous les articles */");
		TypedQuery<Article> query1 = entityManager.createQuery("select a from Article a", Article.class);
		List<Article> articles = query1.getResultList();
		if (!articles.isEmpty()) {
			articles.stream().forEach(a ->  LOG.trace(a.toString()));
		}
		/* Récupération d'un article par son id */
		LOG.trace("\n /* Récupération d'un article par son id */");
		TypedQuery<Article> query2 = entityManager.createQuery("select a from Article a where a.id=:id", Article.class);	
		query2.setParameter("id", 3);
		List<Article> articles1 = query2.getResultList();
		if (!articles1.isEmpty()) {
			Article art = articles1.get(0);
			LOG.trace(art.toString());
		}
		
		/* Récupération d'un article par sa référence */
		LOG.trace("\n /* Récupération d'un article par sa référence */");
		TypedQuery<Article> query3 = entityManager.createQuery("select a from Article a where a.ref=:ref", Article.class);	
		query3.setParameter("ref", "D04");
		List<Article> articles2 = query3.getResultList();
		if (!articles2.isEmpty()) {
			Article art = articles2.get(0);
			LOG.trace(art.toString());
		}
		
		/* Récupération de tous les fournisseurs */
		LOG.trace(" \n /* Récupération de tous les fournisseurs */");
		TypedQuery<Fournisseur> query4 = entityManager.createQuery("select f from Fournisseur f", Fournisseur.class);
		List<Fournisseur> fournisseurs = query4.getResultList();
		if (!fournisseurs.isEmpty()) {
			fournisseurs.stream().forEach(f ->  LOG.trace(f.toString()));
		}
		
		/* Récupération de tous les bons */
		LOG.trace(" \n /* Récupération de tous les bons de commandes */");
		TypedQuery<BonCommande> query5 = entityManager.createQuery("select b from BonCommande b", BonCommande.class);
		List<BonCommande> bons = query5.getResultList();
		if (!bons.isEmpty()) {
			bons.stream().forEach(b ->  LOG.trace(b.toString()));
		}
		
		/* Extraction d'un bon de commande et tous ses articles associés */
		LOG.trace(" \n /* Extraction d'un bon de commande et tous ses articles associés */");
		TypedQuery<BonCommande> query6 = entityManager.createQuery("select b from BonCommande b where b.id=:id", BonCommande.class);
		query6.setParameter("id", 2);
		List<BonCommande> commandes = query6.getResultList();
		if (!commandes.isEmpty()) {
			BonCommande bon = commandes.get(0);
			 LOG.trace(bon.toString());
		}
		
		/* Extraction d'un fournisseur et tous ses articles */
		LOG.trace(" \n /* Extraction d'un fournisseur et tous ses articles et commandes associés */");
		TypedQuery<Fournisseur> query7 = entityManager.createQuery("select f from Fournisseur f where f.nom like :name", Fournisseur.class);
		query7.setParameter("name", "%Française%");
		List<Fournisseur> fournisseurs1 = query7.getResultList();
		if (!fournisseurs1.isEmpty()) {
			Fournisseur fournisseur = fournisseurs1.get(0);
			LOG.trace("Fournisseur: " + fournisseur.getNom());
			LOG.trace("Articles: ");
			fournisseur.getArticles().stream().forEach(a -> LOG.trace(a.getDesignation()));
			LOG.trace("Commandes: ");
			fournisseur.getCommandes().stream().forEach(c -> LOG.trace(c.toString()));
		}
		
		/* Extraction d'un bon de commande et tous ses articles associés */
		LOG.trace(" \n /* Extraction d'un bon de commande et tous ses articles associés */");
		TypedQuery<BonCommande> query8 = entityManager.createQuery("select b from BonCommande b where b.id=:id", BonCommande.class);
		query8.setParameter("id", 8);
		List<BonCommande> commandes1 = query8.getResultList();
		if (!commandes1.isEmpty()) {
			BonCommande bon = commandes1.get(0);
			 LOG.trace(bon.toString());
		}
		
		entityManager.close();
		entityManagerFactory.close();
		

	}
}
