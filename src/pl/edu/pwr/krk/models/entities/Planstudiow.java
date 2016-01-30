package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Planstudiow implements java.io.Serializable {

	private Integer id;
	private Programksztalcenia programksztalcenia;
	private Set<Planstudiowsemestr> planstudiowsemestrs = new HashSet<Planstudiowsemestr>(0);

	public Planstudiow() {
	}

	public Planstudiow(Programksztalcenia programksztalcenia) {
		this.programksztalcenia = programksztalcenia;
	}

	public Planstudiow(Programksztalcenia programksztalcenia, Set<Planstudiowsemestr> planstudiowsemestrs) {
		this.programksztalcenia = programksztalcenia;
		this.planstudiowsemestrs = planstudiowsemestrs;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Programksztalcenia getProgramksztalcenia() {
		return this.programksztalcenia;
	}

	public void setProgramksztalcenia(Programksztalcenia programksztalcenia) {
		this.programksztalcenia = programksztalcenia;
	}

	public Set<Planstudiowsemestr> getPlanstudiowsemestrs() {
		return this.planstudiowsemestrs;
	}

	public void setPlanstudiowsemestrs(Set<Planstudiowsemestr> planstudiowsemestrs) {
		this.planstudiowsemestrs = planstudiowsemestrs;
	}

}
