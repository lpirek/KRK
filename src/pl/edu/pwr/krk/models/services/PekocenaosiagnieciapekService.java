package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PekocenaosiagnieciapekDAO;

@Service("PekocenaosiagnieciapekService")
@Transactional(readOnly = true)
public class PekocenaosiagnieciapekService {

	@Autowired
	PekocenaosiagnieciapekDAO pekocenaosiagnieciapekDAO;

	public void setPekocenaosiagnieciapekDAO(PekocenaosiagnieciapekDAO pekocenaosiagnieciapekDAO) {
		this.pekocenaosiagnieciapekDAO = pekocenaosiagnieciapekDAO;
	}
}
