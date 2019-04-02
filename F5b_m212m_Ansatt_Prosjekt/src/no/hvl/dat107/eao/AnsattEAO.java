package no.hvl.dat107.eao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Prosjekt;
import no.hvl.dat107.entity.Prosjektdeltagelse;
import no.hvl.dat107.entity.ProsjektdeltagelsePK;

public class AnsattEAO {

    private EntityManagerFactory emf;

    public AnsattEAO() {
        emf = Persistence.createEntityManagerFactory("AnsattProsjektPU");
    }
    
    public Ansatt finnAnsattMedId(int id) {

        EntityManager em = emf.createEntityManager();

        Ansatt ansatt = null;
        try {
            ansatt = em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
        return ansatt;
    }

    public void registrerProsjektdeltagelse(Ansatt a, Prosjekt p) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            a = em.merge(a);
            p = em.merge(p);
            
            Prosjektdeltagelse pd = new Prosjektdeltagelse(a, p, 0);
            
            a.leggTilProsjektdeltagelse(pd);
            p.leggTilProsjektdeltagelse(pd);
            
            em.persist(pd);
            
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

    public void slettProsjektdeltagelse(Ansatt a, Prosjekt p) {
    	
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            ProsjektdeltagelsePK pdpk = new ProsjektdeltagelsePK(
            		a.getId(), p.getId());
            
            Prosjektdeltagelse pd = em.find(Prosjektdeltagelse.class, pdpk);
            
            em.remove(pd);
            
            em.merge(a).fjernProsjektdeltagelse(pd);
            em.merge(p).fjernProsjektdeltagelse(pd);
            
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
