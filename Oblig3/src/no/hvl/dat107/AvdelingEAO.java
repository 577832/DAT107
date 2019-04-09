package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AvdelingEAO {

	private EntityManagerFactory emf;

	public AvdelingEAO() {
		emf = Persistence.createEntityManagerFactory("ansattPU");
	}

	public Avdeling finnAvdelingMedId(int id) {

		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Avdeling.class, id);
		} finally {
			em.close();
		}
	}

	public void nyAvdeling(Avdeling nyAvdeling) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(nyAvdeling);
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

	public boolean erSjef(Ansatt ansatt) {

		Avdeling avdeling = ansatt.getAvdeling();

		if (ansatt.getAnsattId() == avdeling.getSjefAnsatt().getAnsattId()) {
			return true;
		}

		return false;
	}

}
