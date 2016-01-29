// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Programksztalceniaobszarksztalcenia;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Programksztalceniaobszarksztalcenia.
 * @see .Programksztalceniaobszarksztalcenia
 * @author Hibernate Tools
 */
public class ProgramksztalceniaobszarksztalceniaHome {

	private static final Log log = LogFactory.getLog(ProgramksztalceniaobszarksztalceniaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Programksztalceniaobszarksztalcenia transientInstance) {
		log.debug("persisting Programksztalceniaobszarksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Programksztalceniaobszarksztalcenia instance) {
		log.debug("attaching dirty Programksztalceniaobszarksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Programksztalceniaobszarksztalcenia instance) {
		log.debug("attaching clean Programksztalceniaobszarksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Programksztalceniaobszarksztalcenia persistentInstance) {
		log.debug("deleting Programksztalceniaobszarksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Programksztalceniaobszarksztalcenia merge(Programksztalceniaobszarksztalcenia detachedInstance) {
		log.debug("merging Programksztalceniaobszarksztalcenia instance");
		try {
			Programksztalceniaobszarksztalcenia result = (Programksztalceniaobszarksztalcenia) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Programksztalceniaobszarksztalcenia findById(java.lang.Integer id) {
		log.debug("getting Programksztalceniaobszarksztalcenia instance with id: " + id);
		try {
			Programksztalceniaobszarksztalcenia instance = (Programksztalceniaobszarksztalcenia) sessionFactory
					.getCurrentSession().get("Programksztalceniaobszarksztalcenia", id);
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

	public List<Programksztalceniaobszarksztalcenia> findByExample(Programksztalceniaobszarksztalcenia instance) {
		log.debug("finding Programksztalceniaobszarksztalcenia instance by example");
		try {
			List<Programksztalceniaobszarksztalcenia> results = (List<Programksztalceniaobszarksztalcenia>) sessionFactory
					.getCurrentSession().createCriteria("Programksztalceniaobszarksztalcenia").add(create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
