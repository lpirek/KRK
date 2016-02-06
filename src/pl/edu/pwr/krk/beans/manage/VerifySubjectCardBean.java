package pl.edu.pwr.krk.beans.manage;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.edu.pwr.krk.models.services.KartaprzedmiotuService;
import pl.edu.pwr.krk.models.services.PrzedmiotService;
import pl.edu.pwr.krk.tools.ApplicationContextProvider;

@ManagedBean
@ViewScoped()
public class VerifySubjectCardBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Log log = LogFactory.getLog(VerifySubjectCardBean.class);
	
	private int id;
	
	private PrzedmiotService przedmiotService = null;
	private KartaprzedmiotuService kartaPrzedmiotuService = null;
	
	@PostConstruct
	public void postConstructor() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (!facesContext.isPostback() && !facesContext.isValidationFailed()) {
			
			przedmiotService = (PrzedmiotService) 
					ApplicationContextProvider.getApplicationContext().getBean("przedmiotService");
	    	kartaPrzedmiotuService  = (KartaprzedmiotuService) 
					ApplicationContextProvider.getApplicationContext().getBean("kartaprzedmiotuService");
	    
		}
	}

	public void initialiaze() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		
		initialiaze();
	}

}
