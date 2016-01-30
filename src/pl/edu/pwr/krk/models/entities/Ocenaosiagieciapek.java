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
	private int column;
	private Set<Pekocenaosiagnieciapek> pekocenaosiagnieciapeks = new HashSet<Pekocenaosiagnieciapek>(0);

	public Ocenaosiagieciapek() {
	}

	public Ocenaosiagieciapek(Kartaprzedmiotu kartaprzedmiotu, String rodzajOceny, String numer, String opis,
			String sposobOceny, int column) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.rodzajOceny = rodzajOceny;
		this.numer = numer;
		this.opis = opis;
		this.sposobOceny = sposobOceny;
		this.column = column;
	}

	public Ocenaosiagieciapek(Kartaprzedmiotu kartaprzedmiotu, String rodzajOceny, String numer, String opis,
			String sposobOceny, int column, Set<Pekocenaosiagnieciapek> pekocenaosiagnieciapeks) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.rodzajOceny = rodzajOceny;
		this.numer = numer;
		this.opis = opis;
		this.sposobOceny = sposobOceny;
		this.column = column;
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

	public int getColumn() {
		return this.column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Set<Pekocenaosiagnieciapek> getPekocenaosiagnieciapeks() {
		return this.pekocenaosiagnieciapeks;
	}

	public void setPekocenaosiagnieciapeks(Set<Pekocenaosiagnieciapek> pekocenaosiagnieciapeks) {
		this.pekocenaosiagnieciapeks = pekocenaosiagnieciapeks;
	}

}
