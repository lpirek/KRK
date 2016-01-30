package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Wydzial;

import static org.hibernate.criterion.Example.create;

public class WydzialDAO extends DAO{

	private static final Log log = LogFactory.getLog(WydzialDAO.class);

	public void persist(Wydzial transientInstance) {
		log.debug("persisting Wydzial instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Wydzial instance) {
		log.debug("attaching dirty Wydzial instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Wydzial instance) {
		log.debug("attaching clean Wydzial instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Wydzial persistentInstance) {
		log.debug("deleting Wydzial instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Wydzial merge(Wydzial detachedInstance) {
		log.debug("merging Wydzial instance");
		try {
			Wydzial result = (Wydzial) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Wydzial findById(int id) {
		log.debug("getting Wydzial instance with id: " + id);
		try {
			Wydzial instance = (Wydzial) sessionFactory.getCurrentSession().get("Wydzial", id);
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

	public List<Wydzial> findByExample(Wydzial instance) {
		log.debug("finding Wydzial instance by example");
		try {
			List<Wydzial> results = (List<Wydzial>) sessionFactory.getCurrentSession().createCriteria("Wydzial")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
