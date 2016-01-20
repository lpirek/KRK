package pl.edu.pwr.krk.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pwr.krk.data.dao.PlanstudiowHome;

@Service("PlanstudiowService")
@Transactional(readOnly = true)
public class PlanstudiowService {

	@Autowired
	PlanstudiowHome planstudiowHome;

	/**
	 * @return the planstudiowHome
	 */
	public PlanstudiowHome getPlanstudiowHome() {
		return planstudiowHome;
	}

	/**
	 * @param planstudiowHome
	 *            the planstudiowHome to set
	 */
	public void setPlanstudiowHome(PlanstudiowHome planstudiowHome) {
		this.planstudiowHome = planstudiowHome;
	}
}
