package com.gre.todo.repository;

import com.gre.todo.model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Jan_R on 14/05/2017.
 */
public class PersonRepoImpl implements PersonRepo {

    @Override
    public void savePerson(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(person);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Person> getAllPersons() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Person");
        List<Person> resultList = query.getResultList();
        session.close();
        return resultList;
    }



}
