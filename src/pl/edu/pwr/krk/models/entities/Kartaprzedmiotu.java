package pl.edu.pwr.krk.models.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Kartaprzedmiotu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String JEZYK_PL = "PL";
	public static final String JEZYK_EN = "EN";
	
	public static final String STATUS_ZATWIERDZONY = "wersja zatwierdzona";
	public static final String STATUS_ROBOCZY = "wersja robocza";
	
	private int id;
	private Przedmiot przedmiot;
	private String jezyk;
	private String nazwa;
	private short wersja;
	private Date dataUtworzenia;
	private String status;
	private String kierunekStudiow;
	private String stopienStudiow;
	private String formaStudiow;
	private Set<Celprzedmiotu> celprzedmiotus = new HashSet<Celprzedmiotu>(0);
	private Set<Wymaganiawstepne> wymaganiawstepnes = new HashSet<Wymaganiawstepne>(0);
	private Set<Ocenaosiagieciapek> ocenaosiagieciapeks = new HashSet<Ocenaosiagieciapek>(0);
	private Set<Pozycjaliteraturowa> pozycjaliteraturowas = new HashSet<Pozycjaliteraturowa>(0);
	private Set<Narzedziedydaktyczne> narzedziedydaktycznes = new HashSet<Narzedziedydaktyczne>(0);
	private Set<Przedmiotowyefektksztalcenia> przedmiotowyefektksztalcenias = new HashSet<Przedmiotowyefektksztalcenia>(0);
	private Set<Trescprogramowa> trescprogramowas = new HashSet<Trescprogramowa>(0);

	public Kartaprzedmiotu() {
	}

	public Kartaprzedmiotu(int id, Przedmiot przedmiot, String jezyk, String nazwa, short wersja, Date dataUtworzenia,
			String status, String kierunekStudiow, String stopienStudiow, String formaStudiow) {
		this.id = id;
		this.przedmiot = przedmiot;
		this.jezyk = jezyk;
		this.nazwa = nazwa;
		this.wersja = wersja;
		this.dataUtworzenia = dataUtworzenia;
		this.status = status;
		this.kierunekStudiow = kierunekStudiow;
		this.stopienStudiow = stopienStudiow;
		this.formaStudiow = formaStudiow;
	}

	public Kartaprzedmiotu(int id, Przedmiot przedmiot, String jezyk, String nazwa, short wersja, Date dataUtworzenia,
			String status, String kierunekStudiow, String stopienStudiow, String formaStudiow,
			Set<Celprzedmiotu> celprzedmiotus, Set<Wymaganiawstepne> wymaganiawstepnes,
			Set<Ocenaosiagieciapek> ocenaosiagieciapeks, Set<Pozycjaliteraturowa> pozycjaliteraturowas,
			Set<Narzedziedydaktyczne> narzedziedydaktycznes,
			Set<Przedmiotowyefektksztalcenia> przedmiotowyefektksztalcenias, Set<Trescprogramowa> trescprogramowas) {
		this.id = id;
		this.przedmiot = przedmiot;
		this.jezyk = jezyk;
		this.nazwa = nazwa;
		this.wersja = wersja;
		this.dataUtworzenia = dataUtworzenia;
		this.status = status;
		this.kierunekStudiow = kierunekStudiow;
		this.stopienStudiow = stopienStudiow;
		this.formaStudiow = formaStudiow;
		this.celprzedmiotus = celprzedmiotus;
		this.wymaganiawstepnes = wymaganiawstepnes;
		this.ocenaosiagieciapeks = ocenaosiagieciapeks;
		this.pozycjaliteraturowas = pozycjaliteraturowas;
		this.narzedziedydaktycznes = narzedziedydaktycznes;
		this.przedmiotowyefektksztalcenias = przedmiotowyefektksztalcenias;
		this.trescprogramowas = trescprogramowas;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Przedmiot getPrzedmiot() {
		return this.przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}

	public String getJezyk() {
		return this.jezyk;
	}

	public void setJezyk(String jezyk) {
		this.jezyk = jezyk;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public short getWersja() {
		return this.wersja;
	}

	public void setWersja(short wersja) {
		this.wersja = wersja;
	}

	public Date getDataUtworzenia() {
		return this.dataUtworzenia;
	}

	public void setDataUtworzenia(Date dataUtworzenia) {
		this.dataUtworzenia = dataUtworzenia;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKierunekStudiow() {
		return this.kierunekStudiow;
	}

	public void setKierunekStudiow(String kierunekStudiow) {
		this.kierunekStudiow = kierunekStudiow;
	}

	public String getStopienStudiow() {
		return this.stopienStudiow;
	}

	public void setStopienStudiow(String stopienStudiow) {
		this.stopienStudiow = stopienStudiow;
	}

	public String getFormaStudiow() {
		return this.formaStudiow;
	}

	public void setFormaStudiow(String formaStudiow) {
		this.formaStudiow = formaStudiow;
	}

	public Set<Celprzedmiotu> getCelprzedmiotus() {
		return this.celprzedmiotus;
	}

	public void setCelprzedmiotus(Set<Celprzedmiotu> celprzedmiotus) {
		this.celprzedmiotus = celprzedmiotus;
	}

	public Set<Wymaganiawstepne> getWymaganiawstepnes() {
		return this.wymaganiawstepnes;
	}

	public void setWymaganiawstepnes(Set<Wymaganiawstepne> wymaganiawstepnes) {
		this.wymaganiawstepnes = wymaganiawstepnes;
	}

	public Set<Ocenaosiagieciapek> getOcenaosiagieciapeks() {
		return this.ocenaosiagieciapeks;
	}

	public void setOcenaosiagieciapeks(Set<Ocenaosiagieciapek> ocenaosiagieciapeks) {
		this.ocenaosiagieciapeks = ocenaosiagieciapeks;
	}

	public Set<Pozycjaliteraturowa> getPozycjaliteraturowas() {
		return this.pozycjaliteraturowas;
	}

	public void setPozycjaliteraturowas(Set<Pozycjaliteraturowa> pozycjaliteraturowas) {
		this.pozycjaliteraturowas = pozycjaliteraturowas;
	}

	public Set<Narzedziedydaktyczne> getNarzedziedydaktycznes() {
		return this.narzedziedydaktycznes;
	}

	public void setNarzedziedydaktycznes(Set<Narzedziedydaktyczne> narzedziedydaktycznes) {
		this.narzedziedydaktycznes = narzedziedydaktycznes;
	}

	public Set<Przedmiotowyefektksztalcenia> getPrzedmiotowyefektksztalcenias() {
		return this.przedmiotowyefektksztalcenias;
	}

	public void setPrzedmiotowyefektksztalcenias(Set<Przedmiotowyefektksztalcenia> przedmiotowyefektksztalcenias) {
		this.przedmiotowyefektksztalcenias = przedmiotowyefektksztalcenias;
	}

	public Set<Trescprogramowa> getTrescprogramowas() {
		return this.trescprogramowas;
	}

	public void setTrescprogramowas(Set<Trescprogramowa> trescprogramowas) {
		this.trescprogramowas = trescprogramowas;
	}
	
	public boolean isAccepted() {
		return this.status.equals(STATUS_ZATWIERDZONY);
	}

}
