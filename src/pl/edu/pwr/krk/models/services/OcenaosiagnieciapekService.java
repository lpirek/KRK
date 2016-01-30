package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.OcenaosiagieciapekDAO;

@Service("OcenaosiagnieciapekService")
@Transactional(readOnly = true)
public class OcenaosiagnieciapekService {

	@Autowired
	OcenaosiagieciapekDAO ocenaosiagnieciapekDAO;

	/**
	 * @return the ocenaosiagnieciapekDAO
	 */
	public OcenaosiagieciapekDAO getOcenaosiagnieciapekDAO() {
		return ocenaosiagnieciapekDAO;
	}

	/**
	 * @param ocenaosiagnieciapekDAO
	 *            the ocenaosiagnieciapekDAO to set
	 */
	public void setOcenaosiagnieciapekDAO(OcenaosiagieciapekDAO ocenaosiagnieciapekDAO) {
		this.ocenaosiagnieciapekDAO = ocenaosiagnieciapekDAO;
	}
}
