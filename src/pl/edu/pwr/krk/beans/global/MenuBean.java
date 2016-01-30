package pl.edu.pwr.krk.beans.global;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@RequestScoped()
public class MenuBean implements Serializable {
 
    private static final long serialVersionUID = 1L;

    private static final Log log = LogFactory.getLog(MenuBean.class);
    
	public String goToCareSubjects() {
		return "toCareSubjects";
	}
	
	public String goToCurrentSubjectsCard() {
		return "toCurrentSubjectsCard";
	}
	
	public String goToMyDetails() {
		return "toMyDetails";
	}
	
}
