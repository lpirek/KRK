package pl.edu.pwr.krk.models.entities;

public class Pozycjaliteraturowa implements java.io.Serializable {

	private Integer id;
	private Kartaprzedmiotu kartaprzedmiotu;
	private short pozycja;
	private String opis;
	private String rodzaj;

	public Pozycjaliteraturowa() {
	}

	public Pozycjaliteraturowa(Kartaprzedmiotu kartaprzedmiotu, short pozycja, String opis, String rodzaj) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.pozycja = pozycja;
		this.opis = opis;
		this.rodzaj = rodzaj;
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

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getRodzaj() {
		return this.rodzaj;
	}

	public void setRodzaj(String rodzaj) {
		this.rodzaj = rodzaj;
	}

}
