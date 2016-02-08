package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Przedmiotowyefektksztalcenia implements java.io.Serializable  {

	private Integer id;
	private Kartaprzedmiotu kartaprzedmiotu;
	private String zakres;
	private String numer;
	private String opis;
	private Set<Kekpek> kekpeks = new HashSet<Kekpek>(0);
	private Set<Peknarzedziedydaktyczne> peknarzedziedydaktycznes = new HashSet<Peknarzedziedydaktyczne>(0);
	private Set<Pekcelprzedmiotu> pekcelprzedmiotus = new HashSet<Pekcelprzedmiotu>(0);
	private Set<Pekocenaosiagnieciapek> pekocenaosiagnieciapeks = new HashSet<Pekocenaosiagnieciapek>(0);
	private Set<Pektrescprogramowa> pektrescprogramowas = new HashSet<Pektrescprogramowa>(0);

	public Przedmiotowyefektksztalcenia() {
	}

	public Przedmiotowyefektksztalcenia(Kartaprzedmiotu kartaprzedmiotu, String zakres, String numer, String opis) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.zakres = zakres;
		this.numer = numer;
		this.opis = opis;
	}

	public Przedmiotowyefektksztalcenia(Kartaprzedmiotu kartaprzedmiotu, String zakres, String numer, String opis,
			Set<Kekpek> kekpeks, Set<Peknarzedziedydaktyczne> peknarzedziedydaktycznes,
			Set<Pekcelprzedmiotu> pekcelprzedmiotus, Set<Pekocenaosiagnieciapek> pekocenaosiagnieciapeks,
			Set<Pektrescprogramowa> pektrescprogramowas) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.zakres = zakres;
		this.numer = numer;
		this.opis = opis;
		this.kekpeks = kekpeks;
		this.peknarzedziedydaktycznes = peknarzedziedydaktycznes;
		this.pekcelprzedmiotus = pekcelprzedmiotus;
		this.pekocenaosiagnieciapeks = pekocenaosiagnieciapeks;
		this.pektrescprogramowas = pektrescprogramowas;
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

	public String getZakres() {
		return this.zakres;
	}

	public void setZakres(String zakres) {
		this.zakres = zakres;
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

	public Set<Kekpek> getKekpeks() {
		return this.kekpeks;
	}

	public void setKekpeks(Set<Kekpek> kekpeks) {
		this.kekpeks = kekpeks;
	}

	public Set<Peknarzedziedydaktyczne> getPeknarzedziedydaktycznes() {
		return this.peknarzedziedydaktycznes;
	}

	public void setPeknarzedziedydaktycznes(Set<Peknarzedziedydaktyczne> peknarzedziedydaktycznes) {
		this.peknarzedziedydaktycznes = peknarzedziedydaktycznes;
	}

	public Set<Pekcelprzedmiotu> getPekcelprzedmiotus() {
		return this.pekcelprzedmiotus;
	}

	public void setPekcelprzedmiotus(Set<Pekcelprzedmiotu> pekcelprzedmiotus) {
		this.pekcelprzedmiotus = pekcelprzedmiotus;
	}

	public Set<Pekocenaosiagnieciapek> getPekocenaosiagnieciapeks() {
		return this.pekocenaosiagnieciapeks;
	}

	public void setPekocenaosiagnieciapeks(Set<Pekocenaosiagnieciapek> pekocenaosiagnieciapeks) {
		this.pekocenaosiagnieciapeks = pekocenaosiagnieciapeks;
	}

	public Set<Pektrescprogramowa> getPektrescprogramowas() {
		return this.pektrescprogramowas;
	}

	public void setPektrescprogramowas(Set<Pektrescprogramowa> pektrescprogramowas) {
		this.pektrescprogramowas = pektrescprogramowas;
	}

}
