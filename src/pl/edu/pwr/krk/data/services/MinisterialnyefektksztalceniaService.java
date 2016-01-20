package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.MinisterialnyefektksztalceniaHome;

@Service("MinisterialnyefektksztalceniaService")
@Transactional(readOnly = true)
public class MinisterialnyefektksztalceniaService {

	@Autowired
	MinisterialnyefektksztalceniaHome ministerialnyefektksztalceniaHome;

	/**
	 * @return the ministerialnyefektksztalceniaHome
	 */
	public MinisterialnyefektksztalceniaHome getMinisterialnyefektksztalceniaHome() {
		return ministerialnyefektksztalceniaHome;
	}

	/**
	 * @param ministerialnyefektksztalceniaHome
	 *            the ministerialnyefektksztalceniaHome to set
	 */
	public void setMinisterialnyefektksztalceniaHome(
			MinisterialnyefektksztalceniaHome ministerialnyefektksztalceniaHome) {
		this.ministerialnyefektksztalceniaHome = ministerialnyefektksztalceniaHome;
	}
}
