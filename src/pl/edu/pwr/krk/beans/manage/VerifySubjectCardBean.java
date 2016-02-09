package pl.edu.pwr.krk.beans.manage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.org.apache.xml.internal.security.keys.content.KeyValue;

import pl.edu.pwr.krk.models.entities.Celprzedmiotu;
import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;
import pl.edu.pwr.krk.models.entities.Narzedziedydaktyczne;
import pl.edu.pwr.krk.models.entities.Ocenaosiagieciapek;
import pl.edu.pwr.krk.models.entities.Pekocenaosiagnieciapek;
import pl.edu.pwr.krk.models.entities.Pozycjaliteraturowa;
import pl.edu.pwr.krk.models.entities.Przedmiotowyefektksztalcenia;
import pl.edu.pwr.krk.models.entities.Trescprogramowa;
import pl.edu.pwr.krk.models.entities.Wymaganiawstepne;
import pl.edu.pwr.krk.models.services.KartaprzedmiotuService;
import pl.edu.pwr.krk.models.services.PrzedmiotService;
import pl.edu.pwr.krk.tools.ApplicationContextProvider;

@ManagedBean
@ViewScoped()
public class VerifySubjectCardBean extends Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(VerifySubjectCardBean.class);

	private int id;

	private Kartaprzedmiotu subjectCard = null;
	private PrzedmiotService przedmiotService = null;
	private KartaprzedmiotuService kartaPrzedmiotuService = null;

	@PostConstruct
	public void postConstructor() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (!facesContext.isPostback() && !facesContext.isValidationFailed()) {

			przedmiotService = (PrzedmiotService) ApplicationContextProvider.getApplicationContext()
					.getBean("przedmiotService");
			kartaPrzedmiotuService = (KartaprzedmiotuService) ApplicationContextProvider.getApplicationContext()
					.getBean("kartaprzedmiotuService");
		}
	}
	
	public void cancelVerify() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("subjectCards.xhtml?id=" + subjectCard.getPrzedmiot().getId());
	}

	public void initialiaze() {
		subjectCard = kartaPrzedmiotuService.findById(id);
		verify();
	}

	List<String> errorList = new ArrayList<>();

	private void verify() {
		// REG006 Nie mogą istnieć dwa takie same wymagania w obrębie jednej
		// wersji karty przedmiotu. Opis wymagania musi być unikalny.
		List<String> toVerify = new ArrayList<>();
		List<String> toVerify2 = new ArrayList<>();
		for (Wymaganiawstepne obj : subjectCard.getWymaganiawstepnes()) {
			toVerify.add(obj.getWymaganie());
		}
		if (areDuplicates(toVerify)) {
			errorList.add(
					"Nie mogą istnieć dwa takie same wymagania w obrębie jednej wersji karty przedmiotu. Opis wymagania musi być unikalny.");
		}

		// REG024 Numer kolejnego celu przedmiotu musi spełniać następujące
		// wyrażenie regularne: /C[0-9]*/ (objaśnienie: zaczyna się od znaku
		// 'C', po którym następuje ciąg cyfr od 0 do 9).
		// REG007 Numer celu przedmiotu musi być unikalny w obrębie danej wersji
		// karty przedmiotu.
		// REG008 Opis celu przedmiotu musi być unikalny w obrębie danej wersji
		// karty przedmiotu.
		toVerify = new ArrayList<>();
		toVerify2 = new ArrayList<>();
		for (Celprzedmiotu obj : subjectCard.getCelprzedmiotus()) {
			toVerify.add(obj.getNumer());
			toVerify2.add(obj.getOpis());
			if (!Pattern.matches("C[0-9]*", obj.getNumer())) {
				errorList.add(
						"Numer kolejnego celu przedmiotu musi spełniać następujące wyrażenie regularne: /C[0-9]*/");
			}
		}
		if (areDuplicates(toVerify)) {
			errorList.add("Numer celu przedmiotu musi być unikalny w obrębie danej wersji karty przedmiotu.");
		}
		if (areDuplicates(toVerify2)) {
			errorList.add("Opis celu przedmiotu musi być unikalny w obrębie danej wersji karty przedmiotu.");
		}

		// REG009 Numer Przedmiotowego Efektu Kształcenia musi być unikalny w
		// obrębie danej wersji karty przedmiotu.
		// REG010 Opis Przedmiotowego Efektu Kształcenia musi być unikalny w
		// obrębie danej wersji karty przedmiotu.
		toVerify = new ArrayList<>();
		toVerify2 = new ArrayList<>();
		for (Przedmiotowyefektksztalcenia obj : subjectCard.getPrzedmiotowyefektksztalcenias()) {
			toVerify.add(obj.getNumer());
			toVerify2.add(obj.getOpis());
		}
		if (areDuplicates(toVerify)) {
			errorList.add(
					"Numer Przedmiotowego Efektu Kształcenia musi być unikalny w obrębie danej wersji karty przedmiotu.");
		}
		if (areDuplicates(toVerify2)) {
			errorList.add(
					"Opis Przedmiotowego Efektu Kształcenia musi być unikalny w obrębie danej wersji karty przedmiotu.");
		}
		// REG025 Numer kolejnego narzędzia dydaktycznego musi spełniać
		// następujące wyrażenie regularne: /N[0-9]* / (objaśnienie: zaczyna się
		// od znaku 'N', po którym następuje ciąg cyfr od 0 do 9).
		// REG012 Numer narzędzia dydaktycznego musi być unikalny w obrębie
		// danej wersji karty przedmiotu.
		// REG013 Opis narzędzia dydaktycznego musi być unikalny w obrębie danej
		// wersji karty przedmiotu.
		toVerify = new ArrayList<>();
		toVerify2 = new ArrayList<>();
		for (Narzedziedydaktyczne obj : subjectCard.getNarzedziedydaktycznes()) {
			toVerify.add(obj.getNumer());
			toVerify2.add(obj.getOpis());

			if (!Pattern.matches("N[0-9]*", obj.getNumer())) {
				errorList.add(
						"Numer kolejnego narzędzia dydaktycznego musi spełniać następujące wyrażenie regularne: /N[0-9]*/");
			}
		}
		if (areDuplicates(toVerify)) {
			errorList.add("Numer narzędzia dydaktycznego musi być unikalny w obrębie danej wersji karty przedmiotu.");
		}
		if (areDuplicates(toVerify2)) {
			errorList.add("Numer narzędzia dydaktycznego musi być unikalny w obrębie danej wersji karty przedmiotu.");
		}

		// REG015 Opis treści programowej musi być unikalny w obrębie danej
		// formy przedmiotu.
		// REG022 Liczba ‘liczbaGodzin’ w treści programowej musi być całkowitą
		// liczbą dodatnią.
		// REG027 Liczba ‘od’ w treści programowej musi być całkowitą liczbą
		// dodatnią.
		// REG028 Liczba ‘do’ w treści programowej musi być całkowitą liczbą
		// dodatnią.
		// REG029 Liczba ‘od’ w treści programowej nie może być większa od
		// wartości pola ‘liczbaZajec’ z kursu odpowiadającemu tej treści.
		// REG030 Liczba ‘do’ w treści programowej nie może być większa od
		// wartości pola ‘liczbaZajec’ z kursu odpowiadającemu tej treści.
		// REG031 Liczba ‘od’ w treści programowej nie może być większa od
		// liczby ‘do’ w tej samej treści.

		// REG020 Suma godzin dla treści programowych jednej formy przedmiotu
		// musi być równa liczbie ZZU przeznaczonej dla danej formy przedmiotu
		// REG021 Liczba godzin dla treści programowej danej formy przedmiotu
		// nie może być większa niż liczba ZZU dla tej formy przedmiotu.

		Map<String, Integer> hours = new HashMap<>();
		Map<String, Integer> zzu = new HashMap<>();
		toVerify = new ArrayList<>();
		toVerify2 = new ArrayList<>();
		for (Trescprogramowa obj : subjectCard.getTrescprogramowas()) {

			if (obj.getLiczbaGodzin() > obj.getKurs().getZzu()) {
				errorList.add(
						"Liczba godzin dla treści programowej danej formy przedmiotu nie może być większa niż liczba ZZU dla tej formy przedmiotu.");
			}

			String key = obj.getKurs().getFormaZajec();
			hours.put(key, (hours.get(key) == null ? 0 : hours.get(key)) + obj.getLiczbaGodzin());
			zzu.put(key, (int) obj.getKurs().getZzu());

			toVerify.add(obj.getOpis());
			if (obj.getLiczbaGodzin() <= 0) {
				errorList.add("Liczba ‘liczbaGodzin’ w treści programowej musi być całkowitą liczbą dodatnią..");
			}
			if (obj.getTrescOd() <= 0) {
				errorList.add("Liczba ‘od’ w treści programowej musi być całkowitą liczbą dodatnią.");
			}
			if (obj.getTrescDo() <= 0) {
				errorList.add("Liczba ‘do’ w treści programowej musi być całkowitą liczbą dodatnią.");
			}
			if (obj.getTrescOd() > obj.getKurs().getLiczbaZajec()) {
				errorList.add(
						"Liczba ‘od’ w treści programowej nie może być większa od wartości pola ‘liczbaZajec’ z kursu odpowiadającemu tej treści.");
			}
			if (obj.getTrescDo() > obj.getKurs().getLiczbaZajec()) {
				errorList.add(
						"Liczba ‘do’ w treści programowej nie może być większa od wartości pola ‘liczbaZajec’ z kursu odpowiadającemu tej treści.");
			}
			if (obj.getTrescOd() > obj.getTrescDo()) {
				errorList.add(
						"Liczba ‘od’ w treści programowej nie może być większa od liczby ‘do’ w tej samej treści.");
			}
		}
		for (String key : hours.keySet()) {
			if (hours.get(key) != zzu.get(key)) {
				errorList.add(
						"Suma godzin dla treści programowych jednej formy przedmiotu musi być równa liczbie ZZU przeznaczonej dla danej formy przedmiotu.");
			}
		}
		if (areDuplicates(toVerify)) {
			errorList.add("Opis treści programowej musi być unikalny w obrębie danej formy przedmiotu.");
		}

		// REG016 Opis bibliograficzny musi być unikalny w obrębie danej formy
		// przedmiotu.
		toVerify = new ArrayList<>();
		for (Pozycjaliteraturowa obj : subjectCard.getPozycjaliteraturowas()) {
			toVerify.add(obj.getOpis());
		}
		if (areDuplicates(toVerify)) {
			errorList.add("Opis bibliograficzny musi być unikalny w obrębie danej formy przedmiotu.");
		}

		// REG018 Karta przedmiotu musi mieć wybrany język, w którym jest
		// napisana (polski lub angielski).
		// REG032 Pole ‘kierunekStudiow’ w karcie przedmiotu jest wczytywane
		// poprzez odwołanie się do:
		// self.przedmiot.modułKształcenia.programStudiów.programKształcenia.KierunekStudiów.nazwa.
		// REG033 Pole ‘stopienStudiow’ w karcie przedmiotu jest wczytywane
		// poprzez odwołanie się do:
		// self.przedmiot.modułKształcenia.programStudiów.programKształcenia.stopienStudiow.
		// REG034 Pole ‘formaStudiow’ w karcie przedmiotu jest wczytywane
		// poprzez odwołanie się do:
		// self.przedmiot.modułKształcenia.programStudiów.programKształcenia.formaStudiow.
		if (!subjectCard.getKierunekStudiow().equals(subjectCard.getPrzedmiot().getModulksztalcenia()
				.getProgramstudiow().getProgramksztalcenia().getKierunekstudiow().getNazwa())) {
			errorList.add(
					"Pole ‘kierunekStudiow’ w karcie przedmiotu jest wczytywane poprzez odwołanie się do: self.przedmiot.modułKształcenia.programStudiów.programKształcenia.KierunekStudiów.nazwa.)");
		}
		if (!subjectCard.getStopienStudiow().equals(subjectCard.getPrzedmiot().getModulksztalcenia().getProgramstudiow()
				.getProgramksztalcenia().getStopienStudiow())) {
			errorList.add(
					"Pole ‘stopienStudiow’ w karcie przedmiotu jest wczytywane poprzez odwołanie się do: self.przedmiot.modułKształcenia.programStudiów.programKształcenia.stopienStudiow)");
		}
		if (!subjectCard.getFormaStudiow().equals(subjectCard.getPrzedmiot().getModulksztalcenia().getProgramstudiow()
				.getProgramksztalcenia().getFormaStudiow())) {
			errorList.add(
					"Pole ‘formaStudiow’ w karcie przedmiotu jest wczytywane poprzez odwołanie się do: self.przedmiot.modułKształcenia.programStudiów.programKształcenia.formaStudiow.)");
		}
		if (subjectCard.getJezyk() == null || subjectCard.getJezyk().isEmpty()) {
			errorList.add("Karta przedmiotu musi mieć wybrany język, w którym jest napisana (polski lub angielski)");
		}

		List<Przedmiotowyefektksztalcenia> copyList = new ArrayList<>();
		// REG017 Oceny podsumowujące dla danej karty przedmiotu muszą pokrywać
		// wszystkie Przedmiotowe Efekty Kształcenia dla tej karty.
		for (Ocenaosiagieciapek obj : subjectCard.getOcenaosiagieciapeks()) {
			if (obj.getNumer().startsWith("P"))
				for (Pekocenaosiagnieciapek pek : obj.getPekocenaosiagnieciapeks()) {
					copyList.add(pek.getPrzedmiotowyefektksztalcenia());
				}
		}
		if (copyList.size() != subjectCard.getPrzedmiotowyefektksztalcenias().size()) {
			errorList.add(
					"Oceny podsumowujące dla danej karty przedmiotu muszą pokrywać wszystkie Przedmiotowe Efekty Kształcenia dla tej karty");
		}

		// REG023 Numer kolejnego Przedmiotowego Efektu Kształcenia musi
		// spełniać następujące wyrażenie regularne: /PEK_[A-Z][0-9]* /
		// (objaśnienie: zaczyna się od ciągu znaków "PEK_", po nim następuje
		// dowolna wielka litera od A do Z, a następnie ciąg cyfr od 0 do 9).
		for (Przedmiotowyefektksztalcenia obj : subjectCard.getPrzedmiotowyefektksztalcenias()) {
			if (!Pattern.matches("PEK_[A-Z][0-9]*", obj.getNumer())) {
				errorList.add(
						"Numer kolejnego Przedmiotowego Efektu Kształcenia musi spełniać następujące wyrażenie regularne: /PEK_[A-Z][0-9]*/");
			}
		}

	}

	private <T> boolean areDuplicates(Collection<T> list) {

		Set<T> duplicates = new LinkedHashSet<T>();
		Set<T> uniques = new HashSet<T>();

		for (T t : list) {
			if (!uniques.add(t)) {
				duplicates.add(t);
			}
		}

		return uniques.size() != list.size();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

		initialiaze();
	}
	
	public List<String> getErrorList() {
		return errorList;
	}
		
	public Kartaprzedmiotu getSubjectCard() {
		return subjectCard;
	}

}
