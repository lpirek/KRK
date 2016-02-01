package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Mekkek;

import static org.hibernate.criterion.Example.create;

public class MekkekDAO extends DAO{

	private static final Log log = LogFactory.getLog(MekkekDAO.class);

	public void persist(Mekkek transientInstance) {
		log.debug("persisting Mekkek instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Mekkek instance) {
		log.debug("attaching dirty Mekkek instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mekkek instance) {
		log.debug("attaching clean Mekkek instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Mekkek persistentInstance) {
		log.debug("deleting Mekkek instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mekkek merge(Mekkek detachedInstance) {
		log.debug("merging Mekkek instance");
		try {
			Mekkek result = (Mekkek) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Mekkek findById(java.lang.Integer id) {
		log.debug("getting Mekkek instance with id: " + id);
		try {
			Mekkek instance = (Mekkek) sessionFactory.getCurrentSession().get("Mekkek", id);
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

	public List<Mekkek> findByExample(Mekkek instance) {
		log.debug("finding Mekkek instance by example");
		try {
			List<Mekkek> results = (List<Mekkek>) sessionFactory.getCurrentSession().createCriteria("Mekkek")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}