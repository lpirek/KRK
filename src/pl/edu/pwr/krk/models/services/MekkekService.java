package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.MekkekHome;

@Service("MekkekService")
@Transactional(readOnly = true)
public class MekkekService {

	@Autowired
	MekkekHome mekkekHome;

	/**
	 * @return the mekkekHome
	 */
	public MekkekHome getMekkekHome() {
		return mekkekHome;
	}

	/**
	 * @param mekkekHome the mekkekHome to set
	 */
	public void setMekkekHome(MekkekHome mekkekHome) {
		this.mekkekHome = mekkekHome;
	}
}
