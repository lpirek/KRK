package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.ProgramksztalceniaHome;

@Service("ProgramksztalceniaService")
@Transactional(readOnly = true)
public class ProgramksztalceniaService {

	@Autowired
	ProgramksztalceniaHome programksztalceniaHome;

	/**
	 * @return the programksztalceniaHome
	 */
	public ProgramksztalceniaHome getProgramksztalceniaHome() {
		return programksztalceniaHome;
	}

	/**
	 * @param programksztalceniaHome
	 *            the programksztalceniaHome to set
	 */
	public void setProgramksztalceniaHome(ProgramksztalceniaHome programksztalceniaHome) {
		this.programksztalceniaHome = programksztalceniaHome;
	}
}
