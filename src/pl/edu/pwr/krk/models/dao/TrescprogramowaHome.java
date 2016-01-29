// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Trescprogramowa;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Trescprogramowa.
 * @see .Trescprogramowa
 * @author Hibernate Tools
 */
public class TrescprogramowaHome {

	private static final Log log = LogFactory.getLog(TrescprogramowaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Trescprogramowa transientInstance) {
		log.debug("persisting Trescprogramowa instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Trescprogramowa instance) {
		log.debug("attaching dirty Trescprogramowa instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Trescprogramowa instance) {
		log.debug("attaching clean Trescprogramowa instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Trescprogramowa persistentInstance) {
		log.debug("deleting Trescprogramowa instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Trescprogramowa merge(Trescprogramowa detachedInstance) {
		log.debug("merging Trescprogramowa instance");
		try {
			Trescprogramowa result = (Trescprogramowa) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Trescprogramowa findById(java.lang.Integer id) {
		log.debug("getting Trescprogramowa instance with id: " + id);
		try {
			Trescprogramowa instance = (Trescprogramowa) sessionFactory.getCurrentSession().get("Trescprogramowa", id);
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

	public List<Trescprogramowa> findByExample(Trescprogramowa instance) {
		log.debug("finding Trescprogramowa instance by example");
		try {
			List<Trescprogramowa> results = (List<Trescprogramowa>) sessionFactory.getCurrentSession()
					.createCriteria("Trescprogramowa").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
