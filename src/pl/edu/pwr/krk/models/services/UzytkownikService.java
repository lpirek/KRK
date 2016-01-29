package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.UzytkownikHome;

@Service("UzytkownikService")
@Transactional(readOnly = true)
public class UzytkownikService {

	@Autowired
	UzytkownikHome uzytkownikHome;

	/**
	 * @return the uzytkownikHome
	 */
	public UzytkownikHome getUzytkownikHome() {
		return uzytkownikHome;
	}

	/**
	 * @param uzytkownikHome
	 *            the uzytkownikHome to set
	 */
	public void setUzytkownikHome(UzytkownikHome uzytkownikHome) {
		this.uzytkownikHome = uzytkownikHome;
	}
}
