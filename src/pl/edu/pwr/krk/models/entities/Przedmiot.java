package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Przedmiot implements java.io.Serializable {

	public static final String RODZAJ_OBOWIAZKOWY = "obowiązkowy";
	public static final String RODZAJ_WYBIERALNY = "wybieralny";
	public static final String RODZAJ_OGOLNOUCZELNIANY = "ogólnouczelniany";
	
	private int id;
	private Specjalizacja specjalizacja;
	private Uzytkownik uzytkownik;
	private Modulksztalcenia modulksztalcenia;
	private String rodzaj;
	private String nazwaPl;
	private String nazwaEn;
	private String kod;
	private Set<Przedmiotkek> przedmiotkeks = new HashSet<Przedmiotkek>(0);
	private Set<Grupakursow> grupakursows = new HashSet<Grupakursow>(0);
	private Set<Raportsyntetyczny> raportsyntetycznies = new HashSet<Raportsyntetyczny>(0);
	private Set<Kartaprzedmiotu> kartaprzedmiotus = new HashSet<Kartaprzedmiotu>(0);
	private Set<Kurs> kurses = new HashSet<Kurs>(0);

	public Przedmiot() {
	}

	public Przedmiot(int id, Uzytkownik uzytkownik, Modulksztalcenia modulksztalcenia, String rodzaj, String nazwaPl,
			String nazwaEn, String kod) {
		this.id = id;
		this.uzytkownik = uzytkownik;
		this.modulksztalcenia = modulksztalcenia;
		this.rodzaj = rodzaj;
		this.nazwaPl = nazwaPl;
		this.nazwaEn = nazwaEn;
		this.kod = kod;
	}

	public Przedmiot(int id, Specjalizacja specjalizacja, Uzytkownik uzytkownik, Modulksztalcenia modulksztalcenia,
			String rodzaj, String nazwaPl, String nazwaEn, String kod, Set<Przedmiotkek> przedmiotkeks,
			Set<Grupakursow> grupakursows, Set<Raportsyntetyczny> raportsyntetycznies,
			Set<Kartaprzedmiotu> kartaprzedmiotus, Set<Kurs> kurses) {
		this.id = id;
		this.specjalizacja = specjalizacja;
		this.uzytkownik = uzytkownik;
		this.modulksztalcenia = modulksztalcenia;
		this.rodzaj = rodzaj;
		this.nazwaPl = nazwaPl;
		this.nazwaEn = nazwaEn;
		this.kod = kod;
		this.przedmiotkeks = przedmiotkeks;
		this.grupakursows = grupakursows;
		this.raportsyntetycznies = raportsyntetycznies;
		this.kartaprzedmiotus = kartaprzedmiotus;
		this.kurses = kurses;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Specjalizacja getSpecjalizacja() {
		return this.specjalizacja;
	}

	public void setSpecjalizacja(Specjalizacja specjalizacja) {
		this.specjalizacja = specjalizacja;
	}

	public Uzytkownik getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	public Modulksztalcenia getModulksztalcenia() {
		return this.modulksztalcenia;
	}

	public void setModulksztalcenia(Modulksztalcenia modulksztalcenia) {
		this.modulksztalcenia = modulksztalcenia;
	}

	public String getRodzaj() {
		return this.rodzaj;
	}

	public void setRodzaj(String rodzaj) {
		this.rodzaj = rodzaj;
	}

	public String getNazwaPl() {
		return this.nazwaPl;
	}

	public void setNazwaPl(String nazwaPl) {
		this.nazwaPl = nazwaPl;
	}

	public String getNazwaEn() {
		return this.nazwaEn;
	}

	public void setNazwaEn(String nazwaEn) {
		this.nazwaEn = nazwaEn;
	}

	public String getKod() {
		return this.kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public Set<Przedmiotkek> getPrzedmiotkeks() {
		return this.przedmiotkeks;
	}

	public void setPrzedmiotkeks(Set<Przedmiotkek> przedmiotkeks) {
		this.przedmiotkeks = przedmiotkeks;
	}

	public Set<Grupakursow> getGrupakursows() {
		return this.grupakursows;
	}

	public void setGrupakursows(Set<Grupakursow> grupakursows) {
		this.grupakursows = grupakursows;
	}

	public Set<Raportsyntetyczny> getRaportsyntetycznies() {
		return this.raportsyntetycznies;
	}

	public void setRaportsyntetycznies(Set<Raportsyntetyczny> raportsyntetycznies) {
		this.raportsyntetycznies = raportsyntetycznies;
	}

	public Set<Kartaprzedmiotu> getKartaprzedmiotus() {
		return this.kartaprzedmiotus;
	}

	public void setKartaprzedmiotus(Set<Kartaprzedmiotu> kartaprzedmiotus) {
		this.kartaprzedmiotus = kartaprzedmiotus;
	}

	public Set<Kurs> getKurses() {
		return this.kurses;
	}

	public void setKurses(Set<Kurs> kurses) {
		this.kurses = kurses;
	}
	
	public boolean isGroup() {
		return grupakursows != null && !grupakursows.isEmpty();	
	}

	public Kurs getKurs(String formaPrzedmiotu) {
		for (Kurs kurs : kurses) {
			if (kurs.getFormaZajec().equals(formaPrzedmiotu)) {
				return kurs;
			}
		}
		
		return null;
	}
	
	public String getZZU(String formaPrzedmiotu) {
		Kurs kurs = getKurs(formaPrzedmiotu);
		return kurs != null ? String.valueOf(kurs.getZzu()) : "-";
	}
	
	public String getCNPS(String formaPrzedmiotu) {
		Kurs kurs = getKurs(formaPrzedmiotu);
		return kurs != null ? String.valueOf(kurs.getCnps()) : "-";
	}
	
	public String getECTS(String formaPrzedmiotu) {
		Kurs kurs = getKurs(formaPrzedmiotu);
		return kurs != null ? String.valueOf(kurs.getEcts()) : "-";
	}
	
	public String getCrediting(String formaPrzedmiotu) {
		Kurs kurs = getKurs(formaPrzedmiotu);
		return kurs != null ? kurs.getFormaZaliczenia() : "-";
	}
	
	public String getPointsP(String formaPrzedmiotu) {
		Kurs kurs = getKurs(formaPrzedmiotu);
		return kurs != null ? String.valueOf(kurs.getPunktyP()) : "-";
	}
	
	public String getPointsBK(String formaPrzedmiotu) {
		Kurs kurs = getKurs(formaPrzedmiotu);
		return kurs != null ? String.valueOf(kurs.getPunktyBk()) : "-";
	}
}
