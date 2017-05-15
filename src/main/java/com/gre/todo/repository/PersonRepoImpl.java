package com.gre.todo.repository;

import com.gre.todo.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jan_R on 14/05/2017.
 */
public class PersonRepoImpl implements PersonRepo {

    private static final Logger logger = LogManager.getLogger(PersonRepoImpl.class);

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

    @Override
    public Person getPersonByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("FROM Person where email =:email");
        query.setParameter("email", email.trim().toLowerCase());
        List<Person> resultList = query.getResultList();
        Person person =null;
        if (resultList!=null && !resultList.isEmpty()){
           person =  resultList.get(0);
        }
        session.close();
        return person;
    }


    public int removePersonByEmail(String email){
        int resutl =0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Person where email =:email");
            query.setParameter("email", email.trim().toLowerCase());
            resutl = query.executeUpdate();
            transaction.commit();
            session.close();

        }catch(Exception ex){
            logger.error("exception " + ex);
            resutl = 0;
        }
        return resutl;
    }
}
