package com.gre.todo.repository;

import com.gre.todo.model.Building;
import com.gre.todo.model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Jan_R on 14/05/2017.
 */
public class BuildingRepoImpl implements BuildingRepo {

    @Override
    public void saveBuilding(Building building) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(building);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Building> getAllBuildings() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Building");
        List<Building> resultList = query.getResultList();
        session.close();
        return resultList;
    }

}
