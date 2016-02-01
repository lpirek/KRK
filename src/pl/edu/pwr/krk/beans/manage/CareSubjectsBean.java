package pl.edu.pwr.krk.beans.manage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Uzytkownik;

@ManagedBean
@ViewScoped()
public class CareSubjectsBean extends Bean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Log log = LogFactory.getLog(CareSubjectsBean.class);
	
	List<Przedmiot> subjects = null;
	
	public CareSubjectsBean() {
		log.debug("Initialiaze CareSubjectsBean");
	}
	
	@PostConstruct
	public void postConstructor() {
		initialiaze();
	}
	
	public void initialiaze() {
		Uzytkownik uzytkownik = getCurrentUser();
		
		subjects = new ArrayList<Przedmiot>(uzytkownik.getPrzedmiots());
	}
	
	public List<Przedmiot> getCareSubjectsByUser() {
		return subjects;
	}
	
	public String getName(Przedmiot przedmiot) {
		return "";
	}
	
	public String getDescription(Przedmiot przedmiot) {
		return "";
	}

}
