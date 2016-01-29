package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PekcelprzedmiotuHome;

@Service("PekcelprzedmiotuService")
@Transactional(readOnly = true)
public class PekcelprzedmiotuService {

	@Autowired
	PekcelprzedmiotuHome pekcelprzedmiotuHome;

	/**
	 * @return the pekcelprzedmiotuHome
	 */
	public PekcelprzedmiotuHome getPekcelprzedmiotuHome() {
		return pekcelprzedmiotuHome;
	}

	/**
	 * @param pekcelprzedmiotuHome the pekcelprzedmiotuHome to set
	 */
	public void setPekcelprzedmiotuHome(PekcelprzedmiotuHome pekcelprzedmiotuHome) {
		this.pekcelprzedmiotuHome = pekcelprzedmiotuHome;
	}
}
