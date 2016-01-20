package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.CelprzedmiotuHome;

@Service("CelprzedmiouService")
@Transactional(readOnly = true)
public class CelprzedmiouService {

	@Autowired
	CelprzedmiotuHome celprzedmiotuHome;

	/**
	 * @return the celprzedmiotuHome
	 */
	public CelprzedmiotuHome getCelprzedmiotuHome() {
		return celprzedmiotuHome;
	}

	/**
	 * @param celprzedmiotuHome
	 *            the celprzedmiotuHome to set
	 */
	public void setCelprzedmiotuHome(CelprzedmiotuHome celprzedmiotuHome) {
		this.celprzedmiotuHome = celprzedmiotuHome;
	}
}
