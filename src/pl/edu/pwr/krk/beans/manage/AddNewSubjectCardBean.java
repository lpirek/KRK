package pl.edu.pwr.krk.beans.manage;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.edu.pwr.krk.models.entities.Programksztalcenia;
import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Uzytkownik;

@ManagedBean
@ViewScoped()
public class AddNewSubjectCardBean extends Bean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(AddNewSubjectCardBean.class);

	private int tabIndex = 0;

	public int getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}

	public AddNewSubjectCardBean() {
		log.debug("Initialiaze AddNewSubjectCardBean");
	}

	@PostConstruct
	public void postConstructor() {
		initialiaze();
	}

	public void initialiaze() {
		Uzytkownik uzytkownik = getCurrentUser();
	}
}
