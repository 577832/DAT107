package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3", name = "Prosjektdeltagelse")
public class ProsjektDeltagelse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ProsjektDeltagelseID;
	
	private String rolle; 
	private int antTimer; 
	
	@ManyToOne
	@JoinColumn(name="ansattID")
	private Ansatt ansatt; 
	
	@ManyToOne
	@JoinColumn(name="ProsjektID")
	private Prosjekt prosjekt; 
	
	public ProsjektDeltagelse() {}
	
	public ProsjektDeltagelse( Ansatt ansatt, String rolle, int antTimer, Prosjekt prosjekt) {
	
	this.ansatt = ansatt; 
	this.rolle = rolle; 
	this.antTimer = antTimer;
	this.prosjekt = prosjekt; 
		
	}

	@Override
	public String toString() {
		return "ProsjektDeltagelse: "  + "\n" + "Ansatt-ID: " + ansatt.getAnsattId() + "\n" +  "ProsjektDeltagelseID: " + ProsjektDeltagelseID
				+ "\n" +  "Rolle: " + rolle + "\n" + "AntTimer: " + antTimer;
	}
	

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public int getAntTimer() {
		return antTimer;
	}

	public void setAntTimer(int antTimer) {
		this.antTimer = antTimer;
	}

	public Ansatt getAnsatt() {
		return ansatt;
	}

	public void setAnsatt(Ansatt ansatt) {
		this.ansatt = ansatt;
	}

	public Prosjekt getProsjekt() {
		return prosjekt;
	}

	public void setProsjekt(Prosjekt prosjekt) {
		this.prosjekt = prosjekt;
	}


	
	
	
	
	
}
