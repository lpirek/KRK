package pl.edu.pwr.krk.models.dao;

import java.util.ArrayList;
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

import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;
import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Wymaganiawstepne;

import static org.hibernate.criterion.Example.create;

public class WymaganiawstepneDAO extends DAO {

	private static final Log log = LogFactory.getLog(WymaganiawstepneDAO.class);

	public List<Wymaganiawstepne> findWymaganiaWstepne(int kartaPrzedmiotuId) {

		Session session = null;
		List<Wymaganiawstepne> result = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Wymaganiawstepne.class);
			criteria.add(Restrictions.eq("kartaprzedmiotu.id", kartaPrzedmiotuId));

			result = new ArrayList<Wymaganiawstepne>(criteria.list());

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
