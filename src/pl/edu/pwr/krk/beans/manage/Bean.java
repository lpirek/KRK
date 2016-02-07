package pl.edu.pwr.krk.beans.manage;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import pl.edu.pwr.krk.models.entities.Uzytkownik;
import pl.edu.pwr.krk.models.services.UzytkownikService;
import pl.edu.pwr.krk.tools.ApplicationContextProvider;

public abstract class Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Log log = LogFactory.getLog(Bean.class);
	
	protected UzytkownikService uzytkownikService = null;
	
	public Bean() {
		uzytkownikService = (UzytkownikService) 
				ApplicationContextProvider.getApplicationContext().getBean("uzytkownikService");
	}
	
	protected Uzytkownik getCurrentUser() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Uzytkownik uzytkownik = uzytkownikService.getUzytkownik(user.getUsername());
		
		return uzytkownik;
	}
	
	protected boolean isPolish() {
		return FacesContext.getCurrentInstance().getViewRoot().getLocale() != Locale.ENGLISH;
	}
	
	protected boolean isEnglish() {
		return FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH;
	}
	
	protected String getMessage(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
		
		return bundle.getString(key);
	}
	
	public void showMessageDlg(Severity messageType, String content) {
		FacesContext.getCurrentInstance().addMessage(null, 
        		new FacesMessage(messageType, content, null));
    }
}
