package pl.edu.pwr.krk.beans.manage;

import java.io.Serializable;
import java.text.NumberFormat;
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

	private int elementIndex;
	private Wymaganiawstepne selectedPrerequisite;
	private Celprzedmiotu selectedObjective;
	private Przedmiotowyefektksztalcenia selectedSEE;
	private Trescprogramowa selectedProgrammeCotent;
	private Narzedziedydaktyczne selectedTeachingTool;
	private Pozycjaliteraturowa selectedLiterature;
	private Ocenaosiagieciapek selectedEvaluation;

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

	public Celprzedmiotu getSelectedObjective() {
		return selectedObjective;
	}

	public void setSelectedObjective(Celprzedmiotu selectedObjective) {
		this.selectedObjective = selectedObjective;
	}

	public void preAddObjective() {
		this.selectedObjective = new Celprzedmiotu();
		StringBuffer sb = new StringBuffer();
		sb.append("C");
		sb.append(objectives.size() + 1);
		this.selectedObjective.setNumer(sb.toString());
	}

	public void preEditObjective(Celprzedmiotu objective) {
		this.selectedObjective = objective;
		elementIndex = objectives.lastIndexOf(objective);
	}

	public void preRemoveObjective(Celprzedmiotu objective) {
		this.selectedObjective = objective;
	}

	public Przedmiotowyefektksztalcenia getSelectedSEE() {
		return selectedSEE;
	}

	public void setSelectedSEE(Przedmiotowyefektksztalcenia selectedSEE) {
		this.selectedSEE = selectedSEE;
	}

	public void preAddSEE(String type) {
		this.selectedSEE = new Przedmiotowyefektksztalcenia();
		if (type.equals("knowledge")) {
			StringBuffer sb = new StringBuffer();
			int number = (subjectEducationalEffectsKnowledge.size() + 1);
			sb.append("PEK_W");
			sb.append(String.format("%02d", number));
			this.selectedSEE.setNumer(sb.toString());

		} else if (type.equals("skill")) {
			StringBuffer sb = new StringBuffer();
			int number = (subjectEducationalEffectsSkills.size() + 1);
			sb.append("PEK_U");
			sb.append(String.format("%02d", number));
			this.selectedSEE.setNumer(sb.toString());
		} else {
			StringBuffer sb = new StringBuffer();
			int number = (subjectEducationalEffectsReferences.size() + 1);
			sb.append("PEK_K");
			sb.append(String.format("%02d", number));
			this.selectedSEE.setNumer(sb.toString());
		}
	}

	public void preEditSEE(Przedmiotowyefektksztalcenia see) {
		this.selectedSEE = see;
		if (see.getNumer().startsWith("PEK_W")) {
			elementIndex = subjectEducationalEffectsKnowledge.lastIndexOf(see);
		} else if (see.getNumer().startsWith("PEK_U")) {
			elementIndex = subjectEducationalEffectsSkills.lastIndexOf(see);
		} else {
			elementIndex = subjectEducationalEffectsReferences.lastIndexOf(see);
		}
	}

	public void preRemoveSEE(Przedmiotowyefektksztalcenia see) {
		this.selectedSEE = see;
	}

	public Trescprogramowa getSelectedProgrammeCotent() {
		return selectedProgrammeCotent;
	}

	public void setSelectedProgrammeCotent(Trescprogramowa selectedProgrammeCotent) {
		this.selectedProgrammeCotent = selectedProgrammeCotent;
	}

	public void preAddProgrammeCotent() {
		this.selectedProgrammeCotent = new Trescprogramowa();
	}

	public void preEditProgrammeCotent(Trescprogramowa programmeContent) {
		this.selectedProgrammeCotent = programmeContent;
	}

	public void preRemoveProgrammeCotent(Trescprogramowa programmeContent) {
		this.selectedProgrammeCotent = programmeContent;
	}

	public Narzedziedydaktyczne getSelectedTeachingTool() {
		return selectedTeachingTool;
	}

	public void setSelectedTeachingTool(Narzedziedydaktyczne selectedTeachingTool) {
		this.selectedTeachingTool = selectedTeachingTool;
	}

	public void preAddTeachingTool() {
		this.selectedTeachingTool = new Narzedziedydaktyczne();
		StringBuffer sb = new StringBuffer();
		sb.append("N");
		sb.append(teachingTools.size() + 1);
		this.selectedTeachingTool.setNumer(sb.toString());
	}

	public void preEditTeachingTool(Narzedziedydaktyczne teachingTool) {
		this.selectedTeachingTool = teachingTool;
		elementIndex = teachingTools.lastIndexOf(teachingTool);
	}

	public void preRemoveTeachingTool(Narzedziedydaktyczne teachingTool) {
		this.selectedTeachingTool = teachingTool;
	}

	public Pozycjaliteraturowa getSelectedLiterature() {
		return selectedLiterature;
	}

	public void setSelectedLiterature(Pozycjaliteraturowa selectedLiterature) {
		this.selectedLiterature = selectedLiterature;
	}

	public void preAddLiterature(String type) {
		this.selectedLiterature = new Pozycjaliteraturowa();
		if (type.equals("basic")) {
			this.selectedLiterature.setRodzaj("podstawowa");
		} else {
			this.selectedLiterature.setRodzaj("uzupełniająca");
		}
	}

	public void preEditLiterature(Pozycjaliteraturowa literature) {
		this.selectedLiterature = literature;
	}

	public void preRemoveLiterature(Pozycjaliteraturowa literature) {
		this.selectedLiterature = literature;
	}

	public Ocenaosiagieciapek getSelectedEvaluation() {
		return selectedEvaluation;
	}

	public void setSelectedEvaluation(Ocenaosiagieciapek selectedEvaluation) {
		this.selectedEvaluation = selectedEvaluation;
	}

	public void preAddEvaluation(String type) {
		this.selectedEvaluation = new Ocenaosiagieciapek();
		if (type.equals("forming")) {
			StringBuffer sb = new StringBuffer();
			sb.append("F");
			sb.append(formingEvaluations.size() + 1);
			this.selectedEvaluation.setNumer(sb.toString());
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("P");
			sb.append(concludingEvaluations.size() + 1);
			this.selectedEvaluation.setNumer(sb.toString());
		}
	}

	public void preEditEvaluation(Ocenaosiagieciapek evaluation) {
		this.selectedEvaluation = evaluation;
		if (this.selectedEvaluation.getNumer().startsWith("F")) {
			elementIndex = formingEvaluations.lastIndexOf(evaluation);
		} else {
			elementIndex = concludingEvaluations.lastIndexOf(evaluation);
		}
	}

	public void preRemoveEvaluation(Ocenaosiagieciapek evaluation) {
		this.selectedEvaluation = evaluation;
	}

	public void savePrerequisteClick() {

		if (selectedPrerequisite != null) {

			prerequisites.remove(selectedPrerequisite);

			if (selectedPrerequisite.getId() == null || selectedPrerequisite.getId() == 0) {
				// Add
				selectedPrerequisite.setKartaprzedmiotu(subjectCard);
				selectedPrerequisite.setPozycja((short) (prerequisites.size() + 1));
				selectedPrerequisite.setId(prerequisites.size() + 1);
				prerequisites.add(selectedPrerequisite);
			} else {
				// Edit
				prerequisites.add(selectedPrerequisite.getPozycja() - 1, selectedPrerequisite);
			}

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie zapisano zmiany");

			selectedPrerequisite = null;
		}
	}

	public void removePrerequisteClick() {

		if (selectedPrerequisite != null) {
			this.prerequisites.remove(selectedPrerequisite);
			correctPrerequisitePositions(prerequisites);

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie usunięto");

			selectedPrerequisite = null;
		}
	}

	private void correctPrerequisitePositions(List<Wymaganiawstepne> list) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setPozycja((short) (i + 1));
		}
	}

	public void upPrerequisitePosition(Wymaganiawstepne prerequiste) {
		changePrerequisitePostionTo(prerequiste, prerequiste.getPozycja() - 1);
	}

	public void downPrerequisitePosition(Wymaganiawstepne prerequiste) {
		changePrerequisitePostionTo(prerequiste, prerequiste.getPozycja() + 1);
	}

	public void changePrerequisitePostionTo(Wymaganiawstepne prerequiste, int newPosition) {
		if (newPosition > 0 && newPosition <= prerequisites.size()) {
			prerequisites.remove(prerequiste);
			prerequisites.add(newPosition - 1, prerequiste);
			correctPrerequisitePositions(prerequisites);
		}
	}

	public void saveObjectiveClick() {

		if (selectedObjective != null) {

			objectives.remove(selectedObjective);

			if (selectedObjective.getId() == 0) {
				// Add
				selectedObjective.setKartaprzedmiotu(subjectCard);
				selectedObjective.setId(objectives.size() + 1);
				objectives.add(selectedObjective);
			} else {
				// Edit
				objectives.add(elementIndex, selectedObjective);
			}

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie zapisano zmiany");

			elementIndex = -1;
			selectedObjective = null;
		}
	}

	public void removeObjectiveClick() {

		if (selectedObjective != null) {
			this.objectives.remove(selectedObjective);
			correctObjectiveNumbers(objectives);

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie usunięto");

			elementIndex = -1;
			selectedObjective = null;
		}
	}

	private void correctObjectiveNumbers(List<Celprzedmiotu> list) {
		for (int i = 0; i < list.size(); i++) {
			StringBuffer sb = new StringBuffer();
			sb.append("C");
			sb.append(i + 1);
			list.get(i).setNumer(sb.toString());
		}
	}

	public void saveSEEClick() {

		if (selectedSEE != null) {

			if (selectedSEE.getNumer().startsWith("PEK_W")) {
				subjectEducationalEffectsKnowledge.remove(selectedSEE);
			} else if (selectedSEE.getNumer().startsWith("PEK_U")) {
				subjectEducationalEffectsSkills.remove(selectedSEE);
			} else {
				subjectEducationalEffectsReferences.remove(selectedSEE);
			}

			if (selectedSEE.getId() == null || selectedSEE.getId() == 0) {
				// Add
				if (selectedSEE.getNumer().startsWith("PEK_W")) {
					selectedSEE.setKartaprzedmiotu(subjectCard);
					selectedSEE.setId(subjectEducationalEffectsKnowledge.size() + 1);
					subjectEducationalEffectsKnowledge.add(selectedSEE);
				} else if (selectedSEE.getNumer().startsWith("PEK_U")) {
					selectedSEE.setKartaprzedmiotu(subjectCard);
					selectedSEE.setId(subjectEducationalEffectsSkills.size() + 1);
					subjectEducationalEffectsSkills.add(selectedSEE);
				} else {
					selectedSEE.setKartaprzedmiotu(subjectCard);
					selectedSEE.setId(subjectEducationalEffectsReferences.size() + 1);
					subjectEducationalEffectsReferences.add(selectedSEE);
				}

			} else {
				// Edit
				if (selectedSEE.getNumer().startsWith("PEK_W")) {
					subjectEducationalEffectsKnowledge.add(elementIndex, selectedSEE);
				} else if (selectedSEE.getNumer().startsWith("PEK_U")) {
					subjectEducationalEffectsSkills.add(elementIndex, selectedSEE);
				} else {
					subjectEducationalEffectsReferences.add(elementIndex, selectedSEE);
				}
				;
			}

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie zapisano zmiany");

			elementIndex = -1;
			selectedSEE = null;
		}
	}

	public void removeSEEClick() {

		if (selectedSEE != null) {
			if (selectedSEE.getNumer().startsWith("PEK_W")) {
				subjectEducationalEffectsKnowledge.remove(selectedSEE);
				correctSEENumbers(subjectEducationalEffectsKnowledge);
			} else if (selectedSEE.getNumer().startsWith("PEK_U")) {
				subjectEducationalEffectsSkills.remove(selectedSEE);
				correctSEENumbers(subjectEducationalEffectsSkills);
			} else {
				subjectEducationalEffectsReferences.remove(selectedSEE);
				correctSEENumbers(subjectEducationalEffectsReferences);
			}
			;

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie usunięto");

			elementIndex = -1;
			selectedSEE = null;
		}
	}

	private void correctSEENumbers(List<Przedmiotowyefektksztalcenia> list) {
		for (int i = 0; i < list.size(); i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(list.get(i).getNumer().substring(0, 5));
			sb.append(String.format("%d02", i + 1 ));
			list.get(i).setNumer(sb.toString());
		}
	}

	public void saveTeachingToolClick() {

		if (selectedTeachingTool != null) {

			teachingTools.remove(selectedTeachingTool);

			if (selectedTeachingTool.getId() == null || selectedTeachingTool.getId() == 0) {
				// Add
				selectedTeachingTool.setKartaprzedmiotu(subjectCard);
				selectedTeachingTool.setId(teachingTools.size() + 1);
				teachingTools.add(selectedTeachingTool);
			} else {
				// Edit
				teachingTools.add(elementIndex, selectedTeachingTool);
			}

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie zapisano zmiany");

			elementIndex = -1;
			selectedTeachingTool = null;
		}
	}

	public void removeTeachingToolClick() {

		if (selectedTeachingTool != null) {
			teachingTools.remove(selectedTeachingTool);
			correctTeachingToolNumbers(teachingTools);

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie usunięto");

			elementIndex = -1;
			selectedTeachingTool = null;
		}
	}

	private void correctTeachingToolNumbers(List<Narzedziedydaktyczne> list) {
		for (int i = 0; i < list.size(); i++) {
			StringBuffer sb = new StringBuffer();
			sb.append("N");
			sb.append(i + 1);
			list.get(i).setNumer(sb.toString());
		}
	}

	public void saveLiteratureClick() {

		if (selectedLiterature != null) {

			if (selectedLiterature.getRodzaj().equals("podstawowa")) {
				basicLiterature.remove(selectedLiterature);
			} else {
				extendedLiterature.remove(selectedLiterature);
			}

			if (selectedLiterature.getId() == null || selectedLiterature.getId() == 0) {
				// Add
				selectedLiterature.setKartaprzedmiotu(subjectCard);
				if (selectedLiterature.getRodzaj().equals("podstawowa")) {
					selectedLiterature.setPozycja((short) (basicLiterature.size() + 1));
					selectedLiterature.setId(basicLiterature.size() + 1);
					basicLiterature.add(selectedLiterature);
				} else {
					selectedLiterature.setPozycja((short) (extendedLiterature.size() + 1));
					selectedLiterature.setId(extendedLiterature.size() + 1);
					extendedLiterature.add(selectedLiterature);
				}
			} else {
				// Edit
				if (selectedLiterature.getRodzaj().equals("podstawowa")) {
					basicLiterature.add(selectedLiterature.getPozycja() - 1, selectedLiterature);
				} else {
					extendedLiterature.add(selectedLiterature.getPozycja() - 1, selectedLiterature);
				}
			}

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie zapisano zmiany");

			elementIndex = -1;
			selectedLiterature = null;
		}
	}

	public void removeLiteratureClick() {

		if (selectedLiterature != null) {

			if (selectedLiterature.getRodzaj().equals("podstawowa")) {
				basicLiterature.remove(selectedLiterature);
				correctLiteraturePositions(basicLiterature);
			} else {
				extendedLiterature.remove(selectedLiterature);
				correctLiteraturePositions(extendedLiterature);
			}

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie usunięto");

			elementIndex = -1;
			selectedLiterature = null;
		}
	}

	private void correctLiteraturePositions(List<Pozycjaliteraturowa> list) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setPozycja((short) (i + 1));
		}
	}

	public void upLiteraturePosition(Pozycjaliteraturowa literature) {
		changeLiteraturePostionTo(literature, literature.getPozycja() - 1);
	}

	public void downLiteraturePosition(Pozycjaliteraturowa literature) {
		changeLiteraturePostionTo(literature, literature.getPozycja() + 1);
	}

	public void changeLiteraturePostionTo(Pozycjaliteraturowa literature, int newPosition) {
		if (literature.getRodzaj().equals("podstawowa")) {
			if (newPosition > 0 && newPosition <= basicLiterature.size()) {
				basicLiterature.remove(literature);
				basicLiterature.add(newPosition - 1, literature);
				correctLiteraturePositions(basicLiterature);
			}
		} else {
			if (newPosition > 0 && newPosition <= extendedLiterature.size()) {
				extendedLiterature.remove(literature);
				extendedLiterature.add(newPosition - 1, literature);
				correctLiteraturePositions(extendedLiterature);
			}
		}
	}

	public void saveEvaluationClick() {

		if (selectedEvaluation != null) {

			if (this.selectedEvaluation.getNumer().startsWith("F")) {
				formingEvaluations.remove(selectedEvaluation);
			} else {
				concludingEvaluations.remove(selectedEvaluation);
			}

			if (selectedEvaluation.getId() == null || selectedEvaluation.getId() == 0) {
				// Add
				if (this.selectedEvaluation.getNumer().startsWith("F")) {
					selectedEvaluation.setKartaprzedmiotu(subjectCard);
					selectedEvaluation.setId(formingEvaluations.size() + 1);
					formingEvaluations.add(selectedEvaluation);
				} else {
					selectedEvaluation.setKartaprzedmiotu(subjectCard);
					selectedEvaluation.setId(concludingEvaluations.size() + 1);
					concludingEvaluations.add(selectedEvaluation);
				}
			} else {
				// Edit
				if (this.selectedEvaluation.getNumer().startsWith("F")) {
					formingEvaluations.add(elementIndex, selectedEvaluation);
				} else {
					concludingEvaluations.add(elementIndex, selectedEvaluation);
				}

			}

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie zapisano zmiany");

			elementIndex = -1;
			selectedEvaluation = null;
		}
	}

	public void removeEvaluationClick() {

		if (selectedEvaluation != null) {
			if (this.selectedEvaluation.getNumer().startsWith("F")) {
				formingEvaluations.remove(selectedEvaluation);
				correctEvaluationNumbers(formingEvaluations);
			} else {
				concludingEvaluations.remove(selectedEvaluation);
				correctEvaluationNumbers(concludingEvaluations);
			}

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie usunięto");

			elementIndex = -1;
			selectedEvaluation = null;
		}
	}

	private void correctEvaluationNumbers(List<Ocenaosiagieciapek> list) {
		for (int i = 0; i < list.size(); i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(list.get(i).getNumer().substring(0, 1));
			sb.append(i + 1);
			list.get(i).setNumer(sb.toString());
		}
	}
	/**
	 * 
	 */

}
