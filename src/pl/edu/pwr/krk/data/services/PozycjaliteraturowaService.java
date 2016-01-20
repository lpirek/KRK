package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.PozycjaliteraturowaHome;

@Service("PozycjaliteraturowaService")
@Transactional(readOnly = true)
public class PozycjaliteraturowaService {

	@Autowired
	PozycjaliteraturowaHome pozycjaliteraturowaHome;

	/**
	 * @return the pozycjaliteraturowaHome
	 */
	public PozycjaliteraturowaHome getPozycjaliteraturowaHome() {
		return pozycjaliteraturowaHome;
	}

	/**
	 * @param pozycjaliteraturowaHome
	 *            the pozycjaliteraturowaHome to set
	 */
	public void setPozycjaliteraturowaHome(PozycjaliteraturowaHome pozycjaliteraturowaHome) {
		this.pozycjaliteraturowaHome = pozycjaliteraturowaHome;
	}
}
