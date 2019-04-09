package no.hvl.dat107;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import no.hvl.dat107.AvdelingEAO;

public class Meny {

	AnsattEAO eao = new AnsattEAO();
	public static final Scanner IN = new Scanner(System.in);
	public static final String SKILLE = "-------------------------------------------";

	public Meny(AnsattEAO eao) {
		this.eao = eao;
	}

	public static void start() {

		AvdelingEAO eao2 = new AvdelingEAO();
		AnsattEAO eao = new AnsattEAO();
		ProsjektEAO eaoPro = new ProsjektEAO(); 

		String meny = ("Skriv tallet for operasjonen du ønsker å utføre: " + "\n" + "1: Finn Ansatt med Ansatt- ID"
				+ "\n" + "2: Finn Ansatt med brukernavn" + "\n" + "3: Skriv ut liste med alle ansatte" + "\n"
				+ "4: Oppdater en ansastt sin stilling eller lønn" + "\n" + "5: Legger inn en ny ansatt" + "\n"
				+ "6: Finn Avdeling med Avdelings - ID" + "\n"
				+ "7: Skriv ut liste med ansatte i avdeling og sjef i avdeling" + "\n"
				+ "8: Oppdaterer avdeling til ansatt" + "\n" + "9: Opprett ny avdeling: " + "\n"
				+  "10: Legg inn nytt prosjekt" + "\n" + "0: Lagre og avslutt");

		int input = 1;

		do {
			System.out.println(SKILLE);
			System.out.println(meny);
			input = Integer.parseInt(IN.nextLine());

			switch (input) {

			case 1:

				System.out.println("Oppgi ansatt-id:");
				int id = Integer.parseInt(IN.nextLine());
				Ansatt a = eao.finnAnsatt(id);
				System.out.println(a.toString());
				break;
			case 2:

				System.out.println("Oppgi brukernavn:");
				String bn = IN.nextLine();
				Ansatt a2 = eao.finnAnsattBNavn(bn);
				System.out.println(a2.toString());
				break;
			case 3:

				List<Ansatt> anslist = eao.finnAlleAnsatte();

				for (Ansatt e : anslist) {
					System.out.println(e);
					System.out.println(SKILLE);
				}
				break;

			case 4:

				System.out.println("Skriv id til ansatt som skal få ny stilling og lønn");
				int id2 = Integer.parseInt(IN.nextLine());
				Ansatt a3 = eao.finnAnsatt(id2);
				System.out.println("Hvilken stilling skal ansatt med ID: " + id2 + " ha?");
				String stilling = IN.nextLine();
				System.out.println("Hvilken lønn skal denne ansatte ha?");

				int lonn = IN.nextInt();
				a3.setStilling(stilling);
				a3.setLonn(lonn);
				eao.oppdaterAnsatt(a3);
				System.out.println(a3.toString());
				break;
			case 5:
				Ansatt a4 = new Ansatt();
				boolean gyldig = false;
				String bruker = null;
				while (gyldig == false) {

					System.out.println("Brukernavn på ny ansatt:");
					bruker = IN.nextLine();
					if (bruker.length() <= 4) {
						gyldig = true;
					} else {
						System.out.println("Ugydlig brukernavn");
					}
				}

				a4.setBrukernavn(bruker);

				System.out.println("Fornavn:");
				String fn = IN.nextLine();
				a4.setFornavn(fn);

				System.out.println("Etternavn");
				String en = IN.nextLine();
				a4.setEtternavn(en);

				System.out.println("Ansatt dato:");
				String date = IN.nextLine();
				LocalDate ansattDato = LocalDate.parse(date);
				a4.setAnsDato(ansattDato);

				System.out.println("Stilling:");
				String sti = IN.nextLine();
				a4.setStilling(sti);

				System.out.println("Lønn:");
				int salary = Integer.parseInt(IN.nextLine());
				a4.setLonn(salary);

				System.out.println("AvdelingsID:");
				int avdeling = Integer.parseInt(IN.nextLine());
				a4.setAvdelingsID(avdeling);

				eao.nyAnsatt(a4);

				break;
			case 6:
				System.out.println("Finn avdeling med avdelingsID");
				System.out.println("Oppgi avdelings-id:");
				int avdelingID = Integer.parseInt(IN.nextLine());
				Avdeling b = eao2.finnAvdelingMedId(avdelingID);
				System.out.println(b.toString());

				break;
			case 7:

				System.out.println("Skriv ut liste av ansatte i en avdeling");
				System.out.println("Oppgi avdelings-id");
				int avdelingsId = Integer.parseInt(IN.nextLine());
				Avdeling b1 = eao2.finnAvdelingMedId(avdelingsId);
				System.out.println("Sjef i  avdeling " + avdelingsId + " er: " + b1.getSjefAnsatt().getFornavn() + " "
						+ b1.getSjefAnsatt().getEtternavn());
				System.out.println("Avdeling: " + b1.getNavn() + "\n" + "Ansatte: ");
				List<Ansatt> liste = b1.getAnsatte();
				Iterator<Ansatt> iter = liste.iterator();
				while (iter.hasNext()) {
					Ansatt ansatt = iter.next();
					if (!eao2.erSjef(ansatt)) {
						System.out.println(SKILLE);
						System.out.println("Navn: " + ansatt.getFornavn() + " " + ansatt.getEtternavn() + "\n"
								+ "Stilling: " + ansatt.getStilling());
					}
				}

				break;
			case 8:

				System.out.println("Oppdater avdeling ansatt jobber i:");
				System.out.println("Oppgi ansatt-id på ansatt du vil oppdatere avdeling på");
				int ansid = Integer.parseInt(IN.nextLine());
				Ansatt a5 = eao.finnAnsatt(ansid);

				if (!eao2.erSjef(a5)) {
					System.out.println("Den ansatte jobber i denne avdelingen: " + a5.getAvdelingsID());
					System.out.println("Hvilken avdeling vil du at den ansatte skal bytte til, skriv id'en?");
					int avdid2 = Integer.parseInt(IN.nextLine());
					a5.setAvdelingsID(avdid2);
					eao.oppdaterAnsatt(a5);
					System.out.println(a5.toString());
				} else {
					System.out.println(
							"Kan ikke oppdatere ansatte sin avdeling, fordi han er sjef i nåværende avdeling.");
				}
				break;
			case 9:
				System.out.println("Opprett ny avdeling:");
				System.out.println("Navn på den nye avdelingen:");
				String navnAvd = IN.nextLine();

				System.out.println("AnsattID på den nye sjefen for denne avdelingen:");
				int sjef = Integer.parseInt(IN.nextLine());

				Ansatt ansatt = eao.finnAnsatt(sjef);
				Avdeling nyAvdeling = null;

				if (!eao2.erSjef(ansatt)) {
					nyAvdeling = new Avdeling(navnAvd, sjef);
					eao2.nyAvdeling(nyAvdeling);
					ansatt.setAvdeling(nyAvdeling);

				} else {
					System.out.println("Ansatt kan ikke bli sjef for denne avdelingen.");
				}
				nyAvdeling.getAvdelingsid();
				ansatt.setAvdelingsID(nyAvdeling.getAvdelingsid());
				nyAvdeling.setSjefAnsatt(ansatt);
				eao.oppdaterAnsatt(ansatt);

				break;
			case 10:
				
				System.out.println("Opprett prosjekt:");
				System.out.println("Navn på prosjektet: ");
				String proNavn = IN.nextLine(); 
				
				System.out.println("Beksrivelse av prosjekt: ");
				String beskrivelse = IN.nextLine(); 
				
				
				Prosjekt pro1 = new Prosjekt(proNavn, beskrivelse); 
				eaoPro.nyttProsjekt(pro1);
				pro1.setNavn(proNavn);
				pro1.setBeskrivelse(beskrivelse);
				
				
				break; 
			}

		} while (input != 0);
		IN.close();
	}
}
