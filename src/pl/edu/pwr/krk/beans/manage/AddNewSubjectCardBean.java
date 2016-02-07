package pl.edu.pwr.krk.beans.manage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import pl.edu.pwr.krk.models.entities.Celprzedmiotu;
import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;
import pl.edu.pwr.krk.models.entities.Kurs;
import pl.edu.pwr.krk.models.entities.ManagePosition;
import pl.edu.pwr.krk.models.entities.Narzedziedydaktyczne;
import pl.edu.pwr.krk.models.entities.Ocenaosiagieciapek;
import pl.edu.pwr.krk.models.entities.Pozycjaliteraturowa;
import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Przedmiotowyefektksztalcenia;
import pl.edu.pwr.krk.models.entities.Trescprogramowa;
import pl.edu.pwr.krk.models.entities.Wymaganiawstepne;
import pl.edu.pwr.krk.models.services.PrzedmiotService;
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

	private static int tabIndex = 0;
	private static String subjectCardLanguage;
	private static Kartaprzedmiotu subjectCard = new Kartaprzedmiotu();
	private static List<Wymaganiawstepne> prerequisites = new ArrayList<>();
	private static List<Celprzedmiotu> objectives = new ArrayList<>();
	private static List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsKnowledge = new ArrayList<>();
	private static List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsSkills = new ArrayList<>();
	private static List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsReferences = new ArrayList<>();
	private static List<Trescprogramowa> programmeContents = new ArrayList<>();;
	private static List<Narzedziedydaktyczne> teachingTools = new ArrayList<>();;
	private static List<Pozycjaliteraturowa> basicLiterature = new ArrayList<>();
	private static List<Pozycjaliteraturowa> extendedLiterature = new ArrayList<>();
	private static List<Ocenaosiagieciapek> formingEvaluations = new ArrayList<>();
	private static List<Ocenaosiagieciapek> concludingEvaluations = new ArrayList<>();

	private Wymaganiawstepne selectedPrerequisite;
	
	public AddNewSubjectCardBean() {
		log.debug("Initialiaze AddNewSubjectCardBean");
	}

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
	}

	public List<Ocenaosiagieciapek> getFormingEvaluations() {
		return formingEvaluations;
	}

	public void setFormingEvaluations(List<Ocenaosiagieciapek> formingEvaluations) {
		this.formingEvaluations = formingEvaluations;
	}

	public List<Ocenaosiagieciapek> getConcludingEvaluations() {
		return concludingEvaluations;
	}

	public void setConcludingEvaluations(List<Ocenaosiagieciapek> concludingEvaluations) {
		this.concludingEvaluations = concludingEvaluations;
	}

	public List<Pozycjaliteraturowa> getBasicLiterature() {
		return basicLiterature;
	}

	public void setBasicLiterature(List<Pozycjaliteraturowa> basicLiterature) {
		this.basicLiterature = basicLiterature;
	}

	public List<Pozycjaliteraturowa> getExtendedLiterature() {
		return extendedLiterature;
	}

	public void setExtendedLiterature(List<Pozycjaliteraturowa> extendedLiterature) {
		this.extendedLiterature = extendedLiterature;
	}

	public List<Narzedziedydaktyczne> getTeachingTools() {
		return teachingTools;
	}

	public void setTeachingTools(List<Narzedziedydaktyczne> teachingTools) {
		this.teachingTools = teachingTools;
	}

	public List<Przedmiotowyefektksztalcenia> getSubjectEducationalEffectsKnowledge() {
		return subjectEducationalEffectsKnowledge;
	}

	public void setSubjectEducationalEffectsKnowledge(
			List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsKnowledge) {
		this.subjectEducationalEffectsKnowledge = subjectEducationalEffectsKnowledge;
	}

	public List<Przedmiotowyefektksztalcenia> getSubjectEducationalEffectsSkills() {
		return subjectEducationalEffectsSkills;
	}

	public void setSubjectEducationalEffectsSkills(List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsSkills) {
		this.subjectEducationalEffectsSkills = subjectEducationalEffectsSkills;
	}

	public List<Przedmiotowyefektksztalcenia> getSubjectEducationalEffectsReferences() {
		return subjectEducationalEffectsReferences;
	}

	public void setSubjectEducationalEffectsReferences(
			List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsReferences) {
		this.subjectEducationalEffectsReferences = subjectEducationalEffectsReferences;
	}

	public List<Trescprogramowa> getProgrammeContents() {
		return programmeContents;
	}

	public void setProgrammeContents(List<Trescprogramowa> programmeContents) {
		this.programmeContents = programmeContents;
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

	public List<Celprzedmiotu> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<Celprzedmiotu> objectives) {
		this.objectives = objectives;
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
	
	/**
	 * Obsługa okien dialogowych dla Wymagan Wstępnych
	 */
	
	public Wymaganiawstepne getSelectedPrerequisite() {
		return selectedPrerequisite;
	}
	
	public void setSelectedPrerequisite(Wymaganiawstepne selectedPrerequisite) {
		this.selectedPrerequisite = selectedPrerequisite;
	}
	
	public void preAddPrerequisite() {
		this.selectedPrerequisite = new Wymaganiawstepne();
	}
	
	public void preEditPrerequisite(Wymaganiawstepne prerequiste) {
		this.selectedPrerequisite = prerequiste;
	}
	
	public void preRemovePrerequisite(Wymaganiawstepne prerequiste) {
		this.selectedPrerequisite = prerequiste;
	}
	
	public void savePrerequisteClick() {
		
		if (selectedPrerequisite != null) {
			
			prerequisites.remove(selectedPrerequisite);
			
			if (selectedPrerequisite.getId() == null 
					|| selectedPrerequisite.getId() == 0) {
				//Add
				selectedPrerequisite.setKartaprzedmiotu(subjectCard);
				selectedPrerequisite.setPozycja((short)(prerequisites.size() + 1));
				prerequisites.add(selectedPrerequisite);
			}
			else {
				//Edit
				prerequisites.add(selectedPrerequisite.getPozycja() - 1, selectedPrerequisite);
			}
			
			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie zapisano zmiany");
			
			selectedPrerequisite = null;
		}
	}
	
	public void removePrerequisteClick() {
		
		if (selectedPrerequisite != null) {
			this.prerequisites.remove(selectedPrerequisite);
			correctPositions(prerequisites);

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie usunięto");
		
			selectedPrerequisite = null;
		}
	}

	private void correctPositions(List<Wymaganiawstepne> list) {
		for (int i=0; i < list.size(); i++) {
			list.get(i).setPozycja((short)(i+1));
		}
	}
	
	public void upPrerequisitePosition(Wymaganiawstepne prerequiste) {
		changePostionTo(prerequiste, prerequiste.getPozycja() - 1);
	}
	
	public void downPrerequisitePosition(Wymaganiawstepne prerequiste) {
		changePostionTo(prerequiste, prerequiste.getPozycja() + 1);
	}
	
	public void changePostionTo(Wymaganiawstepne prerequiste, int newPosition) {
		if (newPosition > 0 && newPosition < prerequisites.size())
		{
			prerequisites.remove(prerequiste);
			prerequisites.add(newPosition - 1, prerequiste);
			correctPositions(prerequisites);
		}
	}
	
	/**
	 * 
	 */
	
	
}
