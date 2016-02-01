// default package
// Generated 2016-01-20 20:46:00 by Hibernate Tools 4.0.0
package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Celprzedmiotu;

import static org.hibernate.criterion.Example.create;

public class CelprzedmiotuDAO extends DAO {

	private static final Log log = LogFactory.getLog(CelprzedmiotuDAO.class);

	public void persist(Celprzedmiotu transientInstance) {
		log.debug("persisting Celprzedmiotu instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Celprzedmiotu instance) {
		log.debug("attaching dirty Celprzedmiotu instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Celprzedmiotu instance) {
		log.debug("attaching clean Celprzedmiotu instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Celprzedmiotu persistentInstance) {
		log.debug("deleting Celprzedmiotu instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Celprzedmiotu merge(Celprzedmiotu detachedInstance) {
		log.debug("merging Celprzedmiotu instance");
		try {
			Celprzedmiotu result = (Celprzedmiotu) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Celprzedmiotu findById(int id) {
		log.debug("getting Celprzedmiotu instance with id: " + id);
		try {
			Celprzedmiotu instance = (Celprzedmiotu) sessionFactory.getCurrentSession().get("Celprzedmiotu", id);
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

	public List<Celprzedmiotu> findByExample(Celprzedmiotu instance) {
		log.debug("finding Celprzedmiotu instance by example");
		try {
			List<Celprzedmiotu> results = (List<Celprzedmiotu>) sessionFactory.getCurrentSession()
					.createCriteria("Celprzedmiotu").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}