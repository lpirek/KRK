package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.UzytkownikDAO;

@Service("UzytkownikService")
@Transactional(readOnly = true)
public class UzytkownikService {

	@Autowired
	UzytkownikDAO uzytkownikDAO;

	/**
	 * @return the uzytkownikDAO
	 */
	public UzytkownikDAO getUzytkownikDAO() {
		return uzytkownikDAO;
	}

	/**
	 * @param uzytkownikDAO
	 *            the uzytkownikDAO to set
	 */
	public void setUzytkownikDAO(UzytkownikDAO uzytkownikDAO) {
		this.uzytkownikDAO = uzytkownikDAO;
	}
}
