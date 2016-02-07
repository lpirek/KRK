package pl.edu.pwr.krk.beans.dialogs;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "programmeContentView ")
@ViewScoped
public class ProgrammeContentView implements Serializable {

	@PostConstruct
	public void init() {

	}
}