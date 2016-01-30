package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.SpecjalizacjaDAO;

@Service("SpecjalizacjaService")
@Transactional(readOnly = true)
public class SpecjalizacjaService {

	@Autowired
	SpecjalizacjaDAO specjalizacjaDAO;

	/**
	 * @return the specjalizacjaDAO
	 */
	public SpecjalizacjaDAO getSpecjalizacjaDAO() {
		return specjalizacjaDAO;
	}

	/**
	 * @param specjalizacjaDAO
	 *            the specjalizacjaDAO to set
	 */
	public void setSpecjalizacjaDAO(SpecjalizacjaDAO specjalizacjaDAO) {
		this.specjalizacjaDAO = specjalizacjaDAO;
	}
}
