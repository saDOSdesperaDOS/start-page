package net.mike.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.mike.entities.AutoPart;


public class AutoPartServices {
	
	EntityManager em = Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
	
	
	public AutoPart add(AutoPart autoPart) {
		em.getTransaction().begin();
		AutoPart autoPartFromDB = em.merge(autoPart);
		em.getTransaction().commit();
		return  autoPartFromDB;
	}
	public void delete(int id) {
		em.getTransaction().begin();
		em.remove(get(id));
		em.getTransaction().commit();
	}
	public AutoPart find(String leaderCode) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM AutoPart e WHERE e.leaderCode=:leaderCode");
		query.setParameter("leaderCode", leaderCode);
		AutoPart autoPart = (AutoPart) query.getSingleResult();
		em.getTransaction().commit();
		return autoPart;
	}
	public AutoPart get(int id) {
		        return em.find(AutoPart.class, id);
	}
	public List<AutoPart> getAllAutoParts() {
		Query query = em.createQuery("SELECT e FROM AutoPart e");
		return  query.getResultList();
	}
}
