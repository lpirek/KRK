// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.data.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.data.entities.Kekpek;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Kekpek.
 * @see .Kekpek
 * @author Hibernate Tools
 */
public class KekpekHome {

	private static final Log log = LogFactory.getLog(KekpekHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Kekpek transientInstance) {
		log.debug("persisting Kekpek instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Kekpek instance) {
		log.debug("attaching dirty Kekpek instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kekpek instance) {
		log.debug("attaching clean Kekpek instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Kekpek persistentInstance) {
		log.debug("deleting Kekpek instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kekpek merge(Kekpek detachedInstance) {
		log.debug("merging Kekpek instance");
		try {
			Kekpek result = (Kekpek) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Kekpek findById(java.lang.Integer id) {
		log.debug("getting Kekpek instance with id: " + id);
		try {
			Kekpek instance = (Kekpek) sessionFactory.getCurrentSession().get("Kekpek", id);
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

	public List<Kekpek> findByExample(Kekpek instance) {
		log.debug("finding Kekpek instance by example");
		try {
			List<Kekpek> results = (List<Kekpek>) sessionFactory.getCurrentSession().createCriteria("Kekpek")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
