package no.hvl.dat107;

public class Main {

	public static void main(String[] args) {

		System.out.println("a) Hente ut todo med pk=2");
		
		System.out.println("b) Hente ut alle todos");

		System.out.println("c) Hente ut todo med tekst=\"Handle mat\"");
		
		System.out.println("d) Legge til en ny todo med pk=4");
		
		System.out.println("e) Slette todo med pk=4");

		System.out.println("f) Endre tekst på todo med pk=3");
	}
	
//	public void xxx() {
//		
//		EntityManagerFactory emf 
//				= Persistence.createEntityManagerFactory("todoPersistenceUnit");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		try {
//			tx.begin();
//			//...
//			tx.commit();
//
//		} catch (Throwable e) {
//			e.printStackTrace();
//			if (tx.isActive()) {
//				tx.rollback();
//			}
//		} finally {
//			em.close();
//		}
//	}

}