package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattEAO {

	private EntityManagerFactory emf;

	public AnsattEAO() {
		emf = Persistence.createEntityManagerFactory("ansattPU");
	}

	public Ansatt finnAnsatt(int ansattId) {

		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Ansatt.class, ansattId);
		} finally {
			em.close();
		}
	}

	public Ansatt finnAnsattBNavn(String brukernavn) {

		EntityManager em = emf.createEntityManager();
		Ansatt ansatt;

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn LIKE :brukernavn",
					Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			ansatt = query.getSingleResult();

		} finally {
			em.close();
		}
		return ansatt;

	}

	public List<Ansatt> finnAlleAnsatte() { // Funker ikke
		
		EntityManager em = emf.createEntityManager();
		List<Ansatt> ansatte;

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a", Ansatt.class);
			ansatte = query.getResultList();
		} finally {
			em.close();
		}
		return ansatte;
	}
	
	public void oppdaterAnsatt(Ansatt ansatt) {
		
		EntityManager em = emf.createEntityManager(); 
		EntityTransaction tx = em.getTransaction(); 
		
		try {
			tx.begin();
			em.merge(ansatt); 
			tx.commit();
		}catch (Throwable e) {
			e.printStackTrace();
			if(tx.isActive()) {
				tx.rollback();
			}
		}finally {
			em.close();
		}
	}
	
	public void nyAnsatt(Ansatt nyAnsatt) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(nyAnsatt);
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}


}
