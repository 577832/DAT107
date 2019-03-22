package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TodoEAO {
	
	private EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("todoPersistenceUnit");
	
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

	public void slettTodoMedPk(int pk) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Todo todo = em.find(Todo.class, pk);
			em.remove(todo);
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

	public void lagreNyTodo(Todo todony) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(todony);
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

	public List<Todo> finnTodosMedTekst(String tekst) {
		
		EntityManager em = emf.createEntityManager();
		
		List<Todo> todos;
		
		try {
			//https://docs.oracle.com/javaee/6/tutorial/doc/bnbtg.html
			TypedQuery<Todo> query = em.createQuery(
					"SELECT t FROM Todo t WHERE t.tekst LIKE :tekst", Todo.class);
			query.setParameter("tekst", tekst);
			todos = query.getResultList();
		
		} finally {
			em.close();
		}
		return todos;
	}

	public List<Todo> finnAlleTodos() {
		
		EntityManager em = emf.createEntityManager();
		
		List<Todo> todos;
		
		try {
			TypedQuery<Todo> query = em.createQuery(
					"SELECT t FROM Todo t", Todo.class);
			todos = query.getResultList();
		
		} finally {
			em.close();
		}
		return todos;
	}

	public Todo finnTodoMedPk(int pk) {
		
		EntityManager em = emf.createEntityManager();

		Todo todo;

		try {
			todo = em.find(Todo.class, pk);

		} finally {
			em.close();
		}
		return todo;
	}

}
