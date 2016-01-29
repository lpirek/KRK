package pl.edu.pwr.krk.models.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.WymaganiawstepneHome;
import pl.edu.pwr.krk.models.entities.Wymaganiawstepne;

import org.springframework.beans.factory.annotation.Autowired;

@Service("WymaganiewstepneService")
@Transactional(readOnly = true)
public class WymaganiewstepneService {

	@Autowired
	WymaganiawstepneHome wymaganiawstepneHome;

	@Transactional(readOnly = false)
	public void persistWymaganiawstepne(Wymaganiawstepne wymaganiawstepne) {
		wymaganiawstepneHome.persist(wymaganiawstepne);
	}

	@Transactional(readOnly = false)
	public void deleteWymaganiawstepne(Wymaganiawstepne wymaganiawstepne) {
		wymaganiawstepneHome.delete(wymaganiawstepne);
	}

	/**
	 * @return the wymaganiawstepneHome
	 */
	public WymaganiawstepneHome getWymaganiawstepneHome() {
		return wymaganiawstepneHome;
	}

	/**
	 * @param wymaganiawstepneHome
	 *            the wymaganiawstepneHome to set
	 */
	public void setWymaganiawstepneHome(WymaganiawstepneHome wymaganiawstepneHome) {
		this.wymaganiawstepneHome = wymaganiawstepneHome;
	}
}
