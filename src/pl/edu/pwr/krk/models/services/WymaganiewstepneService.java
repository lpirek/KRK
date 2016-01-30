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

	@Transactional(readOnly = false)
	public void persistWymaganiawstepne(Wymaganiawstepne wymaganiawstepne) {
		wymaganiawstepneDAO.persist(wymaganiawstepne);
	}

	@Transactional(readOnly = false)
	public void deleteWymaganiawstepne(Wymaganiawstepne wymaganiawstepne) {
		wymaganiawstepneDAO.delete(wymaganiawstepne);
	}

	/**
	 * @return the wymaganiawstepneDAO
	 */
	public WymaganiawstepneDAO getWymaganiawstepneDAO() {
		return wymaganiawstepneDAO;
	}

	/**
	 * @param wymaganiawstepneDAO
	 *            the wymaganiawstepneDAO to set
	 */
	public void setWymaganiawstepneDAO(WymaganiawstepneDAO wymaganiawstepneDAO) {
		this.wymaganiawstepneDAO = wymaganiawstepneDAO;
	}
}
