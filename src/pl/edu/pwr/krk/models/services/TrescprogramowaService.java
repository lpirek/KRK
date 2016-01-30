package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.TrescprogramowaDAO;

@Service("TrescprogramowaService")
@Transactional(readOnly = true)
public class TrescprogramowaService {

	@Autowired
	TrescprogramowaDAO trescprogramowaDAO;

	/**
	 * @return the trescprogramowaDAO
	 */
	public TrescprogramowaDAO getTrescprogramowaDAO() {
		return trescprogramowaDAO;
	}

	/**
	 * @param trescprogramowaDAO
	 *            the trescprogramowaDAO to set
	 */
	public void setTrescprogramowaDAO(TrescprogramowaDAO trescprogramowaDAO) {
		this.trescprogramowaDAO = trescprogramowaDAO;
	}
}
