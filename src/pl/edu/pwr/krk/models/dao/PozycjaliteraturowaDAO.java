package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Pozycjaliteraturowa;

import static org.hibernate.criterion.Example.create;

public class PozycjaliteraturowaDAO extends DAO{

	private static final Log log = LogFactory.getLog(PozycjaliteraturowaDAO.class);

	public void persist(Pozycjaliteraturowa transientInstance) {
		log.debug("persisting Pozycjaliteraturowa instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Pozycjaliteraturowa instance) {
		log.debug("attaching dirty Pozycjaliteraturowa instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pozycjaliteraturowa instance) {
		log.debug("attaching clean Pozycjaliteraturowa instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Pozycjaliteraturowa persistentInstance) {
		log.debug("deleting Pozycjaliteraturowa instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pozycjaliteraturowa merge(Pozycjaliteraturowa detachedInstance) {
		log.debug("merging Pozycjaliteraturowa instance");
		try {
			Pozycjaliteraturowa result = (Pozycjaliteraturowa) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pozycjaliteraturowa findById(java.lang.Integer id) {
		log.debug("getting Pozycjaliteraturowa instance with id: " + id);
		try {
			Pozycjaliteraturowa instance = (Pozycjaliteraturowa) sessionFactory.getCurrentSession()
					.get("Pozycjaliteraturowa", id);
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

	public List<Pozycjaliteraturowa> findByExample(Pozycjaliteraturowa instance) {
		log.debug("finding Pozycjaliteraturowa instance by example");
		try {
			List<Pozycjaliteraturowa> results = (List<Pozycjaliteraturowa>) sessionFactory.getCurrentSession()
					.createCriteria("Pozycjaliteraturowa").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
