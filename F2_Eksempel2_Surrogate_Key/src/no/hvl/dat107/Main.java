package no.hvl.dat107;

public class Main {

    public static void main(String[] args) {

        PersonEOA personEAO = new PersonEOA();

        finnEnOgEn(personEAO);

        finnAlle(personEAO);

        skiftNavnFremOgTilbake(personEAO);

        opprettOgSlettPerson(personEAO);

    }

    private static void finnEnOgEn(PersonEOA personEAO) {

        System.out.println(personEAO.retrievePerson(1));
        System.out.println(personEAO.retrievePerson(2));
        System.out.println(personEAO.retrievePerson(3));
        System.out.println(personEAO.retrievePerson(4));

        System.out.println("---");
    }

    private static void finnAlle(PersonEOA personEAO) {

        for (Person p : personEAO.retrieveAllePersoner()) {
            System.out.println(p);
        }

        System.out.println("---");
    }

    private static void skiftNavnFremOgTilbake(PersonEOA personEAO) {

        Person per = personEAO.retrievePerson(1);

        System.out.println(per);

        per.setNavn("X");
        personEAO.updatePerson(per);
        per = personEAO.retrievePerson(1);
        System.out.println(per);

        per.setNavn("Per Viskeler");
        personEAO.updatePerson(per);
        per = personEAO.retrievePerson(1);
        System.out.println(per);

        System.out.println("---");
    }

    private static void opprettOgSlettPerson(PersonEOA personEAO) {

        Person mikke = new Person();
        mikke.setNavn("Mikke Mus");

        int nyPersonId = personEAO.savePerson(mikke);
        
        mikke = personEAO.retrievePerson(nyPersonId);
        System.out.println(mikke);

        personEAO.deletePerson(mikke);
        mikke = personEAO.retrievePerson(nyPersonId);
        System.out.println(mikke);

        System.out.println("---");
    }

}
