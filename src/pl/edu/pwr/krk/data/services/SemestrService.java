package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.SemestrHome;

@Service("SemestrService")
@Transactional(readOnly = true)
public class SemestrService {

	@Autowired
	SemestrHome semestrHome;

	/**
	 * @return the semestrHome
	 */
	public SemestrHome getSemestrHome() {
		return semestrHome;
	}

	/**
	 * @param semestrHome
	 *            the semestrHome to set
	 */
	public void setSemestrHome(SemestrHome semestrHome) {
		this.semestrHome = semestrHome;
	}
}
