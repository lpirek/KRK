// default package
// Generated 2016-01-17 19:43:59 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Programstudiow generated by hbm2java
 */
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
