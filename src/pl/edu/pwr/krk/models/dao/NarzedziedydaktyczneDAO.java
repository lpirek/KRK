package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Narzedziedydaktyczne;

import static org.hibernate.criterion.Example.create;

public class NarzedziedydaktyczneDAO extends DAO{

	private static final Log log = LogFactory.getLog(NarzedziedydaktyczneDAO.class);

	public void persist(Narzedziedydaktyczne transientInstance) {
		log.debug("persisting Narzedziedydaktyczne instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Narzedziedydaktyczne instance) {
		log.debug("attaching dirty Narzedziedydaktyczne instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Narzedziedydaktyczne instance) {
		log.debug("attaching clean Narzedziedydaktyczne instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Narzedziedydaktyczne persistentInstance) {
		log.debug("deleting Narzedziedydaktyczne instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Narzedziedydaktyczne merge(Narzedziedydaktyczne detachedInstance) {
		log.debug("merging Narzedziedydaktyczne instance");
		try {
			Narzedziedydaktyczne result = (Narzedziedydaktyczne) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Narzedziedydaktyczne findById(java.lang.Integer id) {
		log.debug("getting Narzedziedydaktyczne instance with id: " + id);
		try {
			Narzedziedydaktyczne instance = (Narzedziedydaktyczne) sessionFactory.getCurrentSession()
					.get("Narzedziedydaktyczne", id);
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

	public List<Narzedziedydaktyczne> findByExample(Narzedziedydaktyczne instance) {
		log.debug("finding Narzedziedydaktyczne instance by example");
		try {
			List<Narzedziedydaktyczne> results = (List<Narzedziedydaktyczne>) sessionFactory.getCurrentSession()
					.createCriteria("Narzedziedydaktyczne").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
