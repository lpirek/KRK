package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Kierunkowyefektksztalcenia implements java.io.Serializable {

	private int id;
	private Kierunekstudiow kierunekstudiow;
	private Specjalizacja specjalizacja;
	private String zakres;
	private String numer;
	private String opis;
	private int column;
	private Set<Kekpek> kekpeks = new HashSet<Kekpek>(0);
	private Set<Mekkek> mekkeks = new HashSet<Mekkek>(0);
	private Set<Przedmiotkek> przedmiotkeks = new HashSet<Przedmiotkek>(0);

	public Kierunkowyefektksztalcenia() {
	}

	public Kierunkowyefektksztalcenia(int id, Kierunekstudiow kierunekstudiow, Specjalizacja specjalizacja,
			String zakres, String numer, String opis, int column) {
		this.id = id;
		this.kierunekstudiow = kierunekstudiow;
		this.specjalizacja = specjalizacja;
		this.zakres = zakres;
		this.numer = numer;
		this.opis = opis;
		this.column = column;
	}

	public Kierunkowyefektksztalcenia(int id, Kierunekstudiow kierunekstudiow, Specjalizacja specjalizacja,
			String zakres, String numer, String opis, int column, Set<Kekpek> kekpeks, Set<Mekkek> mekkeks,
			Set<Przedmiotkek> przedmiotkeks) {
		this.id = id;
		this.kierunekstudiow = kierunekstudiow;
		this.specjalizacja = specjalizacja;
		this.zakres = zakres;
		this.numer = numer;
		this.opis = opis;
		this.column = column;
		this.kekpeks = kekpeks;
		this.mekkeks = mekkeks;
		this.przedmiotkeks = przedmiotkeks;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kierunekstudiow getKierunekstudiow() {
		return this.kierunekstudiow;
	}

	public void setKierunekstudiow(Kierunekstudiow kierunekstudiow) {
		this.kierunekstudiow = kierunekstudiow;
	}

	public Specjalizacja getSpecjalizacja() {
		return this.specjalizacja;
	}

	public void setSpecjalizacja(Specjalizacja specjalizacja) {
		this.specjalizacja = specjalizacja;
	}

	public String getZakres() {
		return this.zakres;
	}

	public void setZakres(String zakres) {
		this.zakres = zakres;
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

	public int getColumn() {
		return this.column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Set<Kekpek> getKekpeks() {
		return this.kekpeks;
	}

	public void setKekpeks(Set<Kekpek> kekpeks) {
		this.kekpeks = kekpeks;
	}

	public Set<Mekkek> getMekkeks() {
		return this.mekkeks;
	}

	public void setMekkeks(Set<Mekkek> mekkeks) {
		this.mekkeks = mekkeks;
	}

	public Set<Przedmiotkek> getPrzedmiotkeks() {
		return this.przedmiotkeks;
	}

	public void setPrzedmiotkeks(Set<Przedmiotkek> przedmiotkeks) {
		this.przedmiotkeks = przedmiotkeks;
	}

}
