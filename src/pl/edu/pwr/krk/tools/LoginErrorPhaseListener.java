package pl.edu.pwr.krk.tools;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.authentication.BadCredentialsException;

public class LoginErrorPhaseListener implements PhaseListener
{
    private static final long serialVersionUID = -1216620620302322995L;
 
    @Override
    public void beforePhase(final PhaseEvent event)
    {
        /*Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
                AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);
 
        if (e instanceof BadCredentialsException)
        {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
                    AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY, null);
            FacesUtils.addErrorMessage("Username or password not valid.");
        }
        */
    }
 
    @Override
    public void afterPhase(final PhaseEvent event)
    {}
 
    @Override
    public PhaseId getPhaseId()
    {
        return PhaseId.RENDER_RESPONSE;
    }
 
}
