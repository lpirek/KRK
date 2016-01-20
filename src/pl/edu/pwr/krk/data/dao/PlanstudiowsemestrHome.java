// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.data.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.data.entities.Planstudiowsemestr;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Planstudiowsemestr.
 * @see .Planstudiowsemestr
 * @author Hibernate Tools
 */
public class PlanstudiowsemestrHome {

	private static final Log log = LogFactory.getLog(PlanstudiowsemestrHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Planstudiowsemestr transientInstance) {
		log.debug("persisting Planstudiowsemestr instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Planstudiowsemestr instance) {
		log.debug("attaching dirty Planstudiowsemestr instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Planstudiowsemestr instance) {
		log.debug("attaching clean Planstudiowsemestr instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Planstudiowsemestr persistentInstance) {
		log.debug("deleting Planstudiowsemestr instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Planstudiowsemestr merge(Planstudiowsemestr detachedInstance) {
		log.debug("merging Planstudiowsemestr instance");
		try {
			Planstudiowsemestr result = (Planstudiowsemestr) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Planstudiowsemestr findById(java.lang.Integer id) {
		log.debug("getting Planstudiowsemestr instance with id: " + id);
		try {
			Planstudiowsemestr instance = (Planstudiowsemestr) sessionFactory.getCurrentSession()
					.get("Planstudiowsemestr", id);
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

	public List<Planstudiowsemestr> findByExample(Planstudiowsemestr instance) {
		log.debug("finding Planstudiowsemestr instance by example");
		try {
			List<Planstudiowsemestr> results = (List<Planstudiowsemestr>) sessionFactory.getCurrentSession()
					.createCriteria("Planstudiowsemestr").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
