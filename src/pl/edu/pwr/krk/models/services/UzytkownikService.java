package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.UzytkownikDAO;
import pl.edu.pwr.krk.models.entities.Uzytkownik;

@Service("UzytkownikService")
@Transactional(readOnly = true)
public class UzytkownikService {

	@Autowired
	public UzytkownikDAO uzytkownikDAO;
	
	public void setUzytkownikDAO(UzytkownikDAO uzytkownikDAO) {
		this.uzytkownikDAO = uzytkownikDAO;
	}
	
	public Uzytkownik getUzytkownik(String login) {
		return uzytkownikDAO.findByLogin(login);
	}
}
