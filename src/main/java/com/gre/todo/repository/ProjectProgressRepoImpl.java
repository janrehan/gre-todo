package com.gre.todo.repository;

import com.gre.todo.model.Project;
import com.gre.todo.model.ProjectProgress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan_R on 06/05/2017.
 */
public class ProjectProgressRepoImpl implements ProjectProgressRepo {
    private static final Logger logger = LogManager.getLogger(ProjectProgressRepoImpl.class);

    /**
     * find project's associated buildings, person and status info
     * by projectId, buildingId and personId
     *
     * @param projectId
     * @return
     */
    @Override
    public List<ProjectProgress> findProjectProgressBy(Long projectId, Long buildingId, Long personId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<ProjectProgress> projectProgressRoot = criteriaQuery.from(ProjectProgress.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (projectId != null) {
            predicates.add(
                    criteriaBuilder.equal(projectProgressRoot.get("project").get("id"), projectId));
        }
        if (buildingId != null) {
            predicates.add(
                    criteriaBuilder.equal(projectProgressRoot.get("building").get("id"), buildingId));
        }
        if (personId != null) {
            predicates.add(
                    criteriaBuilder.equal(projectProgressRoot.get("person").get("id"), personId));
        }

        criteriaQuery.select(projectProgressRoot).where(predicates.toArray(new Predicate[]{}));

        List<ProjectProgress> resultList = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return resultList;
    }

    /**
     * get all projects
     *
     * @return
     */
    @Override
    public List<Project> findAllProjects() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Project");
        List<Project> resultList = query.getResultList();
        session.close();
        return resultList;
    }

}
