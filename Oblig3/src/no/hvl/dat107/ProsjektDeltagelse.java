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
	private int ansattid; 
	private int prosjektDeltagelseID; 
	private String rolle; 
	private int antTimer; 
	
	@ManyToOne
	@JoinColumn(name="Ansatt_ID")
	private Ansatt ansatt; 
	
	@ManyToOne
	@JoinColumn(name="Prosjekt_ID")
	private Prosjekt prosjekt; 
	
	public ProsjektDeltagelse() {}
	
	public ProsjektDeltagelse( int ansattid, String rolle, int antTimer) {
	
	this.ansattid = ansattid; 
	this.rolle = rolle; 
	this.antTimer = antTimer; 
		
	}

	@Override
	public String toString() {
		return "ProsjektDeltagelse: "  + "\n" + "Ansatt-ID: " + ansattid + "\n" +  "ProsjektDeltagelseID: " + prosjektDeltagelseID
				+ "\n" +  "Rolle: " + rolle + "\n" + "AntTimer: " + antTimer;
	}

	public int getAnsattid() {
		return ansattid;
	}

	public void setAnsattid(int ansattid) {
		this.ansattid = ansattid;
	}

	public int getProsjektDeltagelseID() {
		return prosjektDeltagelseID;
	}

	public void setProsjektDeltagelseID(int prosjektDeltagelseID) {
		this.prosjektDeltagelseID = prosjektDeltagelseID;
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
