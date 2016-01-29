// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Uzytkownik;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Uzytkownik.
 * @see .Uzytkownik
 * @author Hibernate Tools
 */
public class UzytkownikHome {

	private static final Log log = LogFactory.getLog(UzytkownikHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Uzytkownik transientInstance) {
		log.debug("persisting Uzytkownik instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Uzytkownik instance) {
		log.debug("attaching dirty Uzytkownik instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Uzytkownik instance) {
		log.debug("attaching clean Uzytkownik instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Uzytkownik persistentInstance) {
		log.debug("deleting Uzytkownik instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Uzytkownik merge(Uzytkownik detachedInstance) {
		log.debug("merging Uzytkownik instance");
		try {
			Uzytkownik result = (Uzytkownik) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Uzytkownik findById(java.lang.Integer id) {
		log.debug("getting Uzytkownik instance with id: " + id);
		try {
			Uzytkownik instance = (Uzytkownik) sessionFactory.getCurrentSession().get("Uzytkownik", id);
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

	public List<Uzytkownik> findByExample(Uzytkownik instance) {
		log.debug("finding Uzytkownik instance by example");
		try {
			List<Uzytkownik> results = (List<Uzytkownik>) sessionFactory.getCurrentSession()
					.createCriteria("Uzytkownik").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
