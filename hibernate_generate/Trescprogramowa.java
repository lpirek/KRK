// default package
// Generated 2016-01-17 19:43:59 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Trescprogramowa generated by hbm2java
 */
public class Trescprogramowa implements java.io.Serializable {

	private Integer id;
	private Kartaprzedmiotu kartaprzedmiotu;
	private Short trescOd;
	private Short trescDo;
	private String opis;
	private Short liczbaGodzin;
	private Set<Przedmiotowyefektksztalcenia> przedmiotowyefektksztalcenias = new HashSet<Przedmiotowyefektksztalcenia>(
			0);

	public Trescprogramowa() {
	}

	public Trescprogramowa(Kartaprzedmiotu kartaprzedmiotu) {
		this.kartaprzedmiotu = kartaprzedmiotu;
	}

	public Trescprogramowa(Kartaprzedmiotu kartaprzedmiotu, Short trescOd, Short trescDo, String opis,
			Short liczbaGodzin, Set<Przedmiotowyefektksztalcenia> przedmiotowyefektksztalcenias) {
		this.kartaprzedmiotu = kartaprzedmiotu;
		this.trescOd = trescOd;
		this.trescDo = trescDo;
		this.opis = opis;
		this.liczbaGodzin = liczbaGodzin;
		this.przedmiotowyefektksztalcenias = przedmiotowyefektksztalcenias;
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

	public Short getTrescOd() {
		return this.trescOd;
	}

	public void setTrescOd(Short trescOd) {
		this.trescOd = trescOd;
	}

	public Short getTrescDo() {
		return this.trescDo;
	}

	public void setTrescDo(Short trescDo) {
		this.trescDo = trescDo;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Short getLiczbaGodzin() {
		return this.liczbaGodzin;
	}

	public void setLiczbaGodzin(Short liczbaGodzin) {
		this.liczbaGodzin = liczbaGodzin;
	}

	public Set<Przedmiotowyefektksztalcenia> getPrzedmiotowyefektksztalcenias() {
		return this.przedmiotowyefektksztalcenias;
	}

	public void setPrzedmiotowyefektksztalcenias(Set<Przedmiotowyefektksztalcenia> przedmiotowyefektksztalcenias) {
		this.przedmiotowyefektksztalcenias = przedmiotowyefektksztalcenias;
	}

}
