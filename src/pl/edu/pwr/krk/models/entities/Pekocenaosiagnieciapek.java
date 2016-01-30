package pl.edu.pwr.krk.models.entities;

public class Pekocenaosiagnieciapek implements java.io.Serializable {

	private Integer id;
	private Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia;
	private Ocenaosiagieciapek ocenaosiagieciapek;

	public Pekocenaosiagnieciapek() {
	}

	public Pekocenaosiagnieciapek(Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia,
			Ocenaosiagieciapek ocenaosiagieciapek) {
		this.przedmiotowyefektksztalcenia = przedmiotowyefektksztalcenia;
		this.ocenaosiagieciapek = ocenaosiagieciapek;
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

	public Ocenaosiagieciapek getOcenaosiagieciapek() {
		return this.ocenaosiagieciapek;
	}

	public void setOcenaosiagieciapek(Ocenaosiagieciapek ocenaosiagieciapek) {
		this.ocenaosiagieciapek = ocenaosiagieciapek;
	}

}
