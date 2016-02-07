package pl.edu.pwr.krk.beans.dialogs;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import pl.edu.pwr.krk.models.entities.Wymaganiawstepne;

@ManagedBean(name = "prerequisiteView")
@ViewScoped
public class PrerequisiteView implements Serializable {

	private String title = "Tytuł";
	private String prerequisite;

	@PostConstruct
	public void init() {
		//Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		//title = params.get("title");
	}

	public void cancel() {
        RequestContext.getCurrentInstance().closeDialog(null);
	}

	public void accept() {	
		Wymaganiawstepne prereq = new Wymaganiawstepne();
		prereq.setWymaganie(prerequisite);
        RequestContext.getCurrentInstance().closeDialog(prereq);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}
}
