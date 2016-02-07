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
import pl.edu.pwr.krk.models.entities.Celprzedmiotu;
import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;
import pl.edu.pwr.krk.models.entities.Kurs;
import pl.edu.pwr.krk.models.entities.Narzedziedydaktyczne;
import pl.edu.pwr.krk.models.entities.Ocenaosiagieciapek;
import pl.edu.pwr.krk.models.entities.Pozycjaliteraturowa;
import pl.edu.pwr.krk.models.entities.Programksztalcenia;
import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Przedmiotowyefektksztalcenia;
import pl.edu.pwr.krk.models.entities.Trescprogramowa;
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
	private Kartaprzedmiotu subjectCard;
	private List<Wymaganiawstepne> prerequisites;
	private List<Celprzedmiotu> objectives;
	private List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsKnowledge;
	private List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsSkills;
	private List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsReferences;
	private List<Trescprogramowa> programmeContents;
	private List<Narzedziedydaktyczne> teachingTools;
	private List<Pozycjaliteraturowa> basicLiterature;
	private List<Pozycjaliteraturowa> extendedLiterature;
	private List<Ocenaosiagieciapek> formingEvaluations;
	private List<Ocenaosiagieciapek> concludingEvaluations;
	
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

		String nazwa = subject.getModulksztalcenia().getProgramstudiow().getProgramksztalcenia().getKierunekstudiow()
				.getWydzial().getNazwa();

		subjectCard = new Kartaprzedmiotu();
		prerequisites = new ArrayList<>();
		prerequisites.add(new Wymaganiawstepne(new Kartaprzedmiotu(), (short)1, "wymaganie"));
		
		objectives = new ArrayList<>();
		objectives.add(new Celprzedmiotu(1, new Kartaprzedmiotu(), "numer", "opis"));
		
		subjectEducationalEffectsKnowledge = new ArrayList<>();
		subjectEducationalEffectsKnowledge.add(new Przedmiotowyefektksztalcenia(subjectCard, "zakres", "numer", "opis"));
		subjectEducationalEffectsSkills = new ArrayList<>();
		subjectEducationalEffectsSkills.add(new Przedmiotowyefektksztalcenia(subjectCard, "zakres", "numer", "opis"));
		subjectEducationalEffectsReferences = new ArrayList<>();
		subjectEducationalEffectsReferences.add(new Przedmiotowyefektksztalcenia(subjectCard, "zakres", "numer", "opis"));
		
		programmeContents = new ArrayList<>();
		programmeContents.add(new Trescprogramowa(subjectCard, (short)1, (short)2, "opis", (short)12));
		
		teachingTools = new ArrayList<>();
		teachingTools.add(new Narzedziedydaktyczne(subjectCard, new Kurs(), "numer", "opis"));
		
		basicLiterature= new ArrayList<>();
		basicLiterature.add(new Pozycjaliteraturowa(subjectCard, (short)1, "opis", "rodzaj"));
		extendedLiterature = new ArrayList<>();
		extendedLiterature.add(new Pozycjaliteraturowa(subjectCard, (short)1, "opis", "rodzaj"));
		
		formingEvaluations = new ArrayList<>();
		formingEvaluations.add(new Ocenaosiagieciapek(subjectCard, "rodzajOceny", "numer", "opis", "sposobOceny"));
		concludingEvaluations = new ArrayList<>();
		concludingEvaluations.add(new Ocenaosiagieciapek(subjectCard, "rodzajOceny", "numer", "opis", "sposobOceny"));
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

	public AddNewSubjectCardBean() {
		log.debug("Initialiaze AddNewSubjectCardBean");
	}
}
