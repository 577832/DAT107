package no.hvl.dat107;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VitnemalEAO {

    private EntityManagerFactory emf;

    public VitnemalEAO() {
        emf = Persistence.createEntityManagerFactory("???");
    }

    public ??? finnVitnemalForStudent(???) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
        	//???
            tx.commit();

        } catch (Throwable e) {
        	if (tx.isActive()) {
                tx.rollback();
        	}
        } finally {
            em.close();
        }
    }

    public ??? registrerKarakterForStudent(???) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
        	//???
            tx.commit();

        } catch (Throwable e) {
        	if (tx.isActive()) {
                tx.rollback();
        	}
        } finally {
            em.close();
        }
    }

    public ??? finnKarakter(???) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
        	//???
            tx.commit();

        } catch (Throwable e) {
        	if (tx.isActive()) {
                tx.rollback();
        	}
        } finally {
            em.close();
        }
    }
}
