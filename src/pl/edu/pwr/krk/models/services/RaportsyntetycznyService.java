package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.RaportsyntetycznyHome;

@Service("RaportsyntetycznyService")
@Transactional(readOnly = true)
public class RaportsyntetycznyService {

	@Autowired
	RaportsyntetycznyHome raportsyntetycznyHome;

	/**
	 * @return the raportsyntetycznyHome
	 */
	public RaportsyntetycznyHome getRaportsyntetycznyHome() {
		return raportsyntetycznyHome;
	}

	/**
	 * @param raportsyntetycznyHome
	 *            the raportsyntetycznyHome to set
	 */
	public void setRaportsyntetycznyHome(RaportsyntetycznyHome raportsyntetycznyHome) {
		this.raportsyntetycznyHome = raportsyntetycznyHome;
	}
}
