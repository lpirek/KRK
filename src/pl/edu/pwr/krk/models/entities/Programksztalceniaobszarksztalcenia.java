package pl.edu.pwr.krk.models.entities;

public class Programksztalceniaobszarksztalcenia implements java.io.Serializable {

	private Integer id;
	private Obszarksztalcenia obszarksztalcenia;
	private Programksztalcenia programksztalcenia;

	public Programksztalceniaobszarksztalcenia() {
	}

	public Programksztalceniaobszarksztalcenia(Obszarksztalcenia obszarksztalcenia,
			Programksztalcenia programksztalcenia) {
		this.obszarksztalcenia = obszarksztalcenia;
		this.programksztalcenia = programksztalcenia;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Obszarksztalcenia getObszarksztalcenia() {
		return this.obszarksztalcenia;
	}

	public void setObszarksztalcenia(Obszarksztalcenia obszarksztalcenia) {
		this.obszarksztalcenia = obszarksztalcenia;
	}

	public Programksztalcenia getProgramksztalcenia() {
		return this.programksztalcenia;
	}

	public void setProgramksztalcenia(Programksztalcenia programksztalcenia) {
		this.programksztalcenia = programksztalcenia;
	}

}
