package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.MekkekDAO;

@Service("MekkekService")
@Transactional(readOnly = true)
public class MekkekService {

	@Autowired
	MekkekDAO mekkekDAO;

	/**
	 * @return the mekkekDAO
	 */
	public MekkekDAO getMekkekDAO() {
		return mekkekDAO;
	}

	/**
	 * @param mekkekDAO the mekkekDAO to set
	 */
	public void setMekkekDAO(MekkekDAO mekkekDAO) {
		this.mekkekDAO = mekkekDAO;
	}
}
