package pl.edu.pwr.krk.models.entities;

import java.util.Date;

public class Raportsyntetyczny implements java.io.Serializable {

	private Integer id;
	private Uzytkownik uzytkownik;
	private Przedmiot przedmiot;
	private Date data;

	public Raportsyntetyczny() {
	}

	public Raportsyntetyczny(Uzytkownik uzytkownik, Przedmiot przedmiot, Date data) {
		this.uzytkownik = uzytkownik;
		this.przedmiot = przedmiot;
		this.data = data;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Uzytkownik getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	public Przedmiot getPrzedmiot() {
		return this.przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
