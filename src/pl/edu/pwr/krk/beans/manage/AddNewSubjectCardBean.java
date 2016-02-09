package pl.edu.pwr.krk.beans.manage;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.sun.org.apache.xml.internal.security.keys.content.KeyValue;

import pl.edu.pwr.krk.models.entities.Celprzedmiotu;
import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;
import pl.edu.pwr.krk.models.entities.Kekpek;
import pl.edu.pwr.krk.models.entities.Kierunkowyefektksztalcenia;
import pl.edu.pwr.krk.models.entities.Kurs;
import pl.edu.pwr.krk.models.entities.Narzedziedydaktyczne;
import pl.edu.pwr.krk.models.entities.Ocenaosiagieciapek;
import pl.edu.pwr.krk.models.entities.Pekcelprzedmiotu;
import pl.edu.pwr.krk.models.entities.Peknarzedziedydaktyczne;
import pl.edu.pwr.krk.models.entities.Pekocenaosiagnieciapek;
import pl.edu.pwr.krk.models.entities.Pektrescprogramowa;
import pl.edu.pwr.krk.models.entities.Pozycjaliteraturowa;
import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Przedmiotowyefektksztalcenia;
import pl.edu.pwr.krk.models.entities.Trescprogramowa;
import pl.edu.pwr.krk.models.entities.Wymaganiawstepne;
import pl.edu.pwr.krk.models.services.KartaprzedmiotuService;
import pl.edu.pwr.krk.models.services.KierunkowyefektksztalceniaService;
import pl.edu.pwr.krk.models.services.PrzedmiotService;
import pl.edu.pwr.krk.tools.ApplicationContextProvider;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

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
	private KartaprzedmiotuService subjectCardService = null;
	private KierunkowyefektksztalceniaService feeService = null;

	private static int tabIndex = 0;
	private int elementIndex;

	private static Kartaprzedmiotu subjectCard;

	private static List<Wymaganiawstepne> prerequisites = new ArrayList<>();
	private static List<Celprzedmiotu> objectives = new ArrayList<>();
	private static List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsKnowledge = new ArrayList<>();
	private static List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsSkills = new ArrayList<>();
	private static List<Przedmiotowyefektksztalcenia> subjectEducationalEffectsReferences = new ArrayList<>();
	private static List<Narzedziedydaktyczne> teachingTools = new ArrayList<>();
	private static List<Pozycjaliteraturowa> basicLiterature = new ArrayList<>();
	private static List<Pozycjaliteraturowa> extendedLiterature = new ArrayList<>();
	private static List<Ocenaosiagieciapek> formingEvaluations = new ArrayList<>();
	private static List<Ocenaosiagieciapek> concludingEvaluations = new ArrayList<>();

	private Wymaganiawstepne selectedPrerequisite;
	private Celprzedmiotu selectedObjective;
	private Przedmiotowyefektksztalcenia selectedSEE;
	private Trescprogramowa selectedProgrammeContent;
	private Narzedziedydaktyczne selectedTeachingTool;
	private Pozycjaliteraturowa selectedLiterature;
	private Ocenaosiagieciapek selectedEvaluation;
	private Kurs selectedKurs;

	private List<String> selectedSEEs;

	private static Map<Integer, List<Trescprogramowa>> programmeContents = new HashMap<Integer, List<Trescprogramowa>>();

	private Przedmiotowyefektksztalcenia expandedSEE;

	private List<String> selectedFEEs;
	private List<String> selectedObjectives;
	private List<String> selectedTools;
	private List<String> selectedProgrammeContents;

	private List<Kierunkowyefektksztalcenia> fees;

	public AddNewSubjectCardBean() {
		log.debug("Initialiaze AddNewSubjectCardBean");
	}

	@PostConstruct
	public void postConstructor() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (!facesContext.isPostback() && !facesContext.isValidationFailed()) {
			subjectService = (PrzedmiotService) ApplicationContextProvider.getApplicationContext()
					.getBean("przedmiotService");
			subjectCardService = (KartaprzedmiotuService) ApplicationContextProvider.getApplicationContext()
					.getBean("kartaprzedmiotuService");
			feeService = (KierunkowyefektksztalceniaService) ApplicationContextProvider.getApplicationContext()
					.getBean("kekService");
		}
	}

	public void initialiaze() {
		subject = subjectService.getPrzedmiot(id);
		fees = feeService.getFEEs();

		subjectCard = new Kartaprzedmiotu();

		// SelectOneMenu wymaga instancji obiektu już podczas inicjalizacji
		selectedProgrammeContent = new Trescprogramowa();

		setDefaultLang();
	}

	public void setDefaultLang() {
		if (isPolish()) {
			subjectCard.setJezyk(Kartaprzedmiotu.JEZYK_PL);
		} else {
			subjectCard.setJezyk(Kartaprzedmiotu.JEZYK_EN);
		}
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

	public String getProgrammeContentTabTitle(Kurs kurs) {
		return MessageFormat.format("{0} - {1} (ZZU - {2})",
				this.getMessage("newSubjectCard.programmeContentTitle.formOfClasses"), kurs.getFormaZajec(),
				kurs.getZzu());
	}

	/**
	 * Nawigacja
	 */

	public void cancelNewCard() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("subjectCards.xhtml?id=" + id);
	}

	public void saveNewCard() throws IOException {
		subjectCard.setStatus("wersja robocza"); 
		storeSubjectCard();

		FacesContext.getCurrentInstance().getExternalContext().redirect("subjectCards.xhtml?id=" + id);
	}

	public void confirmNewCard() throws IOException {
		subjectCard.setStatus("wersja zatwierdzona");
		storeSubjectCard();
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("subjectCards.xhtml?id=" + id);
	}

	private void storeSubjectCard() {
		//addNewSubjectCardBean.subject.modulksztalcenia.programstudiow.programksztalcenia.kierunekstudiow.wydzial.nazwa
		subjectCard.setCelprzedmiotus(new HashSet<>(objectives));
		subjectCard.setDataUtworzenia(new Date());
		subjectCard.setFormaStudiow(subject.getModulksztalcenia().getProgramstudiow().getProgramksztalcenia().getFormaStudiow());
		subjectCard.setKierunekStudiow(subject.getModulksztalcenia().getProgramstudiow().getProgramksztalcenia().getKierunekstudiow().getNazwa());
		subjectCard.setNarzedziedydaktycznes(new HashSet<>(teachingTools));
		subjectCard.setNazwa(getSubjectName());
		subjectCard.setWymaganiawstepnes(new HashSet<>(prerequisites));
		subjectCard.setPrzedmiot(subject);
		subjectCard.setStopienStudiow(subject.getModulksztalcenia().getProgramstudiow().getProgramksztalcenia().getStopienStudiow());
		subjectCard.setWersja((short)0);
		
		Set<Ocenaosiagieciapek> evalTemp = new HashSet<>(formingEvaluations);
		evalTemp.addAll(concludingEvaluations);
		subjectCard.setOcenaosiagieciapeks(evalTemp);
		Set<Przedmiotowyefektksztalcenia> seeTemp = new HashSet<>(subjectEducationalEffectsKnowledge);
		seeTemp.addAll(subjectEducationalEffectsSkills);
		seeTemp.addAll(subjectEducationalEffectsReferences);
		subjectCard.setPrzedmiotowyefektksztalcenias(seeTemp);
		Set<Pozycjaliteraturowa> litTemp = new HashSet<>(basicLiterature);
		litTemp.addAll(extendedLiterature);		
		subjectCard.setPozycjaliteraturowas(litTemp);

		Set<Trescprogramowa> progTemp = new HashSet<>();
		for( Integer pcKey : programmeContents.keySet() )
		{
			progTemp.addAll( programmeContents.get(pcKey));
		}
		subjectCard.setTrescprogramowas(progTemp);

		subjectCardService.saveOrUpdate(subjectCard);
	}

	/**
	 * 
	 */

	public List<Ocenaosiagieciapek> getFormingEvaluations() {
		return formingEvaluations;
	}

	public List<Ocenaosiagieciapek> getConcludingEvaluations() {
		return concludingEvaluations;
	}

	public List<Pozycjaliteraturowa> getBasicLiterature() {
		return basicLiterature;
	}

	public List<Pozycjaliteraturowa> getExtendedLiterature() {
		return extendedLiterature;
	}

	public List<Narzedziedydaktyczne> getTeachingTools() {
		return teachingTools;
	}

	public List<Kierunkowyefektksztalcenia> getFacultatyEducationalEffects() {
		return fees;
	}

	public List<Przedmiotowyefektksztalcenia> getSubjectEducationalEffectsKnowledge() {
		return subjectEducationalEffectsKnowledge;
	}

	public List<Przedmiotowyefektksztalcenia> getSubjectEducationalEffectsSkills() {
		return subjectEducationalEffectsSkills;
	}

	public List<Przedmiotowyefektksztalcenia> getSubjectEducationalEffectsReferences() {
		return subjectEducationalEffectsReferences;
	}

	public List<Przedmiotowyefektksztalcenia> getSubjectEducationalEffects() {
		List<Przedmiotowyefektksztalcenia> result = new ArrayList<Przedmiotowyefektksztalcenia>();

		if (subjectEducationalEffectsKnowledge != null) {
			result.addAll(subjectEducationalEffectsKnowledge);
		}

		if (subjectEducationalEffectsSkills != null) {
			result.addAll(subjectEducationalEffectsSkills);
		}

		if (subjectEducationalEffectsReferences != null) {
			result.addAll(subjectEducationalEffectsReferences);
		}

		return result;
	}

	private Przedmiotowyefektksztalcenia getSEE(String number) {

		List<Przedmiotowyefektksztalcenia> result = getSubjectEducationalEffects();

		for (Przedmiotowyefektksztalcenia pek : result) {
			if (pek.getNumer().equals(number)) {
				return pek;
			}
		}

		return null;
	}

	private Kierunkowyefektksztalcenia getFEE(String number) {

		for (Kierunkowyefektksztalcenia kek : this.getFacultatyEducationalEffects()) {
			if (kek.getNumer().equals(number)) {
				return kek;
			}
		}

		return null;
	}

	private Celprzedmiotu getObjective(String number) {

		for (Celprzedmiotu cel : this.getObjectives()) {
			if (cel.getNumer().equals(number)) {
				return cel;
			}
		}

		return null;
	}

	private Narzedziedydaktyczne getTool(String number) {

		for (Narzedziedydaktyczne tool : this.getTeachingTools()) {
			if (tool.getNumer().equals(number)) {
				return tool;
			}
		}

		return null;
	}

	private Trescprogramowa getProgrammeContent(String number) {

		for (Trescprogramowa pc : this.getProgrammeContents()) {
			if (pc.getNumer().equals(number)) {
				return pc;
			}
		}

		return null;
	}

	public List<Trescprogramowa> getProgrammeContents(Kurs kurs) {

		if (kurs != null && kurs.getId() != null) {

			List<Trescprogramowa> list = programmeContents.get(kurs.getId());

			if (list == null) {
				list = new ArrayList<Trescprogramowa>();
				programmeContents.put(kurs.getId(), list);
			}

			return list;
		}

		return null;
	}

	public List<Trescprogramowa> getProgrammeContents() {

		List<Trescprogramowa> result = new ArrayList<Trescprogramowa>();

		for (List<Trescprogramowa> list : programmeContents.values()) {
			result.addAll(list);
		}

		return result;
	}

	public List<Wymaganiawstepne> getPrerequisites() {
		return prerequisites;
	}

	public List<Celprzedmiotu> getObjectives() {
		return objectives;
	}

	public Przedmiot getSubject() {
		return subject;
	}

	public void setSubject(Przedmiot subject) {
		this.subject = subject;
	}

	public Kartaprzedmiotu getSubjectCard() {
		return subjectCard;
	}

	public void setSubjectCard(Kartaprzedmiotu subjectCard) {
		this.subjectCard = subjectCard;
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

	/*
	 * 
	 */

	public void savePrerequisteClick() {

		if (selectedPrerequisite != null) {

			prerequisites.remove(selectedPrerequisite);

			if (selectedPrerequisite.getId() == null || selectedPrerequisite.getId() == 0) {
				// Add
				selectedPrerequisite.setKartaprzedmiotu(subjectCard);
				selectedPrerequisite.setPozycja((short) (prerequisites.size() + 1));
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

	/**
	 * Obsługa okien dialogowych dla Celów
	 */

	public Celprzedmiotu getSelectedObjective() {
		return selectedObjective;
	}

	public void setSelectedObjective(Celprzedmiotu selectedObjective) {
		this.selectedObjective = selectedObjective;
	}

	public void preAddObjective() {
		this.selectedObjective = new Celprzedmiotu();
		this.selectedObjective.setKartaprzedmiotu(subjectCard);
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

	public void saveObjectiveClick() {

		if (selectedObjective != null) {
			objectives.remove(selectedObjective);

			if (selectedObjective.getId() == 0) {
				// Add
				objectives.add(selectedObjective);
			} else {
				// Edit
				objectives.add(elementIndex, selectedObjective);
			}

			correctObjectiveNumbers(objectives);

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie zapisano zmiany");

			elementIndex = -1;
			selectedObjective = null;
		}
	}

	public void removeObjectiveClick() {

		if (selectedObjective != null) {
			objectives.remove(selectedObjective);

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

	/**
	 * Obsługa okien dialogowych dla PEK
	 */

	public Przedmiotowyefektksztalcenia getSelectedSEE() {
		return selectedSEE;
	}

	public void setSelectedSEE(Przedmiotowyefektksztalcenia selectedSEE) {
		this.selectedSEE = selectedSEE;
	}

	public StreamedContent downloadVerbs() {
		InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/resources/files/spis_czasownikow.pdf");
		return new DefaultStreamedContent(stream, "application/pdf", "spis_czasownikow.pdf");
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
					subjectEducationalEffectsKnowledge.add(selectedSEE);
				} else if (selectedSEE.getNumer().startsWith("PEK_U")) {
					selectedSEE.setKartaprzedmiotu(subjectCard);
					subjectEducationalEffectsSkills.add(selectedSEE);
				} else {
					selectedSEE.setKartaprzedmiotu(subjectCard);
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

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie usunięto");

			elementIndex = -1;
			selectedSEE = null;
		}
	}

	private void correctSEENumbers(List<Przedmiotowyefektksztalcenia> list) {
		for (int i = 0; i < list.size(); i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(list.get(i).getNumer().substring(0, 5));
			sb.append(String.format("%d02", i + 1));
			list.get(i).setNumer(sb.toString());
		}
	}

	/**
	 * Obsługa okien dialogowych dla Treści programowych
	 */

	public Trescprogramowa getSelectedProgrammeContent() {
		return selectedProgrammeContent;
	}

	public void setSelectedProgrammeContent(Trescprogramowa selectedProgrammeContent) {
		this.selectedProgrammeContent = selectedProgrammeContent;
	}

	public Kurs getSelectedKurs() {
		return selectedKurs;
	}

	public void setSelectedKurs(Kurs selectedKurs) {
		this.selectedKurs = selectedKurs;
	}

	public void preAddProgrammeContent(Kurs kurs) {
		this.selectedKurs = kurs;
		this.selectedProgrammeContent = new Trescprogramowa();
		this.selectedProgrammeContent.setKartaprzedmiotu(subjectCard);
		this.selectedProgrammeContent.setKurs(selectedKurs);
	}

	public void preEditProgrammeContent(Kurs kurs, Trescprogramowa programmeContent) {
		this.selectedKurs = kurs;
		this.selectedProgrammeContent = programmeContent;
	}

	public void preRemoveProgrammeContent(Kurs kurs, Trescprogramowa programmeContent) {
		this.selectedKurs = kurs;
		this.selectedProgrammeContent = programmeContent;
	}

	public List<Integer> getCoursesList() {
		List<Integer> courses = new ArrayList<Integer>();

		if (selectedKurs != null) {
			for (int i = 0; i < selectedKurs.getLiczbaZajec(); i++) {
				courses.add(i + 1);
			}
		}

		return courses;
	}

	public void saveProgrammeContentClick() {

		if (selectedProgrammeContent != null && selectedKurs != null) {

			List<Trescprogramowa> list = this.getProgrammeContents(selectedKurs);
			list.remove(selectedProgrammeContent);
			list.add(selectedProgrammeContent);

			Collections.sort(list);

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie zapisano zmiany");

			selectedProgrammeContent = null;
			selectedKurs = null;
		}

	}

	public void removeProgrammeContentClick() {

		if (selectedProgrammeContent != null && selectedKurs != null) {

			List<Trescprogramowa> list = this.getProgrammeContents(selectedKurs);
			list.remove(selectedProgrammeContent);

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie usunięto");

			selectedProgrammeContent = null;
			selectedKurs = null;
		}
	}

	/**
	 * Obsługa okien dialogowych dla Narzędzi dydaktycznych
	 */

	public Narzedziedydaktyczne getSelectedTeachingTool() {
		return selectedTeachingTool;
	}

	public void setSelectedTeachingTool(Narzedziedydaktyczne selectedTeachingTool) {
		this.selectedTeachingTool = selectedTeachingTool;
	}

	public void preAddTeachingTool() {
		this.selectedTeachingTool = new Narzedziedydaktyczne();
		this.selectedTeachingTool.setKartaprzedmiotu(subjectCard);
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

	public void saveTeachingToolClick() {

		if (selectedTeachingTool != null) {
			teachingTools.remove(selectedTeachingTool);

			if (selectedTeachingTool.getId() == null || selectedTeachingTool.getId() == 0) {
				// Add
				teachingTools.add(selectedTeachingTool);
			} else {
				// Edit
				teachingTools.add(elementIndex, selectedTeachingTool);
			}

			correctTeachingToolNumbers(teachingTools);

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

	/**
	 * Obsługa okien dialogowych dla Literatury
	 */

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
					basicLiterature.add(selectedLiterature);
				} else {
					selectedLiterature.setPozycja((short) (extendedLiterature.size() + 1));
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

	/**
	 * Obsługa okien dialogowych dla Ocen PEK
	 */

	public Ocenaosiagieciapek getSelectedEvaluation() {
		return selectedEvaluation;
	}

	public void setSelectedEvaluation(Ocenaosiagieciapek selectedEvaluation) {
		this.selectedEvaluation = selectedEvaluation;
	}

	public void preAddEvaluation(String type) {
		this.selectedEvaluation = new Ocenaosiagieciapek();
		this.selectedEvaluation.setKartaprzedmiotu(subjectCard);

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

		putValuesToSelectedSEEs();
	}

	public void preEditEvaluation(Ocenaosiagieciapek evaluation) {
		this.selectedEvaluation = evaluation;
		if (this.selectedEvaluation.getNumer().startsWith("F")) {
			elementIndex = formingEvaluations.lastIndexOf(evaluation);
		} else {
			elementIndex = concludingEvaluations.lastIndexOf(evaluation);
		}

		putValuesToSelectedSEEs();
	}

	private void putValuesToSelectedSEEs() {
		this.selectedSEEs = new ArrayList<String>();

		for (Pekocenaosiagnieciapek peko : selectedEvaluation.getPekocenaosiagnieciapeks()) {
			selectedSEEs.add(peko.getPrzedmiotowyefektksztalcenia().getNumer());
		}
	}

	public void preRemoveEvaluation(Ocenaosiagieciapek evaluation) {
		this.selectedEvaluation = evaluation;
	}

	public void saveEvaluationClick() {

		if (selectedEvaluation != null) {

			giveValuesFromSelectedSEEs();

			if (this.selectedEvaluation.getNumer().startsWith("F")) {
				formingEvaluations.remove(selectedEvaluation);
			} else {
				concludingEvaluations.remove(selectedEvaluation);
			}

			if (selectedEvaluation.getId() == null || selectedEvaluation.getId() == 0) {

				if (this.selectedEvaluation.getNumer().startsWith("F")) {
					formingEvaluations.add(selectedEvaluation);
					correctEvaluationNumbers(formingEvaluations);
				} else {
					concludingEvaluations.add(selectedEvaluation);
					correctEvaluationNumbers(concludingEvaluations);
				}

			}

			showMessageDlg(FacesMessage.SEVERITY_INFO, "Pomyślnie zapisano zmiany");

			selectedEvaluation = null;
		}
	}

	private void giveValuesFromSelectedSEEs() {

		Set<Pekocenaosiagnieciapek> pekos = new HashSet<Pekocenaosiagnieciapek>();

		for (String number : selectedSEEs) {
			Pekocenaosiagnieciapek peko = new Pekocenaosiagnieciapek();
			peko.setOcenaosiagieciapek(selectedEvaluation);
			peko.setPrzedmiotowyefektksztalcenia(getSEE(number));
			pekos.add(peko);
		}

		selectedEvaluation.setPekocenaosiagnieciapeks(pekos);
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

	public List<String> getSelectedSEEs() {
		return selectedSEEs;
	}

	public void setSelectedSEEs(List<String> selectedSEEs) {
		this.selectedSEEs = selectedSEEs;
	}

	/**
	 * 
	 */

	public String getDescription(Przedmiotowyefektksztalcenia pek) {
		this.expandedSEE = pek;

		putValuesToSelectedEFFs();
		putValuesToSelectedObjectives();
		putValuesToSelectedTools();
		putValuesToSelectedProgrammeContents();

		return pek.getOpis();
	}

	public List<String> getSelectedFEEs() {
		return selectedFEEs;
	}

	public void setSelectedFEEs(List<String> selectedFEEs) {
		this.selectedFEEs = selectedFEEs;
	}

	public List<String> getSelectedObjectives() {
		return selectedObjectives;
	}

	public void setSelectedObjectives(List<String> selectedObjectives) {
		this.selectedObjectives = selectedObjectives;
	}

	public List<String> getSelectedProgrammeContents() {
		return selectedProgrammeContents;
	}

	public void setSelectedProgrammeContents(List<String> selectedProgrammeContents) {
		this.selectedProgrammeContents = selectedProgrammeContents;
	}

	public List<String> getSelectedTools() {
		return selectedTools;
	}

	public void setSelectedTools(List<String> selectedTools) {
		this.selectedTools = selectedTools;
	}

	public void selectFEEListener(AjaxBehaviorEvent event) {
		giveValuesFromSelectedFEEs();
	}

	public void selectObjectiveListener(AjaxBehaviorEvent event) {
		giveValuesFromSelectedObjectives();
	}

	public void selectToolListener(AjaxBehaviorEvent event) {
		giveValuesFromSelectedTools();
	}

	public void selectProgrammeContentListener(AjaxBehaviorEvent event) {
		giveValuesFromSelectedProgrammeContents();
	}

	private void putValuesToSelectedObjectives() {
		this.selectedObjectives = new ArrayList<String>();

		for (Pekcelprzedmiotu item : expandedSEE.getPekcelprzedmiotus()) {
			selectedObjectives.add(item.getCelprzedmiotu().getNumer());
		}
	}

	private void putValuesToSelectedEFFs() {
		this.selectedFEEs = new ArrayList<String>();

		for (Kekpek item : expandedSEE.getKekpeks()) {
			selectedFEEs.add(item.getKierunkowyefektksztalcenia().getNumer());
		}
	}

	private void putValuesToSelectedTools() {
		this.selectedTools = new ArrayList<String>();

		for (Peknarzedziedydaktyczne item : expandedSEE.getPeknarzedziedydaktycznes()) {
			selectedTools.add(item.getNarzedziedydaktyczne().getNumer());
		}
	}

	private void putValuesToSelectedProgrammeContents() {
		this.selectedProgrammeContents = new ArrayList<String>();

		for (Pektrescprogramowa item : expandedSEE.getPektrescprogramowas()) {
			selectedProgrammeContents.add(item.getTrescprogramowa().getNumer());
		}
	}

	private void giveValuesFromSelectedObjectives() {

		Set<Pekcelprzedmiotu> items = new HashSet<Pekcelprzedmiotu>();

		for (String number : selectedObjectives) {
			Pekcelprzedmiotu item = new Pekcelprzedmiotu();
			item.setPrzedmiotowyefektksztalcenia(expandedSEE);
			item.setCelprzedmiotu(this.getObjective(number));
			items.add(item);
		}

		expandedSEE.setPekcelprzedmiotus(items);
	}

	private void giveValuesFromSelectedFEEs() {

		Set<Kekpek> items = new HashSet<Kekpek>();

		for (String number : selectedFEEs) {
			Kekpek item = new Kekpek();
			item.setPrzedmiotowyefektksztalcenia(expandedSEE);
			item.setKierunkowyefektksztalcenia(this.getFEE(number));
			items.add(item);
		}

		expandedSEE.setKekpeks(items);
	}

	private void giveValuesFromSelectedTools() {

		Set<Peknarzedziedydaktyczne> items = new HashSet<Peknarzedziedydaktyczne>();

		for (String number : selectedTools) {
			Peknarzedziedydaktyczne item = new Peknarzedziedydaktyczne();
			item.setPrzedmiotowyefektksztalcenia(expandedSEE);
			item.setNarzedziedydaktyczne(this.getTool(number));
			items.add(item);
		}

		expandedSEE.setPeknarzedziedydaktycznes(items);
	}

	private void giveValuesFromSelectedProgrammeContents() {

		Set<Pektrescprogramowa> items = new HashSet<Pektrescprogramowa>();

		for (String number : selectedProgrammeContents) {
			Pektrescprogramowa item = new Pektrescprogramowa();
			item.setPrzedmiotowyefektksztalcenia(expandedSEE);
			item.setTrescprogramowa(this.getProgrammeContent(number));
			items.add(item);
		}

		expandedSEE.setPektrescprogramowas(items);
	}
}
