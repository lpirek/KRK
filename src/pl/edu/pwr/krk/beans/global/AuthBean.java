package pl.edu.pwr.krk.beans.global;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;


@ManagedBean
@RequestScoped
public class AuthBean implements Serializable {
 
    private static final long serialVersionUID = 1L;

    private static final Log log = LogFactory.getLog(AuthBean.class);
    
    private String username;
    private String password;
    
    @Autowired
    public AuthenticationManager authenticationManager;
    
    public String doLogin() throws ServletException, IOException {
        
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(username, password);
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
        } 
        catch (AuthenticationException e) {
            log.error(e.getStackTrace());
            showErrorMessage();
            
            return "";
        }
        
        return "login";
    }

    public String doLogout() {
		SecurityContextHolder.clearContext();
        return "logout";
	}
    
    public String getCurrentUsername() {
    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	return user.getUsername();
    }
    
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
    	this.authenticationManager = authenticationManager;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void showErrorMessage() {
		FacesContext.getCurrentInstance().addMessage(null, 
        		new FacesMessage(FacesMessage.SEVERITY_ERROR, 
        		getMessage("login.wrong"), null));
    }
	
	protected String getMessage(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
		
		return bundle.getString(key);
	}
}
