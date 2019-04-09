package no.hvl.dat107;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3", name = "Prosjekt")

public class Prosjekt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjektid;
	private String navn; 
	private String beskrivelse; 
	
	@OneToMany(mappedBy = "Prosjekt")
	private List<ProsjektDeltagelse> deltagelse; 
	
	public Prosjekt() {
		
	}
	
	public Prosjekt(String navn, String beskrivelse) {
		this.navn = navn; 
		this.beskrivelse = beskrivelse; 
	}

	@Override
	public String toString() {
		return "Prosjekt: " + "\n" + "ProsjektID " + prosjektid + "\n" +  "Navn: " + navn + "\n" + "Beskrivelse: " + beskrivelse;
	}

	public int getProsjektid() {
		return prosjektid;
	}

	public void setProsjektid(int prosjektid) {
		this.prosjektid = prosjektid;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public List<ProsjektDeltagelse> getDeltagelse() {
		return deltagelse;
	}

	
	
}
