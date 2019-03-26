package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "forelesning3", name = "karakter")
public class Karakter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int karNr;
	
	private String kurskode;
	private LocalDate eksDato;
	private String karakter;
	
	@ManyToOne
	@JoinColumn(name = "studNr", referencedColumnName = "studNr")
	private Vitnemal vitnemal;
	
	

	@Override
	public String toString() {
		return "   Karakter [karNr=" + karNr + ", kurskode=" + kurskode 
				+ ", eksDato=" + eksDato + ", karakter=" + karakter
				+ ", studNr=" + vitnemal.getStudNr() + "]";
	}

	public int getKarNr() {
		return karNr;
	}

	public String getKurskode() {
		return kurskode;
	}

	public void setKurskode(String kurskode) {
		this.kurskode = kurskode;
	}

	public LocalDate getEksDato() {
		return eksDato;
	}

	public void setEksDato(LocalDate eksDato) {
		this.eksDato = eksDato;
	}

	public String getKarakter() {
		return karakter;
	}

	public void setKarakter(String karakter) {
		this.karakter = karakter;
	}

	public Vitnemal getVitnemal() {
		return vitnemal;
	}

	public void setVitnemal(Vitnemal vitnemal) {
		this.vitnemal = vitnemal;
	}

	
	
}
