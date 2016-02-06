package pl.edu.pwr.krk.beans.manage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.StreamedContent;

import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;
import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Uzytkownik;
import pl.edu.pwr.krk.models.services.KartaprzedmiotuService;
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
	private List<Kartaprzedmiotu> subjectCards = null;
	
	
	private PrzedmiotService przedmiotService = null;
	private KartaprzedmiotuService kartaPrzedmiotuService = null;
	
	public SubjectCardsBean() {
		log.debug("Initialiaze SubjectCardsBean");
	}
	
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
		subject = przedmiotService.getPrzedmiot(id);
		subjectCards = kartaPrzedmiotuService.getKartyPrzedmiotu(id);
	}
	
	public void addNewCard() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().
			redirect("addNewSubjectCard.xhtml?id=" + id);
	}
	
	public void verifyCard(Kartaprzedmiotu card) throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().
			redirect("verifySubjectCard.xhtml?id=" + card.getId());
	}
	
	public StreamedContent downloadCard(Kartaprzedmiotu card) {
		
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		
		initialiaze();
	}
	
	public String getSubjectName() {
		return isPolish() ? subject.getNazwaPl() : subject.getNazwaEn();
	}

	public Przedmiot getSubject() {
		return subject;
	}

	public void setSubject(Przedmiot subject) {
		this.subject = subject;
	}

	public List<Kartaprzedmiotu> getSubjectCards() {
		return subjectCards;
	}

	public void setSubjectCards(List<Kartaprzedmiotu> subjectCards) {
		this.subjectCards = subjectCards;
	}

}
