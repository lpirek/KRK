package pl.edu.pwr.krk.data.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.WymaganiawstepneHome;
import pl.edu.pwr.krk.data.entities.Wymaganiawstepne;

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
