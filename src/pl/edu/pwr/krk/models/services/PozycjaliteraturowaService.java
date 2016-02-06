package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PozycjaliteraturowaDAO;

@Service("PozycjaliteraturowaService")
@Transactional(readOnly = true)
public class PozycjaliteraturowaService {

	@Autowired
	PozycjaliteraturowaDAO pozycjaliteraturowaDAO;

	public void setPozycjaliteraturowaDAO(PozycjaliteraturowaDAO pozycjaliteraturowaDAO) {
		this.pozycjaliteraturowaDAO = pozycjaliteraturowaDAO;
	}
}
