package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.ModulksztalceniaDAO;

@Service("ModulksztalceniaService")
@Transactional(readOnly = true)
public class ModulksztalceniaService {

	@Autowired
	ModulksztalceniaDAO modulksztalceniaDAO;

	public void setModulksztalceniaDAO(ModulksztalceniaDAO modulksztalceniaDAO) {
		this.modulksztalceniaDAO = modulksztalceniaDAO;
	}
}
