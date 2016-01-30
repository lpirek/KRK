package pl.edu.pwr.krk.models.entities;

public class Pekcelprzedmiotu implements java.io.Serializable {

	private Integer id;
	private Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia;
	private Celprzedmiotu celprzedmiotu;

	public Pekcelprzedmiotu() {
	}

	public Pekcelprzedmiotu(Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia, Celprzedmiotu celprzedmiotu) {
		this.przedmiotowyefektksztalcenia = przedmiotowyefektksztalcenia;
		this.celprzedmiotu = celprzedmiotu;
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

	public Celprzedmiotu getCelprzedmiotu() {
		return this.celprzedmiotu;
	}

	public void setCelprzedmiotu(Celprzedmiotu celprzedmiotu) {
		this.celprzedmiotu = celprzedmiotu;
	}

}
