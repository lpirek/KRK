package pl.edu.pwr.krk.models.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import pl.edu.pwr.krk.models.entities.Kierunkowyefektksztalcenia;

import static org.hibernate.criterion.Example.create;

public class KierunkowyefektksztalceniaDAO extends DAO{

	private static final Log log = LogFactory.getLog(KierunkowyefektksztalceniaDAO.class);

	public void persist(Kierunkowyefektksztalcenia transientInstance) {
		log.debug("persisting Kierunkowyefektksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Kierunkowyefektksztalcenia instance) {
		log.debug("attaching dirty Kierunkowyefektksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kierunkowyefektksztalcenia instance) {
		log.debug("attaching clean Kierunkowyefektksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Kierunkowyefektksztalcenia persistentInstance) {
		log.debug("deleting Kierunkowyefektksztalcenia instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kierunkowyefektksztalcenia merge(Kierunkowyefektksztalcenia detachedInstance) {
		log.debug("merging Kierunkowyefektksztalcenia instance");
		try {
			Kierunkowyefektksztalcenia result = (Kierunkowyefektksztalcenia) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Kierunkowyefektksztalcenia findById(int id) {
		log.debug("getting Kierunkowyefektksztalcenia instance with id: " + id);
		try {
			Kierunkowyefektksztalcenia instance = (Kierunkowyefektksztalcenia) sessionFactory.getCurrentSession()
					.get("Kierunkowyefektksztalcenia", id);
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

	public List<Kierunkowyefektksztalcenia> findByExample(Kierunkowyefektksztalcenia instance) {
		log.debug("finding Kierunkowyefektksztalcenia instance by example");
		try {
			List<Kierunkowyefektksztalcenia> results = (List<Kierunkowyefektksztalcenia>) sessionFactory
					.getCurrentSession().createCriteria("Kierunkowyefektksztalcenia").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
