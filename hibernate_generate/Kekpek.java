// default package
// Generated 2016-01-17 19:43:59 by Hibernate Tools 4.0.0

/**
 * Kekpek generated by hbm2java
 */
public class Kekpek implements java.io.Serializable {

	private KekpekId id;
	private Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia;
	private Kierunkowyefektksztalcenia kierunkowyefektksztalcenia;

	public Kekpek() {
	}

	public Kekpek(KekpekId id, Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia,
			Kierunkowyefektksztalcenia kierunkowyefektksztalcenia) {
		this.id = id;
		this.przedmiotowyefektksztalcenia = przedmiotowyefektksztalcenia;
		this.kierunkowyefektksztalcenia = kierunkowyefektksztalcenia;
	}

	public KekpekId getId() {
		return this.id;
	}

	public void setId(KekpekId id) {
		this.id = id;
	}

	public Przedmiotowyefektksztalcenia getPrzedmiotowyefektksztalcenia() {
		return this.przedmiotowyefektksztalcenia;
	}

	public void setPrzedmiotowyefektksztalcenia(Przedmiotowyefektksztalcenia przedmiotowyefektksztalcenia) {
		this.przedmiotowyefektksztalcenia = przedmiotowyefektksztalcenia;
	}

	public Kierunkowyefektksztalcenia getKierunkowyefektksztalcenia() {
		return this.kierunkowyefektksztalcenia;
	}

	public void setKierunkowyefektksztalcenia(Kierunkowyefektksztalcenia kierunkowyefektksztalcenia) {
		this.kierunkowyefektksztalcenia = kierunkowyefektksztalcenia;
	}

}