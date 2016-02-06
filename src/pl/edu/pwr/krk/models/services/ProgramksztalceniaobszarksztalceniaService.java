package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.ProgramksztalceniaobszarksztalceniaDAO;

@Service("ProgramksztalceniaobszarksztalceniaService")
@Transactional(readOnly = true)
public class ProgramksztalceniaobszarksztalceniaService {

	@Autowired
	ProgramksztalceniaobszarksztalceniaDAO programksztalceniaobszarksztalceniaDAO;

	public void setProgramksztalceniaobszarksztalceniaDAO(
			ProgramksztalceniaobszarksztalceniaDAO programksztalceniaobszarksztalceniaDAO) {
		this.programksztalceniaobszarksztalceniaDAO = programksztalceniaobszarksztalceniaDAO;
	}
}
