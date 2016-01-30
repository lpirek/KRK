package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Trescprogramowa implements java.io.Serializable {

	private Integer id;
	private Kartaprzedmiotu kartaprzedmiotu;
	private short trescOd;
	private short trescDo;
	private String opis;
	private short liczbaGodzin;
	private Set<Pektrescprogramowa> pektrescprogramowas = new HashSet<Pektrescprogramowa>(0);

	public Trescprogramowa() {
	}

	public Trescprogramowa(Kartaprzedmiotu kartaprzedmiotu, short trescOd, short trescDo, String opis,
			short liczbaGodzin) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.trescOd = trescOd;
		this.trescDo = trescDo;
		this.opis = opis;
		this.liczbaGodzin = liczbaGodzin;
	}

	public Trescprogramowa(Kartaprzedmiotu kartaprzedmiotu, short trescOd, short trescDo, String opis,
			short liczbaGodzin, Set<Pektrescprogramowa> pektrescprogramowas) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.trescOd = trescOd;
		this.trescDo = trescDo;
		this.opis = opis;
		this.liczbaGodzin = liczbaGodzin;
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

	public short getTrescOd() {
		return this.trescOd;
	}

	public void setTrescOd(short trescOd) {
		this.trescOd = trescOd;
	}

	public short getTrescDo() {
		return this.trescDo;
	}

	public void setTrescDo(short trescDo) {
		this.trescDo = trescDo;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public short getLiczbaGodzin() {
		return this.liczbaGodzin;
	}

	public void setLiczbaGodzin(short liczbaGodzin) {
		this.liczbaGodzin = liczbaGodzin;
	}

	public Set<Pektrescprogramowa> getPektrescprogramowas() {
		return this.pektrescprogramowas;
	}

	public void setPektrescprogramowas(Set<Pektrescprogramowa> pektrescprogramowas) {
		this.pektrescprogramowas = pektrescprogramowas;
	}

}
