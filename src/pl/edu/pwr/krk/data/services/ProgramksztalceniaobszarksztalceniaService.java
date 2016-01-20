package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.ProgramksztalceniaobszarksztalceniaHome;

@Service("ProgramksztalceniaobszarksztalceniaService")
@Transactional(readOnly = true)
public class ProgramksztalceniaobszarksztalceniaService {

	@Autowired
	ProgramksztalceniaobszarksztalceniaHome programksztalceniaobszarksztalceniaHome;

	/**
	 * @return the programksztalceniaobszarksztalceniaHome
	 */
	public ProgramksztalceniaobszarksztalceniaHome getProgramksztalceniaobszarksztalceniaHome() {
		return programksztalceniaobszarksztalceniaHome;
	}

	/**
	 * @param programksztalceniaobszarksztalceniaHome
	 *            the programksztalceniaobszarksztalceniaHome to set
	 */
	public void setProgramksztalceniaobszarksztalceniaHome(
			ProgramksztalceniaobszarksztalceniaHome programksztalceniaobszarksztalceniaHome) {
		this.programksztalceniaobszarksztalceniaHome = programksztalceniaobszarksztalceniaHome;
	}
}
