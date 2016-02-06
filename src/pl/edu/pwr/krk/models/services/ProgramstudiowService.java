package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.ProgramstudiowDAO;

@Service("ProgramstudiowService")
@Transactional(readOnly = true)
public class ProgramstudiowService {

	@Autowired
	ProgramstudiowDAO programstudiowDAO;

	public void setProgramstudiowDAO(ProgramstudiowDAO programstudiowDAO) {
		this.programstudiowDAO = programstudiowDAO;
	}
}
