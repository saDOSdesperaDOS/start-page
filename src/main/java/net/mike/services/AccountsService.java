package net.mike.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import net.mike.entities.Account;
import javax.persistence.Query;
	
public class AccountsService {
	
	EntityManager em = Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
		
		public Account create(Account account) {
			em.getTransaction().begin();
	        Account accountFromDB = em.merge(account);
	        em.getTransaction().commit();
	        return  accountFromDB;
		}
}
