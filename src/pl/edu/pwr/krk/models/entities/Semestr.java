package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Semestr implements java.io.Serializable {

	private Integer id;
	private short numer;
	private Set<Kurs> kurses = new HashSet<Kurs>(0);
	private Set<Planstudiowsemestr> planstudiowsemestrs = new HashSet<Planstudiowsemestr>(0);

	public Semestr() {
	}

	public Semestr(short numer) {
		this.numer = numer;
	}

	public Semestr(short numer, Set<Kurs> kurses, Set<Planstudiowsemestr> planstudiowsemestrs) {
		this.numer = numer;
		this.kurses = kurses;
		this.planstudiowsemestrs = planstudiowsemestrs;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public short getNumer() {
		return this.numer;
	}

	public void setNumer(short numer) {
		this.numer = numer;
	}

	public Set<Kurs> getKurses() {
		return this.kurses;
	}

	public void setKurses(Set<Kurs> kurses) {
		this.kurses = kurses;
	}

	public Set<Planstudiowsemestr> getPlanstudiowsemestrs() {
		return this.planstudiowsemestrs;
	}

	public void setPlanstudiowsemestrs(Set<Planstudiowsemestr> planstudiowsemestrs) {
		this.planstudiowsemestrs = planstudiowsemestrs;
	}

}
