package pl.edu.pwr.krk.models.entities;

public class Peknarzedziedydaktyczne implements java.io.Serializable {

	private Integer id;
	private Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia;
	private Narzedziedydaktyczne narzedziedydaktyczne;

	public Peknarzedziedydaktyczne() {
	}

	public Peknarzedziedydaktyczne(Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia,
			Narzedziedydaktyczne narzedziedydaktyczne) {
		this.przedmiotowyefektksztalcenia = przedmiotowyefektksztalcenia;
		this.narzedziedydaktyczne = narzedziedydaktyczne;
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

	public Narzedziedydaktyczne getNarzedziedydaktyczne() {
		return this.narzedziedydaktyczne;
	}

	public void setNarzedziedydaktyczne(Narzedziedydaktyczne narzedziedydaktyczne) {
		this.narzedziedydaktyczne = narzedziedydaktyczne;
	}

}
