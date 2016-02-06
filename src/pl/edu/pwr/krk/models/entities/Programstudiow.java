package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Programstudiow implements java.io.Serializable {

	private Integer id;
	private Programksztalcenia programksztalcenia;
	private Set<Modulksztalcenia> modulksztalcenias = new HashSet<Modulksztalcenia>(0);

	public Programstudiow() {
	}

	public Programstudiow(Programksztalcenia programksztalcenia, Set<Modulksztalcenia> modulksztalcenias) {
		this.programksztalcenia = programksztalcenia;
		this.modulksztalcenias = modulksztalcenias;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Modulksztalcenia> getModulksztalcenias() {
		return this.modulksztalcenias;
	}

	public void setModulksztalcenias(Set<Modulksztalcenia> modulksztalcenias) {
		this.modulksztalcenias = modulksztalcenias;
	}

	public Programksztalcenia getProgramksztalcenia() {
		return programksztalcenia;
	}

	public void setProgramksztalcenia(Programksztalcenia programksztalcenia) {
		this.programksztalcenia = programksztalcenia;
	}

}
