package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.GrupakursowHome;

@Service("GrupakursowService")
@Transactional(readOnly = true)
public class GrupakursowService {

	@Autowired
	GrupakursowHome grupakursowHome;

	/**
	 * @return the grupakursowHome
	 */
	public GrupakursowHome getGrupakursowHome() {
		return grupakursowHome;
	}

	/**
	 * @param grupakursowHome
	 *            the grupakursowHome to set
	 */
	public void setGrupakursowHome(GrupakursowHome grupakursowHome) {
		this.grupakursowHome = grupakursowHome;
	}
}
