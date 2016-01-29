package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.ModulksztalceniaHome;

@Service("ModulksztalceniaService")
@Transactional(readOnly = true)
public class ModulksztalceniaService {

	@Autowired
	ModulksztalceniaHome modulksztalceniaHome;

	/**
	 * @return the modulksztalceniaHome
	 */
	public ModulksztalceniaHome getModulksztalceniaHome() {
		return modulksztalceniaHome;
	}

	/**
	 * @param modulksztalceniaHome
	 *            the modulksztalceniaHome to set
	 */
	public void setModulksztalceniaHome(ModulksztalceniaHome modulksztalceniaHome) {
		this.modulksztalceniaHome = modulksztalceniaHome;
	}
}
