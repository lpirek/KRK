package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Grupakursow implements java.io.Serializable {

	private Integer id;
	private Przedmiot przedmiot;
	private String kod;
	private Set<Kurs> kurses = new HashSet<Kurs>(0);

	public Grupakursow() {
	}

	public Grupakursow(Przedmiot przedmiot, String kod) {
		this.przedmiot = przedmiot;
		this.kod = kod;
	}

	public Grupakursow(Przedmiot przedmiot, String kod, Set<Kurs> kurses) {
		this.przedmiot = przedmiot;
		this.kod = kod;
		this.kurses = kurses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Przedmiot getPrzedmiot() {
		return this.przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}

	public String getKod() {
		return this.kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public Set<Kurs> getKurses() {
		return this.kurses;
	}

	public void setKurses(Set<Kurs> kurses) {
		this.kurses = kurses;
	}

}
