package pl.edu.pwr.krk.models.entities;

public class Mekkek implements java.io.Serializable {

	private Integer id;
	private Kierunkowyefektksztalcenia kierunkowyefektksztalcenia;
	private Ministerialnyefektksztalcenia ministerialnyefektksztalcenia;

	public Mekkek() {
	}

	public Mekkek(Kierunkowyefektksztalcenia kierunkowyefektksztalcenia,
			Ministerialnyefektksztalcenia ministerialnyefektksztalcenia) {
		this.kierunkowyefektksztalcenia = kierunkowyefektksztalcenia;
		this.ministerialnyefektksztalcenia = ministerialnyefektksztalcenia;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Kierunkowyefektksztalcenia getKierunkowyefektksztalcenia() {
		return this.kierunkowyefektksztalcenia;
	}

	public void setKierunkowyefektksztalcenia(Kierunkowyefektksztalcenia kierunkowyefektksztalcenia) {
		this.kierunkowyefektksztalcenia = kierunkowyefektksztalcenia;
	}

	public Ministerialnyefektksztalcenia getMinisterialnyefektksztalcenia() {
		return this.ministerialnyefektksztalcenia;
	}

	public void setMinisterialnyefektksztalcenia(Ministerialnyefektksztalcenia ministerialnyefektksztalcenia) {
		this.ministerialnyefektksztalcenia = ministerialnyefektksztalcenia;
	}

}
