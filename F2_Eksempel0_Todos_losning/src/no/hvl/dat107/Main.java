package no.hvl.dat107;

import java.time.LocalTime;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		/*
		 * Ting å prøve: 
		 * a) Hente ut todo med pk=2 
		 * b) Hente ut alle todos 
		 * c) Hente ut todo med tekst="Handle mat" 
		 * d) Legge til en ny todo med pk=4 
		 * e) Slette todo med pk=4
		 * f) Endre tekst på todo med pk=3 
		 */

		//Hjelpeklasse for å snakke med databasen
		TodoEAO todoEAO = new TodoEAO();
		
		//a)
		Todo todoa = todoEAO.finnTodoMedPk(2);
		System.out.println("a) Hente ut todo med pk=2");
		System.out.println("   " + todoa);
		
		//b)
		List<Todo> todosb = todoEAO.finnAlleTodos();
		System.out.println("b) Hente ut alle todos");
		System.out.println("   " + todosb);

		//c)
		List<Todo> todosc = todoEAO.finnTodosMedTekst("Handle mat");
		System.out.println("c) Hente ut todo med tekst=\"Handle mat\"");
		System.out.println("   " + todosc);
		
		//d)
		System.out.println("d) Legge til en ny todo med pk=4");
		Todo todony = new Todo(4, "Gjøre lekser");
		todoEAO.lagreNyTodo(todony);
		Todo todod = todoEAO.finnTodoMedPk(4);
		System.out.println("   Henter ut todo med pk=4");
		System.out.println("   " + todod);
		
		//e)
		System.out.println("e) Slette todo med pk=4");
		todoEAO.slettTodoMedPk(4);
		Todo todoe = todoEAO.finnTodoMedPk(4);
		System.out.println("   Henter ut todo med pk=4");
		System.out.println("   " + todoe);

		//f)
		System.out.println("f) Endre tekst på todo med pk=3");
		Todo todof1 = todoEAO.finnTodoMedPk(3);
		todof1.setTekst("Endret tekst " + LocalTime.now());
		todoEAO.oppdaterTodo(todof1);
		Todo todof2 = todoEAO.finnTodoMedPk(3);
		System.out.println("   Henter ut todo med pk=3");
		System.out.println("   " + todof2);
		
	}
}
