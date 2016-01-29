package pl.edu.pwr.krk.beans.global;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import pl.edu.pwr.krk.beans.SessionConfig;

@ManagedBean
@SessionScoped
public class AuthBean implements Serializable {
 
    private static final long serialVersionUID = 1L;

    private String login;
    private String password;
    
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	public String login() {
		
		if (login.equals("admin") && password.equals("admin")) {
			HttpSession session = SessionConfig.getSession();
	        session.setAttribute("authenticated", true);
	        return "login";
		}
		else {
			FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Błąd",
                            "Niepoprawny login bądź hasło"));
            return "";
		}
    }
	
	public String logout() {
		HttpSession session = SessionConfig.getSession();
        session.invalidate();
        return "logout";
	}
	
}
