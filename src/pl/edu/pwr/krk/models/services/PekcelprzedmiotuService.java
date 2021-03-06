package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PekcelprzedmiotuDAO;

@Service("PekcelprzedmiotuService")
@Transactional(readOnly = true)
public class PekcelprzedmiotuService {

	@Autowired
	PekcelprzedmiotuDAO pekcelprzedmiotuDAO;

	public void setPekcelprzedmiotuDAO(PekcelprzedmiotuDAO pekcelprzedmiotuDAO) {
		this.pekcelprzedmiotuDAO = pekcelprzedmiotuDAO;
	}
}
