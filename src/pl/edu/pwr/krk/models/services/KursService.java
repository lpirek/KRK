package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KursDAO;

@Service("KursService")
@Transactional(readOnly = true)
public class KursService {

	@Autowired
	KursDAO kursDAO;

	/**
	 * @return the kursDAO
	 */
	public KursDAO getKursDAO() {
		return kursDAO;
	}

	/**
	 * @param kursDAO
	 *            the kursDAO to set
	 */
	public void setKursDAO(KursDAO kursDAO) {
		this.kursDAO = kursDAO;
	}
}
