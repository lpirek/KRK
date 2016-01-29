// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Wymaganiawstepne;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Wymaganiawstepne.
 * @see .Wymaganiawstepne
 * @author Hibernate Tools
 */
public class WymaganiawstepneHome {

	private static final Log log = LogFactory.getLog(WymaganiawstepneHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Wymaganiawstepne transientInstance) {
		log.debug("persisting Wymaganiawstepne instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Wymaganiawstepne instance) {
		log.debug("attaching dirty Wymaganiawstepne instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Wymaganiawstepne instance) {
		log.debug("attaching clean Wymaganiawstepne instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Wymaganiawstepne persistentInstance) {
		log.debug("deleting Wymaganiawstepne instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Wymaganiawstepne merge(Wymaganiawstepne detachedInstance) {
		log.debug("merging Wymaganiawstepne instance");
		try {
			Wymaganiawstepne result = (Wymaganiawstepne) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Wymaganiawstepne findById(java.lang.Integer id) {
		log.debug("getting Wymaganiawstepne instance with id: " + id);
		try {
			Wymaganiawstepne instance = (Wymaganiawstepne) sessionFactory.getCurrentSession().get("Wymaganiawstepne",
					id);
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

	public List<Wymaganiawstepne> findByExample(Wymaganiawstepne instance) {
		log.debug("finding Wymaganiawstepne instance by example");
		try {
			List<Wymaganiawstepne> results = (List<Wymaganiawstepne>) sessionFactory.getCurrentSession()
					.createCriteria("Wymaganiawstepne").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
