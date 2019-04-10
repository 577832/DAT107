package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProsjektEAO {
	
	private EntityManagerFactory emf; 
	
	public ProsjektEAO() {
	emf = Persistence.createEntityManagerFactory("ansattPU");
	
	}
	/**
	 * En metode som legger til nytt prosjekt
	 * @param nyttProsjekt
	 */
	public void nyttProsjekt(Prosjekt nyttProsjekt) {
		
		EntityManager em = emf.createEntityManager(); 
		EntityTransaction tx = em.getTransaction(); 
		
		try {
			tx.begin();
			em.persist(nyttProsjekt);
			tx.commit();
		}catch(Throwable p) {
			p.printStackTrace();
			if(tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		
	}
		public Prosjekt finnProsjekt(int prosjektID) {

			EntityManager em = emf.createEntityManager();

			try {
				return em.find(Prosjekt.class, prosjektID);
			} finally {
				em.close();
			}
		}
	

}
