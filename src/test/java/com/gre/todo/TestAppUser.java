package com.gre.todo;

import com.gre.todo.model.AppUser;
import com.gre.todo.util.HibernateUtil;
import junit.framework.TestCase;
import org.hibernate.Session;

/**
 * Created by Jan_R on 5/5/2017.
 */
public class TestAppUser extends TestCase
{
	public void testApp()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		AppUser user = new AppUser("testuser");
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}