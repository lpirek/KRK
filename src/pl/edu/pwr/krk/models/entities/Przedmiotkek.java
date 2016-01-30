package pl.edu.pwr.krk.models.entities;

public class Przedmiotkek implements java.io.Serializable {

	private Integer id;
	private Kierunkowyefektksztalcenia kierunkowyefektksztalcenia;
	private Przedmiot przedmiot;

	public Przedmiotkek() {
	}

	public Przedmiotkek(Kierunkowyefektksztalcenia kierunkowyefektksztalcenia, Przedmiot przedmiot) {
		this.kierunkowyefektksztalcenia = kierunkowyefektksztalcenia;
		this.przedmiot = przedmiot;
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

	public Przedmiot getPrzedmiot() {
		return this.przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}

}
