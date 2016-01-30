package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Kierunekstudiow;

import static org.hibernate.criterion.Example.create;

public class KierunekstudiowDAO extends DAO{

	private static final Log log = LogFactory.getLog(KierunekstudiowDAO.class);

	public void persist(Kierunekstudiow transientInstance) {
		log.debug("persisting Kierunekstudiow instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Kierunekstudiow instance) {
		log.debug("attaching dirty Kierunekstudiow instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kierunekstudiow instance) {
		log.debug("attaching clean Kierunekstudiow instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Kierunekstudiow persistentInstance) {
		log.debug("deleting Kierunekstudiow instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kierunekstudiow merge(Kierunekstudiow detachedInstance) {
		log.debug("merging Kierunekstudiow instance");
		try {
			Kierunekstudiow result = (Kierunekstudiow) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Kierunekstudiow findById(int id) {
		log.debug("getting Kierunekstudiow instance with id: " + id);
		try {
			Kierunekstudiow instance = (Kierunekstudiow) sessionFactory.getCurrentSession().get("Kierunekstudiow", id);
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

	public List<Kierunekstudiow> findByExample(Kierunekstudiow instance) {
		log.debug("finding Kierunekstudiow instance by example");
		try {
			List<Kierunekstudiow> results = (List<Kierunekstudiow>) sessionFactory.getCurrentSession()
					.createCriteria("Kierunekstudiow").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
