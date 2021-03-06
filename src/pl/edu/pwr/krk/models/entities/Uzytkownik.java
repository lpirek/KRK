package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Uzytkownik implements java.io.Serializable {

	private Integer id;
	private String nazwisko;
	private String imie;
	private String login;
	private String haslo;
	private String email;
	private Set<Przedmiot> przedmiots = new HashSet<Przedmiot>(0);
	private Set<Raportsyntetyczny> raportsyntetycznies = new HashSet<Raportsyntetyczny>(0);

	public Uzytkownik() {
	}

	public Uzytkownik(String nazwisko, String imie, String login, String haslo, String email) {
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.login = login;
		this.haslo = haslo;
		this.email = email;
	}

	public Uzytkownik(String nazwisko, String imie, String login, String haslo, String email, Set<Przedmiot> przedmiots,
			Set<Raportsyntetyczny> raportsyntetycznies) {
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.login = login;
		this.haslo = haslo;
		this.email = email;
		this.przedmiots = przedmiots;
		this.raportsyntetycznies = raportsyntetycznies;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Przedmiot> getPrzedmiots() {
		return this.przedmiots;
	}

	public void setPrzedmiots(Set<Przedmiot> przedmiots) {
		this.przedmiots = przedmiots;
	}

	public Set<Raportsyntetyczny> getRaportsyntetycznies() {
		return this.raportsyntetycznies;
	}

	public void setRaportsyntetycznies(Set<Raportsyntetyczny> raportsyntetycznies) {
		this.raportsyntetycznies = raportsyntetycznies;
	}

}
