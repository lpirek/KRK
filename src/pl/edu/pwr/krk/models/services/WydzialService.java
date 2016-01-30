package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.WydzialDAO;

@Service("WydzialService")
@Transactional(readOnly = true)
public class WydzialService {

	@Autowired
	WydzialDAO wydzialDAO;

	/**
	 * @return the wydzialDAO
	 */
	public WydzialDAO getWydzialDAO() {
		return wydzialDAO;
	}

	/**
	 * @param wydzialDAO the wydzialDAO to set
	 */
	public void setWydzialDAO(WydzialDAO wydzialDAO) {
		this.wydzialDAO = wydzialDAO;
	}
}
