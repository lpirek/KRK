package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Wydzial implements java.io.Serializable {

	private int id;
	private String nazwa;
	private Set<Kierunekstudiow> kierunekstudiows = new HashSet<Kierunekstudiow>(0);

	public Wydzial() {
	}

	public Wydzial(int id, String nazwa) {
		this.id = id;
		this.nazwa = nazwa;
	}

	public Wydzial(int id, String nazwa, Set<Kierunekstudiow> kierunekstudiows) {
		this.id = id;
		this.nazwa = nazwa;
		this.kierunekstudiows = kierunekstudiows;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Set<Kierunekstudiow> getKierunekstudiows() {
		return this.kierunekstudiows;
	}

	public void setKierunekstudiows(Set<Kierunekstudiow> kierunekstudiows) {
		this.kierunekstudiows = kierunekstudiows;
	}

}
