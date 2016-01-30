package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.ObszarksztalceniaDAO;

@Service("ObszarksztalceniaService")
@Transactional(readOnly = true)
public class ObszarksztalceniaService {

	@Autowired
	ObszarksztalceniaDAO obszarksztalceniaDAO;

	/**
	 * @return the obszarksztalceniaDAO
	 */
	public ObszarksztalceniaDAO getObszarksztalceniaDAO() {
		return obszarksztalceniaDAO;
	}

	/**
	 * @param obszarksztalceniaDAO
	 *            the obszarksztalceniaDAO to set
	 */
	public void setObszarksztalceniaDAO(ObszarksztalceniaDAO obszarksztalceniaDAO) {
		this.obszarksztalceniaDAO = obszarksztalceniaDAO;
	}
}
