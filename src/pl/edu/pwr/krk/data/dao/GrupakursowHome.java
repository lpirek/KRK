// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.data.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.data.entities.Grupakursow;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Grupakursow.
 * @see .Grupakursow
 * @author Hibernate Tools
 */
public class GrupakursowHome {

	private static final Log log = LogFactory.getLog(GrupakursowHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Grupakursow transientInstance) {
		log.debug("persisting Grupakursow instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Grupakursow instance) {
		log.debug("attaching dirty Grupakursow instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Grupakursow instance) {
		log.debug("attaching clean Grupakursow instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Grupakursow persistentInstance) {
		log.debug("deleting Grupakursow instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Grupakursow merge(Grupakursow detachedInstance) {
		log.debug("merging Grupakursow instance");
		try {
			Grupakursow result = (Grupakursow) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Grupakursow findById(java.lang.Integer id) {
		log.debug("getting Grupakursow instance with id: " + id);
		try {
			Grupakursow instance = (Grupakursow) sessionFactory.getCurrentSession().get("Grupakursow", id);
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

	public List<Grupakursow> findByExample(Grupakursow instance) {
		log.debug("finding Grupakursow instance by example");
		try {
			List<Grupakursow> results = (List<Grupakursow>) sessionFactory.getCurrentSession()
					.createCriteria("Grupakursow").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
