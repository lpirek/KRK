package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KierunkowyefektksztalceniaHome;

@Service("KierunkowyefektksztalceniaService")
@Transactional(readOnly = true)
public class KierunkowyefektksztalceniaService {

	@Autowired
	KierunkowyefektksztalceniaHome kierunkowyefektksztalceniaHome;

	/**
	 * @return the kierunkowyefektksztalceniaHome
	 */
	public KierunkowyefektksztalceniaHome getKierunkowyefektksztalceniaHome() {
		return kierunkowyefektksztalceniaHome;
	}

	/**
	 * @param kierunkowyefektksztalceniaHome
	 *            the kierunkowyefektksztalceniaHome to set
	 */
	public void setKierunkowyefektksztalceniaHome(KierunkowyefektksztalceniaHome kierunkowyefektksztalceniaHome) {
		this.kierunkowyefektksztalceniaHome = kierunkowyefektksztalceniaHome;
	}
}
