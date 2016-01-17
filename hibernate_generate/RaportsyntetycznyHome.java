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
 * Home object for domain model class Raportsyntetyczny.
 * @see .Raportsyntetyczny
 * @author Hibernate Tools
 */
public class RaportsyntetycznyHome {

	private static final Log log = LogFactory.getLog(RaportsyntetycznyHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Raportsyntetyczny transientInstance) {
		log.debug("persisting Raportsyntetyczny instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Raportsyntetyczny instance) {
		log.debug("attaching dirty Raportsyntetyczny instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Raportsyntetyczny instance) {
		log.debug("attaching clean Raportsyntetyczny instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Raportsyntetyczny persistentInstance) {
		log.debug("deleting Raportsyntetyczny instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Raportsyntetyczny merge(Raportsyntetyczny detachedInstance) {
		log.debug("merging Raportsyntetyczny instance");
		try {
			Raportsyntetyczny result = (Raportsyntetyczny) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Raportsyntetyczny findById(java.lang.Integer id) {
		log.debug("getting Raportsyntetyczny instance with id: " + id);
		try {
			Raportsyntetyczny instance = (Raportsyntetyczny) sessionFactory.getCurrentSession().get("Raportsyntetyczny",
					id);
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

	public List<Raportsyntetyczny> findByExample(Raportsyntetyczny instance) {
		log.debug("finding Raportsyntetyczny instance by example");
		try {
			List<Raportsyntetyczny> results = (List<Raportsyntetyczny>) sessionFactory.getCurrentSession()
					.createCriteria("Raportsyntetyczny").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
