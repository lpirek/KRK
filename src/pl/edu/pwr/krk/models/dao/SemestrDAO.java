package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Semestr;

import static org.hibernate.criterion.Example.create;

public class SemestrDAO extends DAO{

	private static final Log log = LogFactory.getLog(SemestrDAO.class);
	
	public void persist(Semestr transientInstance) {
		log.debug("persisting Semestr instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Semestr instance) {
		log.debug("attaching dirty Semestr instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Semestr instance) {
		log.debug("attaching clean Semestr instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Semestr persistentInstance) {
		log.debug("deleting Semestr instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Semestr merge(Semestr detachedInstance) {
		log.debug("merging Semestr instance");
		try {
			Semestr result = (Semestr) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Semestr findById(java.lang.Integer id) {
		log.debug("getting Semestr instance with id: " + id);
		try {
			Semestr instance = (Semestr) sessionFactory.getCurrentSession().get("Semestr", id);
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

	public List<Semestr> findByExample(Semestr instance) {
		log.debug("finding Semestr instance by example");
		try {
			List<Semestr> results = (List<Semestr>) sessionFactory.getCurrentSession().createCriteria("Semestr")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}