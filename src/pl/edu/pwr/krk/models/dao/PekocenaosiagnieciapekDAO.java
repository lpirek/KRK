package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Pekocenaosiagnieciapek;

import static org.hibernate.criterion.Example.create;

public class PekocenaosiagnieciapekDAO extends DAO{

	private static final Log log = LogFactory.getLog(PekocenaosiagnieciapekDAO.class);

	public void persist(Pekocenaosiagnieciapek transientInstance) {
		log.debug("persisting Pekocenaosiagnieciapek instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Pekocenaosiagnieciapek instance) {
		log.debug("attaching dirty Pekocenaosiagnieciapek instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pekocenaosiagnieciapek instance) {
		log.debug("attaching clean Pekocenaosiagnieciapek instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Pekocenaosiagnieciapek persistentInstance) {
		log.debug("deleting Pekocenaosiagnieciapek instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pekocenaosiagnieciapek merge(Pekocenaosiagnieciapek detachedInstance) {
		log.debug("merging Pekocenaosiagnieciapek instance");
		try {
			Pekocenaosiagnieciapek result = (Pekocenaosiagnieciapek) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pekocenaosiagnieciapek findById(java.lang.Integer id) {
		log.debug("getting Pekocenaosiagnieciapek instance with id: " + id);
		try {
			Pekocenaosiagnieciapek instance = (Pekocenaosiagnieciapek) sessionFactory.getCurrentSession()
					.get("Pekocenaosiagnieciapek", id);
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

	public List<Pekocenaosiagnieciapek> findByExample(Pekocenaosiagnieciapek instance) {
		log.debug("finding Pekocenaosiagnieciapek instance by example");
		try {
			List<Pekocenaosiagnieciapek> results = (List<Pekocenaosiagnieciapek>) sessionFactory.getCurrentSession()
					.createCriteria("Pekocenaosiagnieciapek").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}