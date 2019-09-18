package net.mike.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.mike.entities.Account;
	
public class AccountsService {
	
	EntityManager em = Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
		
		public Account create(Account account) {
			em.getTransaction().begin();
	        Account accountFromDB = em.merge(account);
	        em.getTransaction().commit();
	        return  accountFromDB;
		}
		
		public List<Account> getAllAccounts() {
			//em.getTransaction().begin();
			Query query = em.createQuery("SELECT e FROM Account e");
			return  query.getResultList();
		}
		
		public void remove(int id) {
			em.getTransaction().begin();
		    em.remove(find(id));
		    em.getTransaction().commit();
		}
		
		public Account find(int id) {
		    return em.find(Account.class, id);
		}
		
		public List<String> getAllEmail() {
			Query query = em.createQuery("SELECT e.email FROM Account e");
			return query.getResultList();
		}
		
}
