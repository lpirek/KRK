package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PeknarzedziedydaktyczneHome;

@Service("PeknarzedziedydaktyczneService")
@Transactional(readOnly = true)
public class PeknarzedziedydaktyczneService {

	@Autowired
	PeknarzedziedydaktyczneHome peknarzedziedydaktyczneHome;

	/**
	 * @return the peknarzedziedydaktyczneHome
	 */
	public PeknarzedziedydaktyczneHome getPeknarzedziedydaktyczneHome() {
		return peknarzedziedydaktyczneHome;
	}

	/**
	 * @param peknarzedziedydaktyczneHome
	 *            the peknarzedziedydaktyczneHome to set
	 */
	public void setPeknarzedziedydaktyczneHome(PeknarzedziedydaktyczneHome peknarzedziedydaktyczneHome) {
		this.peknarzedziedydaktyczneHome = peknarzedziedydaktyczneHome;
	}
}
