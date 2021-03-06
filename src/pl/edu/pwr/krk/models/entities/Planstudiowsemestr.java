package pl.edu.pwr.krk.models.entities;

public class Planstudiowsemestr implements java.io.Serializable {

	private Integer id;
	private Planstudiow planstudiow;
	private Semestr semestr;

	public Planstudiowsemestr() {
	}

	public Planstudiowsemestr(Planstudiow planstudiow, Semestr semestr) {
		this.planstudiow = planstudiow;
		this.semestr = semestr;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Planstudiow getPlanstudiow() {
		return this.planstudiow;
	}

	public void setPlanstudiow(Planstudiow planstudiow) {
		this.planstudiow = planstudiow;
	}

	public Semestr getSemestr() {
		return this.semestr;
	}

	public void setSemestr(Semestr semestr) {
		this.semestr = semestr;
	}

}
