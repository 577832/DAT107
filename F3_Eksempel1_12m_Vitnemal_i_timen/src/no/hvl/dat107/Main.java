package no.hvl.dat107;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		VitnemalEAO vitnemalEAO = new VitnemalEAO();
		
		Vitnemal vitnemal = vitnemalEAO.finnVitnemalForStudent(123456);
		vitnemal.skrivUt();
		System.out.println();
		
		//Denne kan kun kj�res en gang. Deretter stopper den p�
		//UNIQUE-contrainten. Burde v�rt h�ndtert. ...
		//For testing kan emnekode endres for hver kj�ring.
		Karakter nyKarakter = vitnemalEAO.registrerKarakterForStudent(
				123456, "DAT113", LocalDate.of(2019, 03, 26), "A");
		
		System.out.println(nyKarakter);
		System.out.println();
		
		vitnemal = vitnemalEAO.finnVitnemalForStudent(123456);
		vitnemal.skrivUt();
		System.out.println();
	}

}
