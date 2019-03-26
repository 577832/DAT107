package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class VitnemalEAO {

    private EntityManagerFactory emf;

    public VitnemalEAO() {
        emf = Persistence.createEntityManagerFactory("vitnemalPU");
    }

    public Vitnemal finnVitnemalForStudent(int studNr) {
        
        EntityManager em = emf.createEntityManager();

        try {
        	return em.find(Vitnemal.class, studNr); //Returnerer null hvis ikke finnes

        } finally {
            em.close();
        }
    }

    public Karakter registrerKarakterForStudent(int studNr, String emnekode, 
    		LocalDate eksDato, String karakter) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Karakter nyKar = null;

        try {
            //Denne er relativt kompleks. Masse å tenke på.
        	//Vi får ta det skritt for skritt.
            
            //1 - Vi kan si at vi kun registrerer ny karakter om det allerede
        	//    er registrert et vitnemål for denne studenten i databasen.
            Vitnemal vitnemal = em.find(Vitnemal.class, studNr);
            if (vitnemal != null) {
            	
                tx.begin();
                
                //2 - Det er et karakterobjekt som skal persisteres.
                //    Vi må begynne med å opprette det.
                nyKar = new Karakter();
                nyKar.setKurskode(emnekode);
                nyKar.setEksDato(eksDato);
                nyKar.setKarakter(karakter);
                nyKar.setVitnemal(vitnemal); //Nødv. pga trenger fremmednøkkel.
                
                //3 - Vi har valgt en toveis forbindelse mellom karakterer
                //    og vitnemål, og må dessverre selv passe på å oppdatere
                //    karakterlisten i vitnemål.
                vitnemal.leggTilKarakter(nyKar);

                //    Hvis vitnemal allerede er i "managed" tilstand trenger 
                //    vi ikke å "merge" denne for å synce med databasen.
                //    Et søk med em.find(Vitnemal.class, studNr) => "merged"
                //    Et søk med finnVitnemalForStudent(studNr) => "detached"
                 
                //4 - Da har vi opprettet og koblet sammen objektene, og
                //    vi kan be em om å lagre den nye karakteren i databasen.
                em.persist(nyKar);
                
                tx.commit();
            }
            
        } catch (Throwable e) {
        	if (tx.isActive()) {
                tx.rollback();
        	}
        } finally {
            em.close();
        }
        return nyKar;
    }
//
//    public ??? finnKarakter(???) {
//        
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        try {
//            tx.begin();
//        	//???
//            tx.commit();
//
//        } catch (Throwable e) {
//        	if (tx.isActive()) {
//                tx.rollback();
//        	}
//        } finally {
//            em.close();
//        }
//    }
}
