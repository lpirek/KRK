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
 * Home object for domain model class Kierunkowyefektksztalcenia.
 * @see .Kierunkowyefektksztalcenia
 * @author Hibernate Tools
 */
public class KierunkowyefektksztalceniaHome {

	private static final Log log = LogFactory.getLog(KierunkowyefektksztalceniaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Kierunkowyefektksztalcenia transientInstance) {
		log.debug("persisting Kierunkowyefektksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Kierunkowyefektksztalcenia instance) {
		log.debug("attaching dirty Kierunkowyefektksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kierunkowyefektksztalcenia instance) {
		log.debug("attaching clean Kierunkowyefektksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Kierunkowyefektksztalcenia persistentInstance) {
		log.debug("deleting Kierunkowyefektksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kierunkowyefektksztalcenia merge(Kierunkowyefektksztalcenia detachedInstance) {
		log.debug("merging Kierunkowyefektksztalcenia instance");
		try {
			Kierunkowyefektksztalcenia result = (Kierunkowyefektksztalcenia) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Kierunkowyefektksztalcenia findById(int id) {
		log.debug("getting Kierunkowyefektksztalcenia instance with id: " + id);
		try {
			Kierunkowyefektksztalcenia instance = (Kierunkowyefektksztalcenia) sessionFactory.getCurrentSession()
					.get("Kierunkowyefektksztalcenia", id);
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

	public List<Kierunkowyefektksztalcenia> findByExample(Kierunkowyefektksztalcenia instance) {
		log.debug("finding Kierunkowyefektksztalcenia instance by example");
		try {
			List<Kierunkowyefektksztalcenia> results = (List<Kierunkowyefektksztalcenia>) sessionFactory
					.getCurrentSession().createCriteria("Kierunkowyefektksztalcenia").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
