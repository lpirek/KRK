package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PrzedmiotkekDAO;

@Service("PrzedmiotkekService")
@Transactional(readOnly = true)
public class PrzedmiotkekService {

	@Autowired
	PrzedmiotkekDAO przedmiotkekDAO;

	/**
	 * @return the przedmiotkekDAO
	 */
	public PrzedmiotkekDAO getPrzedmiotkekDAO() {
		return przedmiotkekDAO;
	}

	/**
	 * @param przedmiotkekDAO
	 *            the przedmiotkekDAO to set
	 */
	public void setPrzedmiotkekDAO(PrzedmiotkekDAO przedmiotkekDAO) {
		this.przedmiotkekDAO = przedmiotkekDAO;
	}
}
