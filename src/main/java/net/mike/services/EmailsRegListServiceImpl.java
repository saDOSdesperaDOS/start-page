package net.mike.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EmailsRegListServiceImpl implements EmailsRegListService {
	EntityManager em = Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
	@Override
	public List<String> getAll() {
		// получаем список всех элементов из нашей таблицы
		// создаем экземпляр списка(new EmaisRegList())
		List<String> busyEmails = new ArrayList<String>();
		// добавляем в него элементы из таблицы
		String e1 = "emai31@google.com";
		String e2 = "email1@mail.com";
		String e3 = "emaileqrg@google.com";
		String e4 = "emailqedfhb@google.com";
		String e5 = "email1@yandex.com";
		String e6 = "email1@yahoo.com";
		String e7 = "email1@google.com";
		busyEmails.add(e1); 
		busyEmails.add(e2); 
		busyEmails.add(e3); 
		busyEmails.add(e4); 
		busyEmails.add(e5); 
		busyEmails.add(e6); 
		busyEmails.add(e7); 
		// возвращаем заполненный список элементами из нашей таблицы
		return busyEmails;
	}

	@Override
	public String create(String email) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
        String emailFromDB = em.merge(email);
        em.getTransaction().commit();
        return  emailFromDB;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		
	}

}
