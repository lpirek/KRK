package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PektrescprogramowaHome;

@Service("PektrescprogramowaService")
@Transactional(readOnly = true)
public class PektrescprogramowaService {

	@Autowired
	PektrescprogramowaHome pektrescprogramowaHome;

	/**
	 * @return the pektrescprogramowaHome
	 */
	public PektrescprogramowaHome getPektrescprogramowaHome() {
		return pektrescprogramowaHome;
	}

	/**
	 * @param pektrescprogramowaHome the pektrescprogramowaHome to set
	 */
	public void setPektrescprogramowaHome(PektrescprogramowaHome pektrescprogramowaHome) {
		this.pektrescprogramowaHome = pektrescprogramowaHome;
	}
}
