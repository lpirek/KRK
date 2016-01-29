package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.TrescprogramowaHome;

@Service("TrescprogramowaService")
@Transactional(readOnly = true)
public class TrescprogramowaService {

	@Autowired
	TrescprogramowaHome trescprogramowaHome;

	/**
	 * @return the trescprogramowaHome
	 */
	public TrescprogramowaHome getTrescprogramowaHome() {
		return trescprogramowaHome;
	}

	/**
	 * @param trescprogramowaHome
	 *            the trescprogramowaHome to set
	 */
	public void setTrescprogramowaHome(TrescprogramowaHome trescprogramowaHome) {
		this.trescprogramowaHome = trescprogramowaHome;
	}
}
