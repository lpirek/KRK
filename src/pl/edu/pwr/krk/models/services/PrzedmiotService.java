package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PrzedmiotDAO;
import pl.edu.pwr.krk.models.entities.Przedmiot;

@Service("PrzedmiotService")
@Transactional(readOnly = true)
public class PrzedmiotService {

	@Autowired
	PrzedmiotDAO przedmiotDAO;

	public void setPrzedmiotDAO(PrzedmiotDAO przedmiotDAO) {
		this.przedmiotDAO = przedmiotDAO;
	}
	
	public Przedmiot getPrzedmiot(int id) {
		return przedmiotDAO.findById(id);
	}
}
