package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PektrescprogramowaDAO;

@Service("PektrescprogramowaService")
@Transactional(readOnly = true)
public class PektrescprogramowaService {

	@Autowired
	PektrescprogramowaDAO pektrescprogramowaDAO;

	/**
	 * @return the pektrescprogramowaDAO
	 */
	public PektrescprogramowaDAO getPektrescprogramowaDAO() {
		return pektrescprogramowaDAO;
	}

	/**
	 * @param pektrescprogramowaDAO the pektrescprogramowaDAO to set
	 */
	public void setPektrescprogramowaDAO(PektrescprogramowaDAO pektrescprogramowaDAO) {
		this.pektrescprogramowaDAO = pektrescprogramowaDAO;
	}
}
