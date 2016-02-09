package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Narzedziedydaktyczne implements java.io.Serializable {

	private Integer id;
	private Kartaprzedmiotu kartaprzedmiotu;
	private String numer;
	private String opis;
	private Set<Peknarzedziedydaktyczne> peknarzedziedydaktycznes = new HashSet<Peknarzedziedydaktyczne>(0);

	public Narzedziedydaktyczne() {
	}

	public Narzedziedydaktyczne(Kartaprzedmiotu kartaprzedmiotu, String numer, String opis) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.numer = numer;
		this.opis = opis;
	}

	public Narzedziedydaktyczne(Kartaprzedmiotu kartaprzedmiotu, String numer, String opis,
			Set<Peknarzedziedydaktyczne> peknarzedziedydaktycznes) {
		this.kartaprzedmiotu = kartaprzedmiotu;
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
