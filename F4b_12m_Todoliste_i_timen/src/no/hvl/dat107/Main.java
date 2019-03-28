package no.hvl.dat107;

public class Main {

    public static void main(String[] args) {
        
        TodolisteEAO todolisteEAO = new TodolisteEAO();

        Todo rydde = new Todo("Rydde");
        Todo vaskeOpp = new Todo("Vaske opp");
        Todo stovsuge = new Todo("Støvsuge");
        Todo vaskeVinduer = new Todo("Vaske vinduer");
        
        //------------------------------------------------------------------------
        
        System.out.println("\n\nLager en liste [Husarbeid], legger til 3 todos og lagrer ...");
        
        Todoliste husarbeid = new Todoliste("Husarbeid");
        
        husarbeid.leggTil(rydde);
        husarbeid.leggTil(vaskeOpp);
        husarbeid.leggTil(stovsuge);
        
        todolisteEAO.lagreListe(husarbeid);
        int listeId = husarbeid.getListeId();
       
        System.out.println("Etter lagreListe():");
        System.out.println(todolisteEAO.finnListe(listeId));
        
        //------------------------------------------------------------------------
        
//        System.out.println("\n\nEndrer navn, fjerner [Vaske Opp], legger til [Vaske vinduer], "
//        		+ "endrer støvsuging-tekst til \"Gøy støvsuging\" og oppdaterer ...");
//
//        husarbeid.setNavn("Gøy husarbeid");
//        husarbeid.fjern(vaskeOpp);         
//        husarbeid.leggTil(vaskeVinduer);   
//        stovsuge.setTekst("Gøy støvsuging");
//       
//        todolisteEAO.oppdaterListe(husarbeid);
//        
//        System.out.println("Etter oppdaterListe():");
//        System.out.println(todolisteEAO.finnListe(listeId));
//        
//        //------------------------------------------------------------------------
//        
//        System.out.println("\n\nSøker opp listen på navn ...");
//        
//        System.out.println("Etter finnListePaaNavn(\"Gøy husarbeid\")");
//        System.out.println(todolisteEAO.finnListePaaNavn("Gøy husarbeid"));
//        
//        //------------------------------------------------------------------------
//        
//        System.out.println("\n\nHvis kun enveis forhold, finne todos med JPQL ...");
//        
//        System.out.println("Etter finnTodosIListe(husarbeid.getListeId())");
//        System.out.println(todolisteEAO.finnTodosIListe(listeId));
//        
//        //------------------------------------------------------------------------
//        
//        System.out.println("\n\nSletter listen ...");
//        
//        todolisteEAO.slettListe(husarbeid);
//        System.out.println("Etter slettListe()");
//        System.out.println(todolisteEAO.finnListe(listeId));
    }
}






