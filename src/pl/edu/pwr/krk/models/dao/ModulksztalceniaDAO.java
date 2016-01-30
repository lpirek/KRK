package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Modulksztalcenia;

import static org.hibernate.criterion.Example.create;

public class ModulksztalceniaDAO extends DAO{

	private static final Log log = LogFactory.getLog(ModulksztalceniaDAO.class);

	public void persist(Modulksztalcenia transientInstance) {
		log.debug("persisting Modulksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Modulksztalcenia instance) {
		log.debug("attaching dirty Modulksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Modulksztalcenia instance) {
		log.debug("attaching clean Modulksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Modulksztalcenia persistentInstance) {
		log.debug("deleting Modulksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Modulksztalcenia merge(Modulksztalcenia detachedInstance) {
		log.debug("merging Modulksztalcenia instance");
		try {
			Modulksztalcenia result = (Modulksztalcenia) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Modulksztalcenia findById(java.lang.Integer id) {
		log.debug("getting Modulksztalcenia instance with id: " + id);
		try {
			Modulksztalcenia instance = (Modulksztalcenia) sessionFactory.getCurrentSession().get("Modulksztalcenia",
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

	public List<Modulksztalcenia> findByExample(Modulksztalcenia instance) {
		log.debug("finding Modulksztalcenia instance by example");
		try {
			List<Modulksztalcenia> results = (List<Modulksztalcenia>) sessionFactory.getCurrentSession()
					.createCriteria("Modulksztalcenia").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
