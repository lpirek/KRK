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

import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;
import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Uzytkownik;

import static org.hibernate.criterion.Example.create;

public class KartaprzedmiotuDAO extends DAO {

	private static final Log log = LogFactory.getLog(KartaprzedmiotuDAO.class);

	public Kartaprzedmiotu findById(int id) {

		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Kartaprzedmiotu.class);
			criteria.add(Restrictions.eq("id", id));

			Kartaprzedmiotu instance = (Kartaprzedmiotu) criteria.uniqueResult();

			tx.commit();
			
			Hibernate.initialize(instance.getCelprzedmiotus());
			Hibernate.initialize(instance.getNarzedziedydaktycznes());
			Hibernate.initialize(instance.getPrzedmiotowyefektksztalcenias());
			Hibernate.initialize(instance.getTrescprogramowas());
			Hibernate.initialize(instance.getWymaganiawstepnes());
			Hibernate.initialize(instance.getOcenaosiagieciapeks());
			Hibernate.initialize(instance.getPozycjaliteraturowas());

			Hibernate.initialize(instance.getPrzedmiot());
			Hibernate.initialize(instance.getPrzedmiot().getModulksztalcenia());
			Hibernate.initialize(instance.getPrzedmiot().getModulksztalcenia().getProgramstudiow());
			Hibernate.initialize(instance.getPrzedmiot().getModulksztalcenia().getProgramstudiow().getProgramksztalcenia());
			Hibernate.initialize(instance.getPrzedmiot().getModulksztalcenia().getProgramstudiow().getProgramksztalcenia().getKierunekstudiow());
			
			return instance;

		} catch (RuntimeException exception) {
			log.error("get failed", exception);
			throw exception;
		} finally {
			session.close();
		}
	}

	public List<Kartaprzedmiotu> findKartyPrzedmiotu(int przedmiotId) {

		Session session = null;
		List<Kartaprzedmiotu> result = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Kartaprzedmiotu.class);
			criteria.add(Restrictions.eq("przedmiot.id", przedmiotId));

			result = new ArrayList<Kartaprzedmiotu>(criteria.list());

			tx.commit();

			return result;

		} catch (RuntimeException exception) {
			log.error("get failed", exception);
			throw exception;
		} finally {
			session.close();
		}
	}

	public void saveOrUpdate(Kartaprzedmiotu subjectCard) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.saveOrUpdate(subjectCard);
			tx.commit();
			
		} catch (RuntimeException exception) {
			log.error("get failed", exception);
			throw exception;
		} finally {
			session.close();
		}
	}
}
