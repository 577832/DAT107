package no.hvl.dat107;

public class Main {

	public static void main(String[] args) {
		
		TodoEAO todoEAO = new TodoEAO();

		System.out.println("a) Hente ut todo med pk=2");
		Todo todo = todoEAO.finnTodoMedId(2);
		System.out.println("   " + todo);
		
		System.out.println("b) Hente ut alle todos");
		//Bruke en JPQL-spørring

		System.out.println("c) Hente ut todo med tekst=\"Handle mat\"");
		//Bruke en JPQL-spørring
		
//		System.out.println("d) Legge til en ny todo med pk=4");
//		Todo todo2 = new Todo(4, "Vaske gulv");
//		todoEAO.lagreNyTodo(todo2);
//		Todo todo3 = todoEAO.finnTodoMedId(4);
//		System.out.println("   " + todo3);
		
		System.out.println("e) Slette todo med pk=4");
		//Bruker em.remove(..)

		System.out.println("f) Endre tekst på todo med pk=3");
		Todo todo4 = todoEAO.finnTodoMedId(3);
		System.out.println("   " + todo4);
		todo4.setTekst("Støvsuge");
		todoEAO.oppdaterTodo(todo4);
		todo4 = todoEAO.finnTodoMedId(3);
		System.out.println("   " + todo4);
		
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