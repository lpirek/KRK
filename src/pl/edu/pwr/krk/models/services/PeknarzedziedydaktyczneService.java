package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PeknarzedziedydaktyczneDAO;

@Service("PeknarzedziedydaktyczneService")
@Transactional(readOnly = true)
public class PeknarzedziedydaktyczneService {

	@Autowired
	PeknarzedziedydaktyczneDAO peknarzedziedydaktyczneDAO;

	public void setPeknarzedziedydaktyczneDAO(PeknarzedziedydaktyczneDAO peknarzedziedydaktyczneDAO) {
		this.peknarzedziedydaktyczneDAO = peknarzedziedydaktyczneDAO;
	}
}
