package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PrzedmiotowyefektksztalceniaHome;

@Service("PrzedmiotowyefektksztalceniaService")
@Transactional(readOnly = true)
public class PrzedmiotowyefektksztalceniaService {

	@Autowired
	PrzedmiotowyefektksztalceniaHome przedmiotowyefektksztalceniaHome;

	/**
	 * @return the przedmiotowyefektksztalceniaHome
	 */
	public PrzedmiotowyefektksztalceniaHome getPrzedmiotowyefektksztalceniaHome() {
		return przedmiotowyefektksztalceniaHome;
	}

	/**
	 * @param przedmiotowyefektksztalceniaHome
	 *            the przedmiotowyefektksztalceniaHome to set
	 */
	public void setPrzedmiotowyefektksztalceniaHome(PrzedmiotowyefektksztalceniaHome przedmiotowyefektksztalceniaHome) {
		this.przedmiotowyefektksztalceniaHome = przedmiotowyefektksztalceniaHome;
	}
}
