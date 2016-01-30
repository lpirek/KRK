package pl.edu.pwr.krk.models.entities;

public class Kekpek implements java.io.Serializable {

	private Integer id;
	private Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia;
	private Kierunkowyefektksztalcenia kierunkowyefektksztalcenia;

	public Kekpek() {
	}

	public Kekpek(Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia,
			Kierunkowyefektksztalcenia kierunkowyefektksztalcenia) {
		this.przedmiotowyefektksztalcenia = przedmiotowyefektksztalcenia;
		this.kierunkowyefektksztalcenia = kierunkowyefektksztalcenia;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Przedmiotowyefektksztalcenia getPrzedmiotowyefektksztalcenia() {
		return this.przedmiotowyefektksztalcenia;
	}

	public void setPrzedmiotowyefektksztalcenia(Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia) {
		this.przedmiotowyefektksztalcenia = przedmiotowyefektksztalcenia;
	}

	public Kierunkowyefektksztalcenia getKierunkowyefektksztalcenia() {
		return this.kierunkowyefektksztalcenia;
	}

	public void setKierunkowyefektksztalcenia(Kierunkowyefektksztalcenia kierunkowyefektksztalcenia) {
		this.kierunkowyefektksztalcenia = kierunkowyefektksztalcenia;
	}

}
