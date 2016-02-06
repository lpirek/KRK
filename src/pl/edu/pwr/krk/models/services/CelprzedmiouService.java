package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.CelprzedmiotuDAO;

@Service("CelprzedmiouService")
@Transactional(readOnly = true)
public class CelprzedmiouService {

	@Autowired
	CelprzedmiotuDAO celprzedmiotuDAO;

	public void setCelprzedmiotuDAO(CelprzedmiotuDAO celprzedmiotuDAO) {
		this.celprzedmiotuDAO = celprzedmiotuDAO;
	}
}
