package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.KierunekstudiowDAO;

@Service("KierunekstudiowService")
@Transactional(readOnly = true)
public class KierunekstudiowService {

	@Autowired
	KierunekstudiowDAO kierunekstudiowDAO;
	
	public void setKierunekstudiowDAO(KierunekstudiowDAO kierunekstudiowDAO) {
		this.kierunekstudiowDAO = kierunekstudiowDAO;
	}
}
