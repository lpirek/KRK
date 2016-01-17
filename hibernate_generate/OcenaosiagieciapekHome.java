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
 * Home object for domain model class Ocenaosiagieciapek.
 * @see .Ocenaosiagieciapek
 * @author Hibernate Tools
 */
public class OcenaosiagieciapekHome {

	private static final Log log = LogFactory.getLog(OcenaosiagieciapekHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Ocenaosiagieciapek transientInstance) {
		log.debug("persisting Ocenaosiagieciapek instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ocenaosiagieciapek instance) {
		log.debug("attaching dirty Ocenaosiagieciapek instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ocenaosiagieciapek instance) {
		log.debug("attaching clean Ocenaosiagieciapek instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ocenaosiagieciapek persistentInstance) {
		log.debug("deleting Ocenaosiagieciapek instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ocenaosiagieciapek merge(Ocenaosiagieciapek detachedInstance) {
		log.debug("merging Ocenaosiagieciapek instance");
		try {
			Ocenaosiagieciapek result = (Ocenaosiagieciapek) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ocenaosiagieciapek findById(java.lang.Integer id) {
		log.debug("getting Ocenaosiagieciapek instance with id: " + id);
		try {
			Ocenaosiagieciapek instance = (Ocenaosiagieciapek) sessionFactory.getCurrentSession()
					.get("Ocenaosiagieciapek", id);
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

	public List<Ocenaosiagieciapek> findByExample(Ocenaosiagieciapek instance) {
		log.debug("finding Ocenaosiagieciapek instance by example");
		try {
			List<Ocenaosiagieciapek> results = (List<Ocenaosiagieciapek>) sessionFactory.getCurrentSession()
					.createCriteria("Ocenaosiagieciapek").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
