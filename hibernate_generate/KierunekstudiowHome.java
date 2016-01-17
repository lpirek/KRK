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
 * Home object for domain model class Kierunekstudiow.
 * @see .Kierunekstudiow
 * @author Hibernate Tools
 */
public class KierunekstudiowHome {

	private static final Log log = LogFactory.getLog(KierunekstudiowHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Kierunekstudiow transientInstance) {
		log.debug("persisting Kierunekstudiow instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Kierunekstudiow instance) {
		log.debug("attaching dirty Kierunekstudiow instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kierunekstudiow instance) {
		log.debug("attaching clean Kierunekstudiow instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Kierunekstudiow persistentInstance) {
		log.debug("deleting Kierunekstudiow instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kierunekstudiow merge(Kierunekstudiow detachedInstance) {
		log.debug("merging Kierunekstudiow instance");
		try {
			Kierunekstudiow result = (Kierunekstudiow) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Kierunekstudiow findById(int id) {
		log.debug("getting Kierunekstudiow instance with id: " + id);
		try {
			Kierunekstudiow instance = (Kierunekstudiow) sessionFactory.getCurrentSession().get("Kierunekstudiow", id);
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

	public List<Kierunekstudiow> findByExample(Kierunekstudiow instance) {
		log.debug("finding Kierunekstudiow instance by example");
		try {
			List<Kierunekstudiow> results = (List<Kierunekstudiow>) sessionFactory.getCurrentSession()
					.createCriteria("Kierunekstudiow").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
