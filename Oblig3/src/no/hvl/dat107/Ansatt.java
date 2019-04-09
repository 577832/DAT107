package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3", name = "Ansatt")

public class Ansatt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AnsattId; 
	
	private String brukernavn; 
	private String fornavn; 
	private String etternavn; 
	private LocalDate ansDato; 
	private String stilling; 
	private int lonn;
	private int avdelingsid; 
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "avdelingsid", referencedColumnName = "avdelingsid")
	private Avdeling avdeling; 
	
	public Ansatt() {
		
	}
	
	public Ansatt(String brukernavn,  String fornavn, String etternavn, LocalDate ansDato, String stilling, int lonn ) {
		
		this.brukernavn = brukernavn;
		this.fornavn = fornavn; 
		this.etternavn = etternavn; 
		this.ansDato = ansDato; 
		this.stilling = stilling; 
		this.lonn = lonn; 
	}
	
	@Override
	public String toString() {
		return "Ansatt:" + "\n"+ "AnsattId: " + AnsattId + "\n" + "Brukernavn: " + brukernavn + "\n"+ "Fornavn: " + fornavn + "\n" + "Etternavn: "
				+ etternavn + "\n" + "Ansatt dato: " + ansDato + "\n"+ "Stilling: " + stilling + "\n" + "Lønn: " + lonn + "\n" + "Avdelingsid: " + avdelingsid;
			
	}
	
	public Avdeling getAvdeling() {
		return avdeling; 
	}
	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling; 
	}
	
	public int getAnsattId() {
		return AnsattId;
	}


	public void setAnsattId(int ansattId) {
		AnsattId = ansattId;
	}


	public String getBrukernavn() {
		return brukernavn;
	}


	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}


	public String getFornavn() {
		return fornavn;
	}


	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}


	public String getEtternavn() {
		return etternavn;
	}


	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}


	public LocalDate getAnsDato() {
		return ansDato;
	}


	public void setAnsDato(LocalDate ansDato) {
		this.ansDato = ansDato;
	}


	public String getStilling() {
		return stilling;
	}


	public void setStilling(String stilling) {
		this.stilling = stilling;
	}


	public int getLonn() {
		return lonn;
	}


	public void setLonn(int lonn) {
		this.lonn = lonn;
	} 

	public int getAvdelingsID() {
		return avdelingsid; 
	}
	
	public void setAvdelingsID(int avdelingsid) {
		this.avdelingsid = avdelingsid; 
	}


	
}
