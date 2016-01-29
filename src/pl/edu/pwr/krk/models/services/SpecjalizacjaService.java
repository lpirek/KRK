package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.SpecjalizacjaHome;

@Service("SpecjalizacjaService")
@Transactional(readOnly = true)
public class SpecjalizacjaService {

	@Autowired
	SpecjalizacjaHome specjalizacjaHome;

	/**
	 * @return the specjalizacjaHome
	 */
	public SpecjalizacjaHome getSpecjalizacjaHome() {
		return specjalizacjaHome;
	}

	/**
	 * @param specjalizacjaHome
	 *            the specjalizacjaHome to set
	 */
	public void setSpecjalizacjaHome(SpecjalizacjaHome specjalizacjaHome) {
		this.specjalizacjaHome = specjalizacjaHome;
	}
}
