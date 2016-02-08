package pl.edu.pwr.krk.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KierunkowyefektksztalceniaDAO;
import pl.edu.pwr.krk.models.entities.Kierunkowyefektksztalcenia;

@Service("KierunkowyefektksztalceniaService")
@Transactional(readOnly = true)
public class KierunkowyefektksztalceniaService {

	@Autowired
	KierunkowyefektksztalceniaDAO kierunkowyefektksztalceniaDAO;

	public void setKierunkowyefektksztalceniaDAO(KierunkowyefektksztalceniaDAO kierunkowyefektksztalceniaDAO) {
		this.kierunkowyefektksztalceniaDAO = kierunkowyefektksztalceniaDAO;
	}
	
	public List<Kierunkowyefektksztalcenia> getFEEs() {
		return kierunkowyefektksztalceniaDAO.findAll();
	}
}
