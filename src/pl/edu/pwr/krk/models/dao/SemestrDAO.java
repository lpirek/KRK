package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Semestr;

import static org.hibernate.criterion.Example.create;

public class SemestrDAO extends DAO{

	private static final Log log = LogFactory.getLog(SemestrDAO.class);
	
	
}
