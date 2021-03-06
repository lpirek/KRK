package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Obszarksztalcenia implements java.io.Serializable {

	private Integer id;
	private Set<Programksztalceniaobszarksztalcenia> programksztalceniaobszarksztalcenias = new HashSet<Programksztalceniaobszarksztalcenia>(
			0);
	private Set<Ministerialnyefektksztalcenia> ministerialnyefektksztalcenias = new HashSet<Ministerialnyefektksztalcenia>(
			0);

	public Obszarksztalcenia() {
	}

	public Obszarksztalcenia(Set<Programksztalceniaobszarksztalcenia> programksztalceniaobszarksztalcenias,
			Set<Ministerialnyefektksztalcenia> ministerialnyefektksztalcenias) {
		this.programksztalceniaobszarksztalcenias = programksztalceniaobszarksztalcenias;
		this.ministerialnyefektksztalcenias = ministerialnyefektksztalcenias;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Programksztalceniaobszarksztalcenia> getProgramksztalceniaobszarksztalcenias() {
		return this.programksztalceniaobszarksztalcenias;
	}

	public void setProgramksztalceniaobszarksztalcenias(
			Set<Programksztalceniaobszarksztalcenia> programksztalceniaobszarksztalcenias) {
		this.programksztalceniaobszarksztalcenias = programksztalceniaobszarksztalcenias;
	}

	public Set<Ministerialnyefektksztalcenia> getMinisterialnyefektksztalcenias() {
		return this.ministerialnyefektksztalcenias;
	}

	public void setMinisterialnyefektksztalcenias(Set<Ministerialnyefektksztalcenia> ministerialnyefektksztalcenias) {
		this.ministerialnyefektksztalcenias = ministerialnyefektksztalcenias;
	}

}
