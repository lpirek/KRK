package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.SemestrDAO;

@Service("SemestrService")
@Transactional(readOnly = true)
public class SemestrService {

	@Autowired
	SemestrDAO semestrDAO;

	public void setSemestrDAO(SemestrDAO semestrDAO) {
		this.semestrDAO = semestrDAO;
	}
}
