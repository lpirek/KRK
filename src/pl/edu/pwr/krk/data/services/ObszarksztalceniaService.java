package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.ObszarksztalceniaHome;

@Service("ObszarksztalceniaService")
@Transactional(readOnly = true)
public class ObszarksztalceniaService {

	@Autowired
	ObszarksztalceniaHome obszarksztalceniaHome;

	/**
	 * @return the obszarksztalceniaHome
	 */
	public ObszarksztalceniaHome getObszarksztalceniaHome() {
		return obszarksztalceniaHome;
	}

	/**
	 * @param obszarksztalceniaHome
	 *            the obszarksztalceniaHome to set
	 */
	public void setObszarksztalceniaHome(ObszarksztalceniaHome obszarksztalceniaHome) {
		this.obszarksztalceniaHome = obszarksztalceniaHome;
	}
}
