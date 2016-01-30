package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Kurs;

import static org.hibernate.criterion.Example.create;

public class KursDAO extends DAO{

	private static final Log log = LogFactory.getLog(KursDAO.class);

	public void persist(Kurs transientInstance) {
		log.debug("persisting Kurs instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Kurs instance) {
		log.debug("attaching dirty Kurs instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kurs instance) {
		log.debug("attaching clean Kurs instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Kurs persistentInstance) {
		log.debug("deleting Kurs instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kurs merge(Kurs detachedInstance) {
		log.debug("merging Kurs instance");
		try {
			Kurs result = (Kurs) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Kurs findById(java.lang.Integer id) {
		log.debug("getting Kurs instance with id: " + id);
		try {
			Kurs instance = (Kurs) sessionFactory.getCurrentSession().get("Kurs", id);
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

	public List<Kurs> findByExample(Kurs instance) {
		log.debug("finding Kurs instance by example");
		try {
			List<Kurs> results = (List<Kurs>) sessionFactory.getCurrentSession().createCriteria("Kurs")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
