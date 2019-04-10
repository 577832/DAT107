package no.hvl.dat107;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3", name = "Avdeling")
public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingsid;
	private String navn;
	private int sjef;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "sjef", referencedColumnName = "ansattid")
	private Ansatt ansatt;

	@OneToMany(mappedBy = "Avdeling", fetch = FetchType.EAGER) // for det hele tiden automatisk
	private List<Ansatt> ansatte;

	public Avdeling() {

	}

	public Avdeling(String navn, int sjef) {

		this.navn = navn;
		this.sjef = sjef;
	}

	@Override
	public String toString() {

		return "Avdeling: " + "\n" + "AvdelingsID: " + avdelingsid + "\n" + "Navn: " + navn + "\n" + "Sjef: " + sjef;

	}

	public Ansatt getSjefAnsatt() {
		return ansatt;
	}

	public void leggTilAnsatt(Ansatt ansatt) {
		ansatte.add(ansatt); 
	}
	public void setSjefAnsatt(Ansatt ansatt) {
		this.ansatt = ansatt;
	}

	public int getAvdelingsid() {
		return avdelingsid;
	}

	public void setAvdelingsid(int avdelingsid) {
		this.avdelingsid = avdelingsid;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}


	public List<Ansatt> getAnsatte() {
		return ansatte;
	}

	public void setAnsatte(List<Ansatt> ansatte) {
		this.ansatte = ansatte;
	}
}
