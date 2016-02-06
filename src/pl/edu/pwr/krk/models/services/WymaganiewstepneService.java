package pl.edu.pwr.krk.models.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.WymaganiawstepneDAO;
import pl.edu.pwr.krk.models.entities.Wymaganiawstepne;

import org.springframework.beans.factory.annotation.Autowired;

@Service("WymaganiewstepneService")
@Transactional(readOnly = true)
public class WymaganiewstepneService {

	@Autowired
	WymaganiawstepneDAO wymaganiawstepneDAO;
	
	public void setWymaganiawstepneDAO(WymaganiawstepneDAO wymaganiawstepneDAO) {
		this.wymaganiawstepneDAO = wymaganiawstepneDAO;
	}
}
