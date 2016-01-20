package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.PrzedmiotHome;

@Service("PrzedmiotService")
@Transactional(readOnly = true)
public class PrzedmiotService {

	@Autowired
	PrzedmiotHome przedmiotHome;

	/**
	 * @return the przedmiotHome
	 */
	public PrzedmiotHome getPrzedmiotHome() {
		return przedmiotHome;
	}

	/**
	 * @param przedmiotHome
	 *            the przedmiotHome to set
	 */
	public void setPrzedmiotHome(PrzedmiotHome przedmiotHome) {
		this.przedmiotHome = przedmiotHome;
	}
}
