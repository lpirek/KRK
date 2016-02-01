package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Peknarzedziedydaktyczne;

import static org.hibernate.criterion.Example.create;

public class PeknarzedziedydaktyczneDAO extends DAO{

	private static final Log log = LogFactory.getLog(PeknarzedziedydaktyczneDAO.class);

	public void persist(Peknarzedziedydaktyczne transientInstance) {
		log.debug("persisting Peknarzedziedydaktyczne instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Peknarzedziedydaktyczne instance) {
		log.debug("attaching dirty Peknarzedziedydaktyczne instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Peknarzedziedydaktyczne instance) {
		log.debug("attaching clean Peknarzedziedydaktyczne instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Peknarzedziedydaktyczne persistentInstance) {
		log.debug("deleting Peknarzedziedydaktyczne instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Peknarzedziedydaktyczne merge(Peknarzedziedydaktyczne detachedInstance) {
		log.debug("merging Peknarzedziedydaktyczne instance");
		try {
			Peknarzedziedydaktyczne result = (Peknarzedziedydaktyczne) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Peknarzedziedydaktyczne findById(java.lang.Integer id) {
		log.debug("getting Peknarzedziedydaktyczne instance with id: " + id);
		try {
			Peknarzedziedydaktyczne instance = (Peknarzedziedydaktyczne) sessionFactory.getCurrentSession()
					.get("Peknarzedziedydaktyczne", id);
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

	public List<Peknarzedziedydaktyczne> findByExample(Peknarzedziedydaktyczne instance) {
		log.debug("finding Peknarzedziedydaktyczne instance by example");
		try {
			List<Peknarzedziedydaktyczne> results = (List<Peknarzedziedydaktyczne>) sessionFactory.getCurrentSession()
					.createCriteria("Peknarzedziedydaktyczne").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}