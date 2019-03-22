package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TodoEAO {

	private EntityManagerFactory emf 
	= Persistence.createEntityManagerFactory("todoPersistenceUnit");

	public Todo finnTodoMedId(int id) {
		
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Todo.class, id);

		} finally {
			em.close();
		}
		
	}

	public void lagreNyTodo(Todo todo) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(todo);
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

	public void oppdaterTodo(Todo todo) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(todo);
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
