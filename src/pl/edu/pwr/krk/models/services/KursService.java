package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KursHome;

@Service("KursService")
@Transactional(readOnly = true)
public class KursService {

	@Autowired
	KursHome kursHome;

	/**
	 * @return the kursHome
	 */
	public KursHome getKursHome() {
		return kursHome;
	}

	/**
	 * @param kursHome
	 *            the kursHome to set
	 */
	public void setKursHome(KursHome kursHome) {
		this.kursHome = kursHome;
	}
}
