package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PrzedmiotkekHome;

@Service("PrzedmiotkekService")
@Transactional(readOnly = true)
public class PrzedmiotkekService {

	@Autowired
	PrzedmiotkekHome przedmiotkekHome;

	/**
	 * @return the przedmiotkekHome
	 */
	public PrzedmiotkekHome getPrzedmiotkekHome() {
		return przedmiotkekHome;
	}

	/**
	 * @param przedmiotkekHome
	 *            the przedmiotkekHome to set
	 */
	public void setPrzedmiotkekHome(PrzedmiotkekHome przedmiotkekHome) {
		this.przedmiotkekHome = przedmiotkekHome;
	}
}
