package no.hvl.dat107;

public class Main {

	public static void main(String[] args) {

		AnsattEAO eao = new AnsattEAO();
		Meny meny = new Meny(eao);

		Meny.start();
		

	}
}
