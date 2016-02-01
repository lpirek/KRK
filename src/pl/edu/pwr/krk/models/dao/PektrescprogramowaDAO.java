package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Pektrescprogramowa;

import static org.hibernate.criterion.Example.create;

public class PektrescprogramowaDAO extends DAO{

	private static final Log log = LogFactory.getLog(PektrescprogramowaDAO.class);

	public void persist(Pektrescprogramowa transientInstance) {
		log.debug("persisting Pektrescprogramowa instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Pektrescprogramowa instance) {
		log.debug("attaching dirty Pektrescprogramowa instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pektrescprogramowa instance) {
		log.debug("attaching clean Pektrescprogramowa instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Pektrescprogramowa persistentInstance) {
		log.debug("deleting Pektrescprogramowa instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pektrescprogramowa merge(Pektrescprogramowa detachedInstance) {
		log.debug("merging Pektrescprogramowa instance");
		try {
			Pektrescprogramowa result = (Pektrescprogramowa) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pektrescprogramowa findById(java.lang.Integer id) {
		log.debug("getting Pektrescprogramowa instance with id: " + id);
		try {
			Pektrescprogramowa instance = (Pektrescprogramowa) sessionFactory.getCurrentSession()
					.get("Pektrescprogramowa", id);
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

	public List<Pektrescprogramowa> findByExample(Pektrescprogramowa instance) {
		log.debug("finding Pektrescprogramowa instance by example");
		try {
			List<Pektrescprogramowa> results = (List<Pektrescprogramowa>) sessionFactory.getCurrentSession()
					.createCriteria("Pektrescprogramowa").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}