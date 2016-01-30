package pl.edu.pwr.krk.models.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Programksztalcenia implements java.io.Serializable {

	private int id;
	private Programstudiow programstudiow;
	private Kierunekstudiow kierunekstudiow;
	private Date aktualnyOd;
	private String typStudiow;
	private String formaStudiow;
	private String stopienStuiow;
	private Set<Programksztalceniaobszarksztalcenia> programksztalceniaobszarksztalcenias = new HashSet<Programksztalceniaobszarksztalcenia>(
			0);
	private Set<Planstudiow> planstudiows = new HashSet<Planstudiow>(0);

	public Programksztalcenia() {
	}

	public Programksztalcenia(int id, Kierunekstudiow kierunekstudiow, Date aktualnyOd, String typStudiow,
			String formaStudiow, String stopienStuiow) {
		this.id = id;
		this.kierunekstudiow = kierunekstudiow;
		this.aktualnyOd = aktualnyOd;
		this.typStudiow = typStudiow;
		this.formaStudiow = formaStudiow;
		this.stopienStuiow = stopienStuiow;
	}

	public Programksztalcenia(int id, Programstudiow programstudiow, Kierunekstudiow kierunekstudiow, Date aktualnyOd,
			String typStudiow, String formaStudiow, String stopienStuiow,
			Set<Programksztalceniaobszarksztalcenia> programksztalceniaobszarksztalcenias,
			Set<Planstudiow> planstudiows) {
		this.id = id;
		this.programstudiow = programstudiow;
		this.kierunekstudiow = kierunekstudiow;
		this.aktualnyOd = aktualnyOd;
		this.typStudiow = typStudiow;
		this.formaStudiow = formaStudiow;
		this.stopienStuiow = stopienStuiow;
		this.programksztalceniaobszarksztalcenias = programksztalceniaobszarksztalcenias;
		this.planstudiows = planstudiows;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Programstudiow getProgramstudiow() {
		return this.programstudiow;
	}

	public void setProgramstudiow(Programstudiow programstudiow) {
		this.programstudiow = programstudiow;
	}

	public Kierunekstudiow getKierunekstudiow() {
		return this.kierunekstudiow;
	}

	public void setKierunekstudiow(Kierunekstudiow kierunekstudiow) {
		this.kierunekstudiow = kierunekstudiow;
	}

	public Date getAktualnyOd() {
		return this.aktualnyOd;
	}

	public void setAktualnyOd(Date aktualnyOd) {
		this.aktualnyOd = aktualnyOd;
	}

	public String getTypStudiow() {
		return this.typStudiow;
	}

	public void setTypStudiow(String typStudiow) {
		this.typStudiow = typStudiow;
	}

	public String getFormaStudiow() {
		return this.formaStudiow;
	}

	public void setFormaStudiow(String formaStudiow) {
		this.formaStudiow = formaStudiow;
	}

	public String getStopienStuiow() {
		return this.stopienStuiow;
	}

	public void setStopienStuiow(String stopienStuiow) {
		this.stopienStuiow = stopienStuiow;
	}

	public Set<Programksztalceniaobszarksztalcenia> getProgramksztalceniaobszarksztalcenias() {
		return this.programksztalceniaobszarksztalcenias;
	}

	public void setProgramksztalceniaobszarksztalcenias(
			Set<Programksztalceniaobszarksztalcenia> programksztalceniaobszarksztalcenias) {
		this.programksztalceniaobszarksztalcenias = programksztalceniaobszarksztalcenias;
	}

	public Set<Planstudiow> getPlanstudiows() {
		return this.planstudiows;
	}

	public void setPlanstudiows(Set<Planstudiow> planstudiows) {
		this.planstudiows = planstudiows;
	}

}
