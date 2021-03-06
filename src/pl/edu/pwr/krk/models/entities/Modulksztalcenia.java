package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Modulksztalcenia implements java.io.Serializable {

	public static final String TYP_WYBIERALNY = "wybieralny";
	public static final String TYP_OBOWIAZKOWY = "obowiązkowy";
	
	private Integer id;
	private Programstudiow programstudiow;
	private Modulksztalcenia modulksztalcenia;
	private String typModulu;
	private String nazwa;
	private Set<Modulksztalcenia> modulksztalcenias = new HashSet<Modulksztalcenia>(0);
	private Set<Przedmiot> przedmiots = new HashSet<Przedmiot>(0);

	public Modulksztalcenia() {
	}

	public Modulksztalcenia(Programstudiow programstudiow, String typModulu, String nazwa) {
		this.programstudiow = programstudiow;
		this.typModulu = typModulu;
		this.nazwa = nazwa;
	}

	public Modulksztalcenia(Programstudiow programstudiow, Modulksztalcenia modulksztalcenia, String typModulu,
			String nazwa, Set<Modulksztalcenia> modulksztalcenias, Set<Przedmiot> przedmiots) {
		this.programstudiow = programstudiow;
		this.modulksztalcenia = modulksztalcenia;
		this.typModulu = typModulu;
		this.nazwa = nazwa;
		this.modulksztalcenias = modulksztalcenias;
		this.przedmiots = przedmiots;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Programstudiow getProgramstudiow() {
		return this.programstudiow;
	}

	public void setProgramstudiow(Programstudiow programstudiow) {
		this.programstudiow = programstudiow;
	}

	public Modulksztalcenia getModulksztalcenia() {
		return this.modulksztalcenia;
	}

	public void setModulksztalcenia(Modulksztalcenia modulksztalcenia) {
		this.modulksztalcenia = modulksztalcenia;
	}

	public String getTypModulu() {
		return this.typModulu;
	}

	public void setTypModulu(String typModulu) {
		this.typModulu = typModulu;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Set<Modulksztalcenia> getModulksztalcenias() {
		return this.modulksztalcenias;
	}

	public void setModulksztalcenias(Set<Modulksztalcenia> modulksztalcenias) {
		this.modulksztalcenias = modulksztalcenias;
	}

	public Set<Przedmiot> getPrzedmiots() {
		return this.przedmiots;
	}

	public void setPrzedmiots(Set<Przedmiot> przedmiots) {
		this.przedmiots = przedmiots;
	}

}
