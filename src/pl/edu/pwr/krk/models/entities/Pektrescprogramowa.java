package pl.edu.pwr.krk.models.entities;

public class Pektrescprogramowa implements java.io.Serializable {

	private Integer id;
	private Trescprogramowa trescprogramowa;
	private Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia;

	public Pektrescprogramowa() {
	}

	public Pektrescprogramowa(Trescprogramowa trescprogramowa,
			Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia) {
		this.trescprogramowa = trescprogramowa;
		this.przedmiotowyefektksztalcenia = przedmiotowyefektksztalcenia;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Trescprogramowa getTrescprogramowa() {
		return this.trescprogramowa;
	}

	public void setTrescprogramowa(Trescprogramowa trescprogramowa) {
		this.trescprogramowa = trescprogramowa;
	}

	public Przedmiotowyefektksztalcenia getPrzedmiotowyefektksztalcenia() {
		return this.przedmiotowyefektksztalcenia;
	}

	public void setPrzedmiotowyefektksztalcenia(Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia) {
		this.przedmiotowyefektksztalcenia = przedmiotowyefektksztalcenia;
	}

}
