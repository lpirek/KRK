package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.MinisterialnyefektksztalceniaDAO;

@Service("MinisterialnyefektksztalceniaService")
@Transactional(readOnly = true)
public class MinisterialnyefektksztalceniaService {

	@Autowired
	MinisterialnyefektksztalceniaDAO ministerialnyefektksztalceniaDAO;

	/**
	 * @return the ministerialnyefektksztalceniaDAO
	 */
	public MinisterialnyefektksztalceniaDAO getMinisterialnyefektksztalceniaDAO() {
		return ministerialnyefektksztalceniaDAO;
	}

	/**
	 * @param ministerialnyefektksztalceniaDAO
	 *            the ministerialnyefektksztalceniaDAO to set
	 */
	public void setMinisterialnyefektksztalceniaDAO(
			MinisterialnyefektksztalceniaDAO ministerialnyefektksztalceniaDAO) {
		this.ministerialnyefektksztalceniaDAO = ministerialnyefektksztalceniaDAO;
	}
}
