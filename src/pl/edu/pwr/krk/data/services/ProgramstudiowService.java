package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.ProgramstudiowHome;

@Service("ProgramstudiowService")
@Transactional(readOnly = true)
public class ProgramstudiowService {

	@Autowired
	ProgramstudiowHome programstudiowHome;

	/**
	 * @return the programstudiowHome
	 */
	public ProgramstudiowHome getProgramstudiowHome() {
		return programstudiowHome;
	}

	/**
	 * @param programstudiowHome
	 *            the programstudiowHome to set
	 */
	public void setProgramstudiowHome(ProgramstudiowHome programstudiowHome) {
		this.programstudiowHome = programstudiowHome;
	}
}
