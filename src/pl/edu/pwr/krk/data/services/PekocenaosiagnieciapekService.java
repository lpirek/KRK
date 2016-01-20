package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.PekocenaosiagnieciapekHome;

@Service("PekocenaosiagnieciapekService")
@Transactional(readOnly = true)
public class PekocenaosiagnieciapekService {

	@Autowired
	PekocenaosiagnieciapekHome pekocenaosiagnieciapekHome;

	/**
	 * @return the pekocenaosiagnieciapekHome
	 */
	public PekocenaosiagnieciapekHome getPekocenaosiagnieciapekHome() {
		return pekocenaosiagnieciapekHome;
	}

	/**
	 * @param pekocenaosiagnieciapekHome
	 *            the pekocenaosiagnieciapekHome to set
	 */
	public void setPekocenaosiagnieciapekHome(PekocenaosiagnieciapekHome pekocenaosiagnieciapekHome) {
		this.pekocenaosiagnieciapekHome = pekocenaosiagnieciapekHome;
	}
}
