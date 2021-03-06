package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Celprzedmiotu implements java.io.Serializable {

	private int id;
	private Kartaprzedmiotu kartaprzedmiotu;
	private String numer;
	private String opis;
	private Set<Pekcelprzedmiotu> pekcelprzedmiotus = new HashSet<Pekcelprzedmiotu>(0);

	public Celprzedmiotu() {
	}

	public Celprzedmiotu(int id, Kartaprzedmiotu kartaprzedmiotu, String numer, String opis) {
		this.id = id;
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.numer = numer;
		this.opis = opis;
	}

	public Celprzedmiotu(int id, Kartaprzedmiotu kartaprzedmiotu, String numer, String opis,
			Set<Pekcelprzedmiotu> pekcelprzedmiotus) {
		this.id = id;
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.numer = numer;
		this.opis = opis;
		this.pekcelprzedmiotus = pekcelprzedmiotus;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kartaprzedmiotu getKartaprzedmiotu() {
		return this.kartaprzedmiotu;
	}

	public void setKartaprzedmiotu(Kartaprzedmiotu kartaprzedmiotu) {
		this.kartaprzedmiotu = kartaprzedmiotu;
	}

	public String getNumer() {
		return this.numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Set<Pekcelprzedmiotu> getPekcelprzedmiotus() {
		return this.pekcelprzedmiotus;
	}

	public void setPekcelprzedmiotus(Set<Pekcelprzedmiotu> pekcelprzedmiotus) {
		this.pekcelprzedmiotus = pekcelprzedmiotus;
	}

}
