// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Programstudiow;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Programstudiow.
 * @see .Programstudiow
 * @author Hibernate Tools
 */
public class ProgramstudiowHome {

	private static final Log log = LogFactory.getLog(ProgramstudiowHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Programstudiow transientInstance) {
		log.debug("persisting Programstudiow instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Programstudiow instance) {
		log.debug("attaching dirty Programstudiow instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Programstudiow instance) {
		log.debug("attaching clean Programstudiow instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Programstudiow persistentInstance) {
		log.debug("deleting Programstudiow instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Programstudiow merge(Programstudiow detachedInstance) {
		log.debug("merging Programstudiow instance");
		try {
			Programstudiow result = (Programstudiow) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Programstudiow findById(java.lang.Integer id) {
		log.debug("getting Programstudiow instance with id: " + id);
		try {
			Programstudiow instance = (Programstudiow) sessionFactory.getCurrentSession().get("Programstudiow", id);
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

	public List<Programstudiow> findByExample(Programstudiow instance) {
		log.debug("finding Programstudiow instance by example");
		try {
			List<Programstudiow> results = (List<Programstudiow>) sessionFactory.getCurrentSession()
					.createCriteria("Programstudiow").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
