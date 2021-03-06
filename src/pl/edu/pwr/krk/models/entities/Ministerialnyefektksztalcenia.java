package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Ministerialnyefektksztalcenia implements java.io.Serializable {

	private Integer id;
	private Obszarksztalcenia obszarksztalcenia;
	private String zakres;
	private String numer;
	private String opis;
	private Set<Mekkek> mekkeks = new HashSet<Mekkek>(0);

	public Ministerialnyefektksztalcenia() {
	}

	public Ministerialnyefektksztalcenia(Obszarksztalcenia obszarksztalcenia, String zakres, String numer,
			String opis) {
		this.obszarksztalcenia = obszarksztalcenia;
		this.zakres = zakres;
		this.numer = numer;
		this.opis = opis;
	}

	public Ministerialnyefektksztalcenia(Obszarksztalcenia obszarksztalcenia, String zakres, String numer, String opis,
			Set<Mekkek> mekkeks) {
		this.obszarksztalcenia = obszarksztalcenia;
		this.zakres = zakres;
		this.numer = numer;
		this.opis = opis;
		this.mekkeks = mekkeks;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Obszarksztalcenia getObszarksztalcenia() {
		return this.obszarksztalcenia;
	}

	public void setObszarksztalcenia(Obszarksztalcenia obszarksztalcenia) {
		this.obszarksztalcenia = obszarksztalcenia;
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

	public Set<Mekkek> getMekkeks() {
		return this.mekkeks;
	}

	public void setMekkeks(Set<Mekkek> mekkeks) {
		this.mekkeks = mekkeks;
	}

}
