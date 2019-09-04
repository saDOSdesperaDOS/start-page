 package net.mike;

import net.mike.services.EmailsRegListService;
import net.mike.services.EmailsRegListServiceImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
  public static void main(String[] fuck) {
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
      EntityManager em = emf.createEntityManager();
      System.out.println(em.getProperties());
      EmailsRegListService sqlRequest = new EmailsRegListServiceImpl();
      sqlRequest.create("dssdf@ebhqnb.com");
  }
}
