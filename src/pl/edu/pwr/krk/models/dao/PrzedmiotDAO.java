package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Uzytkownik;

import static org.hibernate.criterion.Example.create;

public class PrzedmiotDAO extends DAO{

	private static final Log log = LogFactory.getLog(PrzedmiotDAO.class);

	public Przedmiot findById(int id) {
		
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Przedmiot.class);
			criteria.add(Restrictions.eq("id", id));
			
			Przedmiot instance = (Przedmiot)criteria.uniqueResult();
			
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
