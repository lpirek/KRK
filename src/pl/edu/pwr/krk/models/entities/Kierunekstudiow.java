package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Kierunekstudiow implements java.io.Serializable {

	private int id;
	private Wydzial wydzial;
	private String nazwa;
	private Set<Programksztalcenia> programksztalcenias = new HashSet<Programksztalcenia>(0);
	private Set<Kierunkowyefektksztalcenia> kierunkowyefektksztalcenias = new HashSet<Kierunkowyefektksztalcenia>(0);
	private Set<Specjalizacja> specjalizacjas = new HashSet<Specjalizacja>(0);

	public Kierunekstudiow() {
	}

	public Kierunekstudiow(int id, Wydzial wydzial, String nazwa) {
		this.id = id;
		this.wydzial = wydzial;
		this.nazwa = nazwa;
	}

	public Kierunekstudiow(int id, Wydzial wydzial, String nazwa, Set<Programksztalcenia> programksztalcenias,
			Set<Kierunkowyefektksztalcenia> kierunkowyefektksztalcenias, Set<Specjalizacja> specjalizacjas) {
		this.id = id;
		this.wydzial = wydzial;
		this.nazwa = nazwa;
		this.programksztalcenias = programksztalcenias;
		this.kierunkowyefektksztalcenias = kierunkowyefektksztalcenias;
		this.specjalizacjas = specjalizacjas;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Wydzial getWydzial() {
		return this.wydzial;
	}

	public void setWydzial(Wydzial wydzial) {
		this.wydzial = wydzial;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Set<Programksztalcenia> getProgramksztalcenias() {
		return this.programksztalcenias;
	}

	public void setProgramksztalcenias(Set<Programksztalcenia> programksztalcenias) {
		this.programksztalcenias = programksztalcenias;
	}

	public Set<Kierunkowyefektksztalcenia> getKierunkowyefektksztalcenias() {
		return this.kierunkowyefektksztalcenias;
	}

	public void setKierunkowyefektksztalcenias(Set<Kierunkowyefektksztalcenia> kierunkowyefektksztalcenias) {
		this.kierunkowyefektksztalcenias = kierunkowyefektksztalcenias;
	}

	public Set<Specjalizacja> getSpecjalizacjas() {
		return this.specjalizacjas;
	}

	public void setSpecjalizacjas(Set<Specjalizacja> specjalizacjas) {
		this.specjalizacjas = specjalizacjas;
	}

}
