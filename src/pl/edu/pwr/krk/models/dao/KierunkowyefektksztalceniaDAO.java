package pl.edu.pwr.krk.models.dao;

import java.util.ArrayList;
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

import pl.edu.pwr.krk.models.entities.Kierunkowyefektksztalcenia;
import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Uzytkownik;

import static org.hibernate.criterion.Example.create;

public class KierunkowyefektksztalceniaDAO extends DAO{

	private static final Log log = LogFactory.getLog(KierunkowyefektksztalceniaDAO.class);

	public List<Kierunkowyefektksztalcenia> findAll() {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Kierunkowyefektksztalcenia.class);
			
			List<Kierunkowyefektksztalcenia> result = new ArrayList<Kierunkowyefektksztalcenia>(criteria.list());
			
			tx.commit();
			
			return result;
			
		} catch (RuntimeException exception) {
			log.error("get failed", exception);
			throw exception;
		} finally {
	        session.close(); 
	    }
	}

	
}
