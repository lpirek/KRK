package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.RaportsyntetycznyDAO;

@Service("RaportsyntetycznyService")
@Transactional(readOnly = true)
public class RaportsyntetycznyService {

	@Autowired
	RaportsyntetycznyDAO raportsyntetycznyDAO;

	public void setRaportsyntetycznyDAO(RaportsyntetycznyDAO raportsyntetycznyDAO) {
		this.raportsyntetycznyDAO = raportsyntetycznyDAO;
	}
}
