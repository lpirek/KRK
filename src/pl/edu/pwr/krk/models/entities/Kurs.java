package pl.edu.pwr.krk.models.entities;

import java.util.HashSet;
import java.util.Set;

public class Kurs implements java.io.Serializable {

	public static final String FORMA_WYKLAD = "wykład";
	public static final String FORMA_LABORATORIUM = "laboratorium";
	public static final String FORMA_PROJEKT = "projekt";
	public static final String FORMA_SEMINARIUM = "seminarium";
	public static final String FORMA_CWICZENIA = "ćwiczenia";
	
	public static final String ZALICZENIE_EGZAMIN = "egzamin";
	public static final String ZALICZENIE_NA_OCENE = "zaliczenie na ocenę";
	
	private Integer id;
	private Grupakursow grupakursow;
	private Semestr semestr;
	private Przedmiot przedmiot;
	private String formaZajec;
	private short ects;
	private short zzu;
	private short cnps;
	private String formaZaliczenia;
	private double punktyP;
	private double punktyBk;
	private String kod;
	private short liczbaZajec;
	private Set<Narzedziedydaktyczne> narzedziedydaktycznes = new HashSet<Narzedziedydaktyczne>(0);

	public Kurs() {
	}

	public Kurs(Semestr semestr, Przedmiot przedmiot, String formaZajec, short ects, short zzu, short cnps,
			String formaZaliczenia, double punktyP, double punktyBk, String kod, short liczbaZajec) {
		this.semestr = semestr;
		this.przedmiot = przedmiot;
		this.formaZajec = formaZajec;
		this.ects = ects;
		this.zzu = zzu;
		this.cnps = cnps;
		this.formaZaliczenia = formaZaliczenia;
		this.punktyP = punktyP;
		this.punktyBk = punktyBk;
		this.kod = kod;
		this.liczbaZajec = liczbaZajec;
	}

	public Kurs(Grupakursow grupakursow, Semestr semestr, Przedmiot przedmiot, String formaZajec, short ects, short zzu,
			short cnps, String formaZaliczenia, double punktyP, double punktyBk, String kod, short liczbaZajec,
			Set<Narzedziedydaktyczne> narzedziedydaktycznes) {
		this.grupakursow = grupakursow;
		this.semestr = semestr;
		this.przedmiot = przedmiot;
		this.formaZajec = formaZajec;
		this.ects = ects;
		this.zzu = zzu;
		this.cnps = cnps;
		this.formaZaliczenia = formaZaliczenia;
		this.punktyP = punktyP;
		this.punktyBk = punktyBk;
		this.kod = kod;
		this.liczbaZajec = liczbaZajec;
		this.narzedziedydaktycznes = narzedziedydaktycznes;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Grupakursow getGrupakursow() {
		return this.grupakursow;
	}

	public void setGrupakursow(Grupakursow grupakursow) {
		this.grupakursow = grupakursow;
	}

	public Semestr getSemestr() {
		return this.semestr;
	}

	public void setSemestr(Semestr semestr) {
		this.semestr = semestr;
	}

	public Przedmiot getPrzedmiot() {
		return this.przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}

	public String getFormaZajec() {
		return this.formaZajec;
	}

	public void setFormaZajec(String formaZajec) {
		this.formaZajec = formaZajec;
	}

	public short getEcts() {
		return this.ects;
	}

	public void setEcts(short ects) {
		this.ects = ects;
	}

	public short getZzu() {
		return this.zzu;
	}

	public void setZzu(short zzu) {
		this.zzu = zzu;
	}

	public short getCnps() {
		return this.cnps;
	}

	public void setCnps(short cnps) {
		this.cnps = cnps;
	}

	public String getFormaZaliczenia() {
		return this.formaZaliczenia;
	}

	public void setFormaZaliczenia(String formaZaliczenia) {
		this.formaZaliczenia = formaZaliczenia;
	}

	public double getPunktyP() {
		return this.punktyP;
	}

	public void setPunktyP(double punktyP) {
		this.punktyP = punktyP;
	}

	public double getPunktyBk() {
		return this.punktyBk;
	}

	public void setPunktyBk(double punktyBk) {
		this.punktyBk = punktyBk;
	}

	public String getKod() {
		return this.kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public short getLiczbaZajec() {
		return this.liczbaZajec;
	}

	public void setLiczbaZajec(short liczbaZajec) {
		this.liczbaZajec = liczbaZajec;
	}

	public Set<Narzedziedydaktyczne> getNarzedziedydaktycznes() {
		return this.narzedziedydaktycznes;
	}

	public void setNarzedziedydaktycznes(Set<Narzedziedydaktyczne> narzedziedydaktycznes) {
		this.narzedziedydaktycznes = narzedziedydaktycznes;
	}

}
