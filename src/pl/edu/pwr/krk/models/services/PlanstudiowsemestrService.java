package pl.edu.pwr.krk.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.models.dao.PlanstudiowsemestrHome;

@Service("PlanstudiowsemestrService")
@Transactional(readOnly = true)
public class PlanstudiowsemestrService {

	@Autowired
	PlanstudiowsemestrHome planstudiowsemestrHome;

	/**
	 * @return the planstudiowsemestrHome
	 */
	public PlanstudiowsemestrHome getPlanstudiowsemestrHome() {
		return planstudiowsemestrHome;
	}

	/**
	 * @param planstudiowsemestrHome
	 *            the planstudiowsemestrHome to set
	 */
	public void setPlanstudiowsemestrHome(PlanstudiowsemestrHome planstudiowsemestrHome) {
		this.planstudiowsemestrHome = planstudiowsemestrHome;
	}
}
