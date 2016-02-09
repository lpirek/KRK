package pl.edu.pwr.krk.models.dao;

import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.edu.pwr.krk.models.entities.Celprzedmiotu;
import pl.edu.pwr.krk.models.entities.Kartaprzedmiotu;
import pl.edu.pwr.krk.models.entities.Kekpek;
import pl.edu.pwr.krk.models.entities.Narzedziedydaktyczne;
import pl.edu.pwr.krk.models.entities.Ocenaosiagieciapek;
import pl.edu.pwr.krk.models.entities.Pekcelprzedmiotu;
import pl.edu.pwr.krk.models.entities.Peknarzedziedydaktyczne;
import pl.edu.pwr.krk.models.entities.Pekocenaosiagnieciapek;
import pl.edu.pwr.krk.models.entities.Pektrescprogramowa;
import pl.edu.pwr.krk.models.entities.Pozycjaliteraturowa;
import pl.edu.pwr.krk.models.entities.Przedmiot;
import pl.edu.pwr.krk.models.entities.Przedmiotowyefektksztalcenia;
import pl.edu.pwr.krk.models.entities.Trescprogramowa;
import pl.edu.pwr.krk.models.entities.Uzytkownik;
import pl.edu.pwr.krk.models.entities.Wymaganiawstepne;

import static org.hibernate.criterion.Example.create;

public class KartaprzedmiotuDAO extends DAO {

	private static final Log log = LogFactory.getLog(KartaprzedmiotuDAO.class);

	public Kartaprzedmiotu findById(int id) {

		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Kartaprzedmiotu.class);
			criteria.add(Restrictions.eq("id", id));

			Kartaprzedmiotu instance = (Kartaprzedmiotu) criteria.uniqueResult();

			tx.commit();
			
			Hibernate.initialize(instance.getCelprzedmiotus());
			Hibernate.initialize(instance.getNarzedziedydaktycznes());
			Hibernate.initialize(instance.getPrzedmiotowyefektksztalcenias());
			Hibernate.initialize(instance.getTrescprogramowas());
			Hibernate.initialize(instance.getWymaganiawstepnes());
			Hibernate.initialize(instance.getOcenaosiagieciapeks());
			Hibernate.initialize(instance.getPozycjaliteraturowas());

			Hibernate.initialize(instance.getPrzedmiot());
			Hibernate.initialize(instance.getPrzedmiot().getModulksztalcenia());
			Hibernate.initialize(instance.getPrzedmiot().getModulksztalcenia().getProgramstudiow());
			Hibernate.initialize(instance.getPrzedmiot().getModulksztalcenia().getProgramstudiow().getProgramksztalcenia());
			Hibernate.initialize(instance.getPrzedmiot().getModulksztalcenia().getProgramstudiow().getProgramksztalcenia().getKierunekstudiow());
			
			Hibernate.initialize(instance.getPrzedmiot().getKurses());
			Hibernate.initialize(instance.getPrzedmiot().getGrupakursows());
			
			return instance;

		} catch (RuntimeException exception) {
			log.error("get failed", exception);
			throw exception;
		} finally {
			session.close();
		}
	}

	public List<Kartaprzedmiotu> findKartyPrzedmiotu(int przedmiotId) {

		Session session = null;
		List<Kartaprzedmiotu> result = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Kartaprzedmiotu.class);
			criteria.add(Restrictions.eq("przedmiot.id", przedmiotId));

			result = new ArrayList<Kartaprzedmiotu>(criteria.list());

			tx.commit();

			return result;

		} catch (RuntimeException exception) {
			log.error("get failed", exception);
			throw exception;
		} finally {
			session.close();
		}
	}

	public int saveOrUpdate(Kartaprzedmiotu subjectCard) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.saveOrUpdate(subjectCard);
			
			for(Celprzedmiotu cel : subjectCard.getCelprzedmiotus()) {
				session.save(cel);
			}
			
			for(Narzedziedydaktyczne tool : subjectCard.getNarzedziedydaktycznes()) {
				session.saveOrUpdate(tool);
			}
			
			for(Pozycjaliteraturowa lit : subjectCard.getPozycjaliteraturowas()) {
				session.saveOrUpdate(lit);
			}
			
			for(Wymaganiawstepne wym : subjectCard.getWymaganiawstepnes()) {
				session.saveOrUpdate(wym);
			}
			
			for(Trescprogramowa tre : subjectCard.getTrescprogramowas()) {
				session.saveOrUpdate(tre);
			}
			
			for(Przedmiotowyefektksztalcenia pek : subjectCard.getPrzedmiotowyefektksztalcenias()) {
				session.saveOrUpdate(pek);
			}
			
			for(Ocenaosiagieciapek oc : subjectCard.getOcenaosiagieciapeks()) {
				session.saveOrUpdate(oc);
				
				for(Pekocenaosiagnieciapek op : oc.getPekocenaosiagnieciapeks()) {
					session.saveOrUpdate(op);
				}
			}
			
			for(Przedmiotowyefektksztalcenia pek : subjectCard.getPrzedmiotowyefektksztalcenias()) {

				for(Peknarzedziedydaktyczne pn : pek.getPeknarzedziedydaktycznes()) {
					session.saveOrUpdate(pn);
				}	
				
				for(Pekcelprzedmiotu pc : pek.getPekcelprzedmiotus()) {
					session.saveOrUpdate(pc);
				}	
				
				for(Kekpek kp : pek.getKekpeks()) {
					session.saveOrUpdate(kp);
				}
				
				for(Pektrescprogramowa pt : pek.getPektrescprogramowas()) {
					session.saveOrUpdate(pt);
				}
					
					
			}
			
			session.flush();
			
			session.getTransaction().commit();
			
		} catch (RuntimeException exception) {
			log.error("get failed", exception);
			throw exception;
		} finally {
			session.close();
		}
		
		return subjectCard.getId();
	}
}
