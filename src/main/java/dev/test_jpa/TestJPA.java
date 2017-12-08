package dev.test_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.slf4j.LoggerFactory;

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
		TypedQuery<Article> query2 = entityManager.createQuery("select a from Article a where a.id='3'", Article.class);	
		List<Article> articles1 = query2.getResultList();
		if (!articles1.isEmpty()) {
			Article art = articles1.get(0);
			LOG.trace(art.toString());
		}
		
		/* Récupération d'un article par sa référence */
		LOG.trace("\n /* Récupération d'un article par sa référence */");
		TypedQuery<Article> query3 = entityManager.createQuery("select a from Article a where a.ref='D04'", Article.class);	
		List<Article> articles2 = query3.getResultList();
		if (!articles2.isEmpty()) {
			Article art = articles2.get(0);
			LOG.trace(art.toString());
		}
		
		entityManager.close();
		entityManagerFactory.close();
		

	}
}
