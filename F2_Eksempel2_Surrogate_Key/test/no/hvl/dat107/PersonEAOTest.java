package no.hvl.dat107;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PersonEAOTest {
    
    /*
     * Problemet med testing av klasser som jobber mot database
     * er at det er ikke alltid s� lett � vite hva som er i
     * databasen. I tillegg m� vi passe p� at tester ikke endrer
     * p� dataene slik at andre tester feiler.
     * 
     * Men ved � ha noen "faste" testdata i databasen kan man
     * via JUnit teste b�de at vi har kontakt med databasen og
     * at grunnleggende funksjonalitet virker.
     */

    PersonEOA personEAO;
    Person person1;
    
    @Before
    public void foerHverTest() {
        personEAO = new PersonEOA();
        person1 = personEAO.retrievePerson(1);
    }
    
	@Test
	public void person1SkalHetePer() {
		assertEquals("Per Viskeler", person1.getNavn());
	}
	
	@Test
	public void endringAvNavnSkalVirkeFint() {
	    
        String gammeltNavn = person1.getNavn();
        String nyttNavn = "Nytt Navn";
        
        //Skifter til nytt navn og sjekker
        person1.setNavn(nyttNavn);
        personEAO.updatePerson(person1);
        person1 = personEAO.retrievePerson(1);
        assertEquals(nyttNavn, person1.getNavn());
        
        //Skifter tilbake for � ikke �delegge for fremtidige tester.
        //Dette kan gj�res bedre, men det blir litt komplisert.
        person1.setNavn(gammeltNavn);
        personEAO.updatePerson(person1);
        person1 = personEAO.retrievePerson(1);
        assertEquals(gammeltNavn, person1.getNavn());
	}
	
	

}
