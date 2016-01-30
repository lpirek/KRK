package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Programstudiow implements java.io.Serializable {

	private Integer id;
	private Set<Programksztalcenia> programksztalcenias = new HashSet<Programksztalcenia>(0);
	private Set<Modulksztalcenia> modulksztalcenias = new HashSet<Modulksztalcenia>(0);

	public Programstudiow() {
	}

	public Programstudiow(Set<Programksztalcenia> programksztalcenias, Set<Modulksztalcenia> modulksztalcenias) {
		this.programksztalcenias = programksztalcenias;
		this.modulksztalcenias = modulksztalcenias;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Programksztalcenia> getProgramksztalcenias() {
		return this.programksztalcenias;
	}

	public void setProgramksztalcenias(Set<Programksztalcenia> programksztalcenias) {
		this.programksztalcenias = programksztalcenias;
	}

	public Set<Modulksztalcenia> getModulksztalcenias() {
		return this.modulksztalcenias;
	}

	public void setModulksztalcenias(Set<Modulksztalcenia> modulksztalcenias) {
		this.modulksztalcenias = modulksztalcenias;
	}

}
