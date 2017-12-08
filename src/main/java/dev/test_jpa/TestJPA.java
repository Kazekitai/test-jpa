package dev.test_jpa;

import java.util.logging.Logger;

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
		TypedQuery<Article> query = entityManager.createQuery("select a from Article a", Article.class);
		if (!query.getResultList().isEmpty()) {
			for (int i = 0; i < query.getResultList().size(); i++) {
				if (query.getResultList().get(i) != null) {
					Article art = query.getResultList().get(i);
					LOG.trace("ID - REF - DESIGNATION - PRIX - ID_FOU");
					LOG.trace(art.toString());

				}
			}
		}
		

	}
}
