// default package
// Generated 2016-01-17 19:44:01 by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Planstudiow.
 * @see .Planstudiow
 * @author Hibernate Tools
 */
public class PlanstudiowHome {

	private static final Log log = LogFactory.getLog(PlanstudiowHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Planstudiow transientInstance) {
		log.debug("persisting Planstudiow instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Planstudiow instance) {
		log.debug("attaching dirty Planstudiow instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Planstudiow instance) {
		log.debug("attaching clean Planstudiow instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Planstudiow persistentInstance) {
		log.debug("deleting Planstudiow instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Planstudiow merge(Planstudiow detachedInstance) {
		log.debug("merging Planstudiow instance");
		try {
			Planstudiow result = (Planstudiow) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Planstudiow findById(java.lang.Integer id) {
		log.debug("getting Planstudiow instance with id: " + id);
		try {
			Planstudiow instance = (Planstudiow) sessionFactory.getCurrentSession().get("Planstudiow", id);
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

	public List<Planstudiow> findByExample(Planstudiow instance) {
		log.debug("finding Planstudiow instance by example");
		try {
			List<Planstudiow> results = (List<Planstudiow>) sessionFactory.getCurrentSession()
					.createCriteria("Planstudiow").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
