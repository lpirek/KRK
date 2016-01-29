package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KierunekstudiowHome;

@Service("KierunekstudiowService")
@Transactional(readOnly = true)
public class KierunekstudiowService {

	@Autowired
	KierunekstudiowHome kierunekstudiowHome;

	/**
	 * @return the kierunekstudiowHome
	 */
	public KierunekstudiowHome getKierunekstudiowHome() {
		return kierunekstudiowHome;
	}

	/**
	 * @param kierunekstudiowHome
	 *            the kierunekstudiowHome to set
	 */
	public void setKierunekstudiowHome(KierunekstudiowHome kierunekstudiowHome) {
		this.kierunekstudiowHome = kierunekstudiowHome;
	}
}
