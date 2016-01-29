package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.OcenaosiagieciapekHome;

@Service("OcenaosiagnieciapekService")
@Transactional(readOnly = true)
public class OcenaosiagnieciapekService {

	@Autowired
	OcenaosiagieciapekHome ocenaosiagnieciapekHome;

	/**
	 * @return the ocenaosiagnieciapekHome
	 */
	public OcenaosiagieciapekHome getOcenaosiagnieciapekHome() {
		return ocenaosiagnieciapekHome;
	}

	/**
	 * @param ocenaosiagnieciapekHome
	 *            the ocenaosiagnieciapekHome to set
	 */
	public void setOcenaosiagnieciapekHome(OcenaosiagieciapekHome ocenaosiagnieciapekHome) {
		this.ocenaosiagnieciapekHome = ocenaosiagnieciapekHome;
	}
}
