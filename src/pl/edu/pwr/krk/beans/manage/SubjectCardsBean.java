package pl.edu.pwr.krk.beans.manage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Uzytkownik;
import pl.edu.pwr.krk.models.services.PrzedmiotService;
import pl.edu.pwr.krk.models.services.UzytkownikService;
import pl.edu.pwr.krk.tools.ApplicationContextProvider;

@ManagedBean
@ViewScoped()
public class SubjectCardsBean extends Bean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Log log = LogFactory.getLog(SubjectCardsBean.class);
	
	private int id;
	
	private Przedmiot subject;
	
	private PrzedmiotService przedmiotService = null;
	
	public SubjectCardsBean() {
		log.debug("Initialiaze SubjectCardsBean");
	}
	
	@PostConstruct
	public void postConstructor() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
	    if (!facesContext.isPostback() && !facesContext.isValidationFailed()) {
	    	
	    	przedmiotService = (PrzedmiotService) 
					ApplicationContextProvider.getApplicationContext().getBean("przedmiotService");
	    }
	}
	
	public void initialiaze() {
		subject = przedmiotService.getPrzedmiot(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		
		initialiaze();
	}
	
	public String getSubjectName() {
		return "test";
	}

}
