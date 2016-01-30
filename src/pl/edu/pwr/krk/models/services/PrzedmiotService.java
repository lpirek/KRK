package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PrzedmiotDAO;

@Service("PrzedmiotService")
@Transactional(readOnly = true)
public class PrzedmiotService {

	@Autowired
	PrzedmiotDAO przedmiotDAO;

	/**
	 * @return the przedmiotDAO
	 */
	public PrzedmiotDAO getPrzedmiotDAO() {
		return przedmiotDAO;
	}

	/**
	 * @param przedmiotDAO
	 *            the przedmiotDAO to set
	 */
	public void setPrzedmiotDAO(PrzedmiotDAO przedmiotDAO) {
		this.przedmiotDAO = przedmiotDAO;
	}
}
