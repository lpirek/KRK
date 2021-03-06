package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Specjalizacja implements java.io.Serializable {

	private Integer id;
	private Kierunekstudiow kierunekstudiow;
	private String nazwa;
	private Set<Kierunkowyefektksztalcenia> kierunkowyefektksztalcenias = new HashSet<Kierunkowyefektksztalcenia>(0);
	private Set<Przedmiot> przedmiots = new HashSet<Przedmiot>(0);

	public Specjalizacja() {
	}

	public Specjalizacja(Kierunekstudiow kierunekstudiow, String nazwa) {
		this.kierunekstudiow = kierunekstudiow;
		this.nazwa = nazwa;
	}

	public Specjalizacja(Kierunekstudiow kierunekstudiow, String nazwa,
			Set<Kierunkowyefektksztalcenia> kierunkowyefektksztalcenias, Set<Przedmiot> przedmiots) {
		this.kierunekstudiow = kierunekstudiow;
		this.nazwa = nazwa;
		this.kierunkowyefektksztalcenias = kierunkowyefektksztalcenias;
		this.przedmiots = przedmiots;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Kierunekstudiow getKierunekstudiow() {
		return this.kierunekstudiow;
	}

	public void setKierunekstudiow(Kierunekstudiow kierunekstudiow) {
		this.kierunekstudiow = kierunekstudiow;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Set<Kierunkowyefektksztalcenia> getKierunkowyefektksztalcenias() {
		return this.kierunkowyefektksztalcenias;
	}

	public void setKierunkowyefektksztalcenias(Set<Kierunkowyefektksztalcenia> kierunkowyefektksztalcenias) {
		this.kierunkowyefektksztalcenias = kierunkowyefektksztalcenias;
	}

	public Set<Przedmiot> getPrzedmiots() {
		return this.przedmiots;
	}

	public void setPrzedmiots(Set<Przedmiot> przedmiots) {
		this.przedmiots = przedmiots;
	}

}
