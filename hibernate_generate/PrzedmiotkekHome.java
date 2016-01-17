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
 * Home object for domain model class Przedmiotkek.
 * @see .Przedmiotkek
 * @author Hibernate Tools
 */
public class PrzedmiotkekHome {

	private static final Log log = LogFactory.getLog(PrzedmiotkekHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Przedmiotkek transientInstance) {
		log.debug("persisting Przedmiotkek instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Przedmiotkek instance) {
		log.debug("attaching dirty Przedmiotkek instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Przedmiotkek instance) {
		log.debug("attaching clean Przedmiotkek instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Przedmiotkek persistentInstance) {
		log.debug("deleting Przedmiotkek instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Przedmiotkek merge(Przedmiotkek detachedInstance) {
		log.debug("merging Przedmiotkek instance");
		try {
			Przedmiotkek result = (Przedmiotkek) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Przedmiotkek findById(PrzedmiotkekId id) {
		log.debug("getting Przedmiotkek instance with id: " + id);
		try {
			Przedmiotkek instance = (Przedmiotkek) sessionFactory.getCurrentSession().get("Przedmiotkek", id);
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

	public List<Przedmiotkek> findByExample(Przedmiotkek instance) {
		log.debug("finding Przedmiotkek instance by example");
		try {
			List<Przedmiotkek> results = (List<Przedmiotkek>) sessionFactory.getCurrentSession()
					.createCriteria("Przedmiotkek").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
