package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.edu.pwr.krk.models.entities.Uzytkownik;

import static org.hibernate.criterion.Example.create;

public class UzytkownikDAO extends DAO {

	private static final Log log = LogFactory.getLog(UzytkownikDAO.class);

	public Uzytkownik findByLogin(String login) {
		log.debug("getting Uzytkownik instance with login: " + login);
		
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Uzytkownik.class);
			criteria.add(Restrictions.eq("login", login));
			
			Uzytkownik instance = (Uzytkownik)criteria.uniqueResult();
			
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			
			tx.commit();
			
			return instance;
			
		} catch (RuntimeException exception) {
			log.error("get failed", exception);
			throw exception;
		} finally {
	        session.close(); 
	    }
	}
	
}
