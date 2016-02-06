package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KierunkowyefektksztalceniaDAO;

@Service("KierunkowyefektksztalceniaService")
@Transactional(readOnly = true)
public class KierunkowyefektksztalceniaService {

	@Autowired
	KierunkowyefektksztalceniaDAO kierunkowyefektksztalceniaDAO;

	public void setKierunkowyefektksztalceniaDAO(KierunkowyefektksztalceniaDAO kierunkowyefektksztalceniaDAO) {
		this.kierunkowyefektksztalceniaDAO = kierunkowyefektksztalceniaDAO;
	}
}
