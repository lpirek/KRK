package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KekpekDAO;

@Service("KekpekService")
@Transactional(readOnly = true)
public class KekpekService {

	@Autowired
	KekpekDAO kekpekDAO;

	public void setKekpekDAO(KekpekDAO kekpekDAO) {
		this.kekpekDAO = kekpekDAO;
	}
}
