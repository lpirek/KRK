package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KartaprzedmiotuDAO;

@Service("KartaprzedmiotuService")
@Transactional(readOnly = true)
public class KartaprzedmiotuService {

	@Autowired
	KartaprzedmiotuDAO kartaprzedmiotuDAO;

	/**
	 * @return the kartaprzedmiotuDAO
	 */
	public KartaprzedmiotuDAO getKartaprzedmiotuDAO() {
		return kartaprzedmiotuDAO;
	}

	/**
	 * @param kartaprzedmiotuDAO
	 *            the kartaprzedmiotuDAO to set
	 */
	public void setKartaprzedmiotuDAO(KartaprzedmiotuDAO kartaprzedmiotuDAO) {
		this.kartaprzedmiotuDAO = kartaprzedmiotuDAO;
	}
}
