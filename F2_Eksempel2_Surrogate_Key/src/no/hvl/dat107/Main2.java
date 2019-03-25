package no.hvl.dat107;

public class Main2 {

    public static void main(String[] args) {

        PersonEOA personEAO = new PersonEOA();

        Person lars = new Person();
        lars.setNavn("Lars");
        System.out.println(lars);
        personEAO.savePerson(lars);
        System.out.println(lars);
    }

}
