package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Narzedziedydaktyczne implements java.io.Serializable {

	private Integer id;
	private Kartaprzedmiotu kartaprzedmiotu;
	private Kurs kurs;
	private String numer;
	private String opis;
	private Set<Peknarzedziedydaktyczne> peknarzedziedydaktycznes = new HashSet<Peknarzedziedydaktyczne>(0);

	public Narzedziedydaktyczne() {
	}

	public Narzedziedydaktyczne(Kartaprzedmiotu kartaprzedmiotu, Kurs kurs, String numer, String opis) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.kurs = kurs;
		this.numer = numer;
		this.opis = opis;
	}

	public Narzedziedydaktyczne(Kartaprzedmiotu kartaprzedmiotu, Kurs kurs, String numer, String opis,
			Set<Peknarzedziedydaktyczne> peknarzedziedydaktycznes) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.kurs = kurs;
		this.numer = numer;
		this.opis = opis;
		this.peknarzedziedydaktycznes = peknarzedziedydaktycznes;
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

	public Kurs getKurs() {
		return this.kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
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

	public Set<Peknarzedziedydaktyczne> getPeknarzedziedydaktycznes() {
		return this.peknarzedziedydaktycznes;
	}

	public void setPeknarzedziedydaktycznes(Set<Peknarzedziedydaktyczne> peknarzedziedydaktycznes) {
		this.peknarzedziedydaktycznes = peknarzedziedydaktycznes;
	}

}