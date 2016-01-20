package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.KekpekHome;

@Service("KekpekService")
@Transactional(readOnly = true)
public class KekpekService {

	@Autowired
	KekpekHome kekpekHome;

	/**
	 * @return the kekpekHome
	 */
	public KekpekHome getKekpekHome() {
		return kekpekHome;
	}

	/**
	 * @param kekpekHome
	 *            the kekpekHome to set
	 */
	public void setKekpekHome(KekpekHome kekpekHome) {
		this.kekpekHome = kekpekHome;
	}
}
