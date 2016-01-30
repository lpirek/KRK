package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.NarzedziedydaktyczneDAO;

@Service("NarzedziedydaktyczneService")
@Transactional(readOnly = true)
public class NarzedziedydaktyczneService {

	@Autowired
	NarzedziedydaktyczneDAO narzedziedydaktyczneDAO;

	/**
	 * @return the narzedziedydaktyczneDAO
	 */
	public NarzedziedydaktyczneDAO getNarzedziedydaktyczneDAO() {
		return narzedziedydaktyczneDAO;
	}

	/**
	 * @param narzedziedydaktyczneDAO the narzedziedydaktyczneDAO to set
	 */
	public void setNarzedziedydaktyczneDAO(NarzedziedydaktyczneDAO narzedziedydaktyczneDAO) {
		this.narzedziedydaktyczneDAO = narzedziedydaktyczneDAO;
	}
}
