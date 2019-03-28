package no.hvl.dat107;

public class Main {

    public static void main(String[] args) {
        
        KontorEAO kontorEAO = new KontorEAO();
        
        Rom romE425 = kontorEAO.finnRomNr("E425");
        System.out.println(romE425);
        Rom romF118 = kontorEAO.finnRomNr("F118");
        System.out.println(romF118);
        
        Ansatt ansatt1 = kontorEAO.finnAnsattNr(1);
        System.out.println(ansatt1);
        Ansatt ansatt2 = kontorEAO.finnAnsattNr(2);
        System.out.println(ansatt2);
        
    }
}
