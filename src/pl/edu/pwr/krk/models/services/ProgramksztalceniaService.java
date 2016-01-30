package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.ProgramksztalceniaDAO;

@Service("ProgramksztalceniaService")
@Transactional(readOnly = true)
public class ProgramksztalceniaService {

	@Autowired
	ProgramksztalceniaDAO programksztalceniaDAO;

	/**
	 * @return the programksztalceniaDAO
	 */
	public ProgramksztalceniaDAO getProgramksztalceniaDAO() {
		return programksztalceniaDAO;
	}

	/**
	 * @param programksztalceniaDAO
	 *            the programksztalceniaDAO to set
	 */
	public void setProgramksztalceniaDAO(ProgramksztalceniaDAO programksztalceniaDAO) {
		this.programksztalceniaDAO = programksztalceniaDAO;
	}
}
