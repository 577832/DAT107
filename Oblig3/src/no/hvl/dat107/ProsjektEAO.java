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

}
