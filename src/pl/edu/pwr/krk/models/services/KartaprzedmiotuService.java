package pl.edu.pwr.krk.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KartaprzedmiotuDAO;
import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;

@Service("KartaprzedmiotuService")
@Transactional(readOnly = true)
public class KartaprzedmiotuService {

	@Autowired
	KartaprzedmiotuDAO kartaprzedmiotuDAO;

	public void setKartaprzedmiotuDAO(KartaprzedmiotuDAO kartaprzedmiotuDAO) {
		this.kartaprzedmiotuDAO = kartaprzedmiotuDAO;
	}

	public List<Kartaprzedmiotu> getKartyPrzedmiotu(int id) {
		return kartaprzedmiotuDAO.findKartyPrzedmiotu(id);
	}
}
