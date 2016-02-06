package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PlanstudiowsemestrDAO;

@Service("PlanstudiowsemestrService")
@Transactional(readOnly = true)
public class PlanstudiowsemestrService {

	@Autowired
	PlanstudiowsemestrDAO planstudiowsemestrDAO;

	public void setPlanstudiowsemestrDAO(PlanstudiowsemestrDAO planstudiowsemestrDAO) {
		this.planstudiowsemestrDAO = planstudiowsemestrDAO;
	}
}
