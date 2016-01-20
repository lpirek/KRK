package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.WydzialHome;

@Service("WydzialService")
@Transactional(readOnly = true)
public class WydzialService {

	@Autowired
	WydzialHome wydzialHome;

	/**
	 * @return the wydzialHome
	 */
	public WydzialHome getWydzialHome() {
		return wydzialHome;
	}

	/**
	 * @param wydzialHome the wydzialHome to set
	 */
	public void setWydzialHome(WydzialHome wydzialHome) {
		this.wydzialHome = wydzialHome;
	}
}
