package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PrzedmiotowyefektksztalceniaDAO;

@Service("PrzedmiotowyefektksztalceniaService")
@Transactional(readOnly = true)
public class PrzedmiotowyefektksztalceniaService {

	@Autowired
	PrzedmiotowyefektksztalceniaDAO przedmiotowyefektksztalceniaDAO;

	public void setPrzedmiotowyefektksztalceniaDAO(PrzedmiotowyefektksztalceniaDAO przedmiotowyefektksztalceniaDAO) {
		this.przedmiotowyefektksztalceniaDAO = przedmiotowyefektksztalceniaDAO;
	}
}
