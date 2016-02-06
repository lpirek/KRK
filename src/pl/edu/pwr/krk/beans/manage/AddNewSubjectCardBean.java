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

import pl.edu.pwr.krk.models.dao.WymaganiawstepneDAO;
import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;
import pl.edu.pwr.krk.models.entities.Programksztalcenia;
import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Uzytkownik;
import pl.edu.pwr.krk.models.entities.Wymaganiawstepne;
import pl.edu.pwr.krk.models.services.KartaprzedmiotuService;
import pl.edu.pwr.krk.models.services.PrzedmiotService;
import pl.edu.pwr.krk.models.services.WymaganiewstepneService;
import pl.edu.pwr.krk.tools.ApplicationContextProvider;

@ManagedBean
@ViewScoped()
public class AddNewSubjectCardBean extends Bean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(AddNewSubjectCardBean.class);

	private int id;
	private Przedmiot subject;
	private PrzedmiotService subjectService = null;

	private int tabIndex = 0;
	private String subjectCardLanguage;
	private List<Wymaganiawstepne> prerequisites;

	@PostConstruct
	public void postConstructor() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (!facesContext.isPostback() && !facesContext.isValidationFailed()) {
			subjectService = (PrzedmiotService) ApplicationContextProvider.getApplicationContext()
					.getBean("przedmiotService");
		}
	}

	public void initialiaze() {
		subject = subjectService.getPrzedmiot(id);
		prerequisites = new ArrayList<>();
	}

	public List<Wymaganiawstepne> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(List<Wymaganiawstepne> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getSubjectName() {
		return isPolish() ? subject.getNazwaPl() : subject.getNazwaEn();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

		initialiaze();
	}

	public Przedmiot getSubject() {
		return subject;
	}

	public void setSubject(Przedmiot subject) {
		this.subject = subject;
	}

	public String getSubjectCardLanguage() {
		return subjectCardLanguage;
	}

	public void setSubjectCardLanguage(String subjectCardLanguage) {
		this.subjectCardLanguage = subjectCardLanguage;
	}

	public int getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}

	public AddNewSubjectCardBean() {
		log.debug("Initialiaze AddNewSubjectCardBean");
	}
}
