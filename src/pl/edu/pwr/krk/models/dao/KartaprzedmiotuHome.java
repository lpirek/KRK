// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Kartaprzedmiotu.
 * @see .Kartaprzedmiotu
 * @author Hibernate Tools
 */
public class KartaprzedmiotuHome {

	private static final Log log = LogFactory.getLog(KartaprzedmiotuHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Kartaprzedmiotu transientInstance) {
		log.debug("persisting Kartaprzedmiotu instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Kartaprzedmiotu instance) {
		log.debug("attaching dirty Kartaprzedmiotu instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kartaprzedmiotu instance) {
		log.debug("attaching clean Kartaprzedmiotu instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Kartaprzedmiotu persistentInstance) {
		log.debug("deleting Kartaprzedmiotu instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kartaprzedmiotu merge(Kartaprzedmiotu detachedInstance) {
		log.debug("merging Kartaprzedmiotu instance");
		try {
			Kartaprzedmiotu result = (Kartaprzedmiotu) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Kartaprzedmiotu findById(int id) {
		log.debug("getting Kartaprzedmiotu instance with id: " + id);
		try {
			Kartaprzedmiotu instance = (Kartaprzedmiotu) sessionFactory.getCurrentSession().get("Kartaprzedmiotu", id);
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

	public List<Kartaprzedmiotu> findByExample(Kartaprzedmiotu instance) {
		log.debug("finding Kartaprzedmiotu instance by example");
		try {
			List<Kartaprzedmiotu> results = (List<Kartaprzedmiotu>) sessionFactory.getCurrentSession()
					.createCriteria("Kartaprzedmiotu").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
