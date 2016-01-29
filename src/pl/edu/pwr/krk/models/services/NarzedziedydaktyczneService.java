package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.NarzedziedydaktyczneHome;

@Service("NarzedziedydaktyczneService")
@Transactional(readOnly = true)
public class NarzedziedydaktyczneService {

	@Autowired
	NarzedziedydaktyczneHome narzedziedydaktyczneHome;

	/**
	 * @return the narzedziedydaktyczneHome
	 */
	public NarzedziedydaktyczneHome getNarzedziedydaktyczneHome() {
		return narzedziedydaktyczneHome;
	}

	/**
	 * @param narzedziedydaktyczneHome the narzedziedydaktyczneHome to set
	 */
	public void setNarzedziedydaktyczneHome(NarzedziedydaktyczneHome narzedziedydaktyczneHome) {
		this.narzedziedydaktyczneHome = narzedziedydaktyczneHome;
	}
}
