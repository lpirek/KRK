package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PlanstudiowDAO;

@Service("PlanstudiowService")
@Transactional(readOnly = true)
public class PlanstudiowService {

	@Autowired
	PlanstudiowDAO planstudiowDAO;

	/**
	 * @return the planstudiowDAO
	 */
	public PlanstudiowDAO getPlanstudiowDAO() {
		return planstudiowDAO;
	}

	/**
	 * @param planstudiowDAO
	 *            the planstudiowDAO to set
	 */
	public void setPlanstudiowDAO(PlanstudiowDAO planstudiowDAO) {
		this.planstudiowDAO = planstudiowDAO;
	}
}
