package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Programksztalcenia;

import static org.hibernate.criterion.Example.create;

public class ProgramksztalceniaDAO extends DAO {

	private static final Log log = LogFactory.getLog(ProgramksztalceniaDAO.class);

	public void persist(Programksztalcenia transientInstance) {
		log.debug("persisting Programksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Programksztalcenia instance) {
		log.debug("attaching dirty Programksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Programksztalcenia instance) {
		log.debug("attaching clean Programksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Programksztalcenia persistentInstance) {
		log.debug("deleting Programksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Programksztalcenia merge(Programksztalcenia detachedInstance) {
		log.debug("merging Programksztalcenia instance");
		try {
			Programksztalcenia result = (Programksztalcenia) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Programksztalcenia findById(int id) {
		log.debug("getting Programksztalcenia instance with id: " + id);
		try {
			Programksztalcenia instance = (Programksztalcenia) sessionFactory.getCurrentSession()
					.get("Programksztalcenia", id);
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

	public List<Programksztalcenia> findByExample(Programksztalcenia instance) {
		log.debug("finding Programksztalcenia instance by example");
		try {
			List<Programksztalcenia> results = (List<Programksztalcenia>) sessionFactory.getCurrentSession()
					.createCriteria("Programksztalcenia").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
