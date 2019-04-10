package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProsjektDeltagelseEAO {

	private EntityManagerFactory emf; 
	
	public ProsjektDeltagelseEAO() {
		
		emf = Persistence.createEntityManagerFactory("ansattPU");
	}
	
	public void registrerProsjektDeltagalse(ProsjektDeltagelse regPD) {
		
		EntityManager em = emf.createEntityManager(); 
		EntityTransaction tx = em.getTransaction(); 
		
		try {
			tx.begin();
			em.persist(regPD);
			tx.commit();
		}catch(Throwable e) {
			e.printStackTrace();
			if(tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close(); 
		}
		
	}
	
}
