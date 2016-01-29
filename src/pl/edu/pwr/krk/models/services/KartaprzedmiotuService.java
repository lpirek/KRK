package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KartaprzedmiotuHome;

@Service("KartaprzedmiotuService")
@Transactional(readOnly = true)
public class KartaprzedmiotuService {

	@Autowired
	KartaprzedmiotuHome kartaprzedmiotuHome;

	/**
	 * @return the kartaprzedmiotuHome
	 */
	public KartaprzedmiotuHome getKartaprzedmiotuHome() {
		return kartaprzedmiotuHome;
	}

	/**
	 * @param kartaprzedmiotuHome
	 *            the kartaprzedmiotuHome to set
	 */
	public void setKartaprzedmiotuHome(KartaprzedmiotuHome kartaprzedmiotuHome) {
		this.kartaprzedmiotuHome = kartaprzedmiotuHome;
	}
}
