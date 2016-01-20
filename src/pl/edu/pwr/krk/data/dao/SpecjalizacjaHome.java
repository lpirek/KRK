// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.data.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.data.entities.Specjalizacja;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Specjalizacja.
 * @see .Specjalizacja
 * @author Hibernate Tools
 */
public class SpecjalizacjaHome {

	private static final Log log = LogFactory.getLog(SpecjalizacjaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Specjalizacja transientInstance) {
		log.debug("persisting Specjalizacja instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Specjalizacja instance) {
		log.debug("attaching dirty Specjalizacja instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Specjalizacja instance) {
		log.debug("attaching clean Specjalizacja instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Specjalizacja persistentInstance) {
		log.debug("deleting Specjalizacja instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Specjalizacja merge(Specjalizacja detachedInstance) {
		log.debug("merging Specjalizacja instance");
		try {
			Specjalizacja result = (Specjalizacja) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Specjalizacja findById(java.lang.Integer id) {
		log.debug("getting Specjalizacja instance with id: " + id);
		try {
			Specjalizacja instance = (Specjalizacja) sessionFactory.getCurrentSession().get("Specjalizacja", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Specjalizacja> findByExample(Specjalizacja instance) {
		log.debug("finding Specjalizacja instance by example");
		try {
			List<Specjalizacja> results = (List<Specjalizacja>) sessionFactory.getCurrentSession()
					.createCriteria("Specjalizacja").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
