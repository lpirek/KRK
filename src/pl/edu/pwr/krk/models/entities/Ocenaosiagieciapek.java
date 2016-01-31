package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Ocenaosiagieciapek implements java.io.Serializable {

	private Integer id;
	private Kartaprzedmiotu kartaprzedmiotu;
	private String rodzajOceny;
	private String numer;
	private String opis;
	private String sposobOceny;
	private Set<Pekocenaosiagnieciapek> pekocenaosiagnieciapeks = new HashSet<Pekocenaosiagnieciapek>(0);

	public Ocenaosiagieciapek() {
	}

	public Ocenaosiagieciapek(Kartaprzedmiotu kartaprzedmiotu, String rodzajOceny, String numer, String opis,
			String sposobOceny) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.rodzajOceny = rodzajOceny;
		this.numer = numer;
		this.opis = opis;
		this.sposobOceny = sposobOceny;
	}

	public Ocenaosiagieciapek(Kartaprzedmiotu kartaprzedmiotu, String rodzajOceny, String numer, String opis,
			String sposobOceny, Set<Pekocenaosiagnieciapek> pekocenaosiagnieciapeks) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.rodzajOceny = rodzajOceny;
		this.numer = numer;
		this.opis = opis;
		this.sposobOceny = sposobOceny;
		this.pekocenaosiagnieciapeks = pekocenaosiagnieciapeks;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Kartaprzedmiotu getKartaprzedmiotu() {
		return this.kartaprzedmiotu;
	}

	public void setKartaprzedmiotu(Kartaprzedmiotu kartaprzedmiotu) {
		this.kartaprzedmiotu = kartaprzedmiotu;
	}

	public String getRodzajOceny() {
		return this.rodzajOceny;
	}

	public void setRodzajOceny(String rodzajOceny) {
		this.rodzajOceny = rodzajOceny;
	}

	public String getNumer() {
		return this.numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getSposobOceny() {
		return this.sposobOceny;
	}

	public void setSposobOceny(String sposobOceny) {
		this.sposobOceny = sposobOceny;
	}

	public Set<Pekocenaosiagnieciapek> getPekocenaosiagnieciapeks() {
		return this.pekocenaosiagnieciapeks;
	}

	public void setPekocenaosiagnieciapeks(Set<Pekocenaosiagnieciapek> pekocenaosiagnieciapeks) {
		this.pekocenaosiagnieciapeks = pekocenaosiagnieciapeks;
	}

}
