package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.GrupakursowDAO;

@Service("GrupakursowService")
@Transactional(readOnly = true)
public class GrupakursowService {

	@Autowired
	GrupakursowDAO grupakursowDAO;

	/**
	 * @return the grupakursowDAO
	 */
	public GrupakursowDAO getGrupakursowDAO() {
		return grupakursowDAO;
	}

	/**
	 * @param grupakursowDAO
	 *            the grupakursowDAO to set
	 */
	public void setGrupakursowDAO(GrupakursowDAO grupakursowDAO) {
		this.grupakursowDAO = grupakursowDAO;
	}
}
