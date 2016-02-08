package pl.edu.pwr.krk.models.entities;

public class Wymaganiawstepne implements java.io.Serializable {

	private Integer id;
	private Kartaprzedmiotu kartaprzedmiotu;
	private short pozycja;
	private String wymaganie;

	public Wymaganiawstepne() {
	}

	public Wymaganiawstepne(Kartaprzedmiotu kartaprzedmiotu, short pozycja, String wymaganie) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.pozycja = pozycja;
		this.wymaganie = wymaganie;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Kartaprzedmiotu getKartaprzedmiotu() {
		return this.kartaprzedmiotu;
	}

	public void setKartaprzedmiotu(Kartaprzedmiotu kartaprzedmiotu) {
		this.kartaprzedmiotu = kartaprzedmiotu;
	}

	public short getPozycja() {
		return this.pozycja;
	}

	public void setPozycja(short pozycja) {
		this.pozycja = pozycja;
	}

	public String getWymaganie() {
		return this.wymaganie;
	}

	public void setWymaganie(String wymaganie) {
		this.wymaganie = wymaganie;
	}

}
